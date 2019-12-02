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


}
