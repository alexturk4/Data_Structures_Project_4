package com.company;

import java.util.ArrayList;
import java.util.LinkedList;

public class Graph {

    LinkedList<LinkedList<Node>> list;
    // default constructor
    Graph (){
        list = new LinkedList<>();
    }

    void addEdge(String origin, String destination, int time, int cost){
        Node original = new Node(origin, destination, time, cost);

        // since the graph is undirected, we will add a node containing the reverse direction also
        Node reverse = new Node(destination, origin, time, cost);

        // flags to determine if the node has already been added into the list
        Boolean addOrig = false, addRev = false;

        // We must first iterate through outer list
        for (int i = 0; i < list.size(); i++) {
            LinkedList<Node> sublist = list.get(i);

            // if the first element in the sublist has the same origin as our new node, then add it to this list
            if (list.get(i).get(0).getOrigin().equals(origin)){
                list.get(i).add(original);
                addOrig = true;
            }

            // do the same for the destination since this is an undirected graph
            if (list.get(i).get(0).getOrigin().equals(destination)){
                list.get(i).add(reverse);
                addRev = true;
            }

        }

        // if we iterated through and the origin city is not in the list, then add it
        if (!addOrig){
            LinkedList<Node> sublist = new LinkedList<>();
            sublist.add(original);
            list.add(sublist);
        }

        // if we iterated through and the destination city is not in the list, then add it
        if (!addRev){
            LinkedList<Node> sublist = new LinkedList<>();
            sublist.add(reverse);
            list.add(sublist);
        }
    }

    LinkedList<Node> getListOfCity(String origin){
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).get(0).getOrigin().equals(origin))
                return list.get(i);
        }

        return null;
    }

    private Boolean arePathsEqual(LinkedList<Node>[] existingPath, LinkedList<Node> newPath){
        for (int i = 0; i< existingPath.length; i++){

            // if there have been no other paths computed, then they won't be equal
            if (existingPath[i] == null)
                if (i==0)
                    return false;
                else
                    break;

            for (int j = 0; j < existingPath[i].size(); j++){
                if (!areNodesEqual(existingPath[i].get(j), newPath.get(j))){
                    return false;
                }
            }
        }

        return true;
    }

    private Boolean areNodesEqual(Node a, Node b){
        if (a.getOrigin().equals(b.getOrigin()) && a.getDestination().equals(b.getDestination()))
            return true;
        else
            return false;
    }

    void calculatePaths(String origin, String destination, char timeOrCost) {
        LinkedList<Node> startingList = getListOfCity(origin);
        LinkedList<Node>[] paths = new LinkedList[3];
        LinkedList<Node> defaultPaths = new LinkedList<>();

       for(int i = 0; i< 3; i++){
           paths[i] = recursivePathCalculation(origin, destination, startingList, defaultPaths, paths);
       }

       System.out.print("hello");
    }

    private LinkedList<Node> recursivePathCalculation(String origin, String destination, LinkedList<Node> startingList, LinkedList<Node> path, LinkedList<Node>[] existingPaths){
        for (int i = 0; i < startingList.size(); i++) {
            Node currentNode = startingList.get(i);

            // if the list contains the destination, add it to the list and then return the path list
            if (currentNode.getDestination().equals(destination)) {
                LinkedList<Node> newPath = (LinkedList)path.clone();
                newPath.add(currentNode);

                if (!arePathsEqual(existingPaths, newPath))
                    return newPath;
            }
        }

        for (int i = 0; i < startingList.size(); i++){
            Node currentNode = startingList.get(i);

            // create a new list of the visited node
            if (!currentNode.getDestination().equals(destination) && !currentNode.getDestination().equals(origin)) {
                LinkedList<Node> newList = getListOfCity(currentNode.getDestination());

                LinkedList<Node> newPath = (LinkedList) path.clone();
                newPath.add(currentNode);

                return recursivePathCalculation(origin, destination, newList, newPath, existingPaths);
            }
        }


        // if there is no available path, then return null
        return null;
    }

}
