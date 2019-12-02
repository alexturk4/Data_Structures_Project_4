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

        LinkedList<Node> sublist1 = new LinkedList<>();
        LinkedList<Node> sublist2 = new LinkedList<>();

        sublist1.add(original);
        sublist2.add(reverse);

        list.add(sublist1);
        list.add(sublist2);
    }


}
