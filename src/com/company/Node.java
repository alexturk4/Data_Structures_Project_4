package com.company;

public class Node {
    String origin, destination;
    int cost,time;

    // constructor
    Node(String o, String d, int c, int t) {
        origin = o;
        destination = d;
        cost = c;
        time = t;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDestination() {
        return destination;
    }

    public int getCost() {
        return cost;
    }

    public int getTime() {
        return time;
    }
}

