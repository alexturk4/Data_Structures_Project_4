package com.company;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        readFlightData();

        readFlightPlans();
    }

    public static void readFlightData() {
        int numOfFlights;
        try {
            // reads the information from the books from a file called flightData.txt
            Scanner input = new Scanner(new File("flightData.txt"));

            numOfFlights = Integer.parseInt(input.nextLine());


            while (input.hasNext()) {
                String line = input.nextLine();

                // this takes out the origin city
                String origin = line.substring(0,line.indexOf("|"));

                // remove the origin city from the string
                line = line.substring(line.indexOf("|") + 1);

                String destination = line.substring(0,line.indexOf("|"));

                // remove the destination city from the string
                line = line.substring(line.indexOf("|") + 1);/**/

                int cost = Integer.parseInt(line.substring(0,line.indexOf("|")));

                // remove the cost from the string
                line = line.substring(line.indexOf("|") + 1);

                // store the time
                int time = Integer.parseInt(line);

                System.out.println(" " + origin + " " + destination + " " + cost + " " + time);
            }
        } catch (IOException e) {
            System.out.println("Error reading file");
        }
    }

    public static void readFlightPlans() {
        int numOfFlights;
        try {
            // reads the information from the books from a file called flightPlans.txt
            Scanner input = new Scanner(new File("flightPlans.txt"));

            numOfFlights = Integer.parseInt(input.nextLine());

            while (input.hasNext()) {
                String line = input.nextLine();

                // this takes out the origin city
                String origin = line.substring(0, line.indexOf("|"));

                // remove the origin city from the string
                line = line.substring(line.indexOf("|") + 1);

                String destination = line.substring(0, line.indexOf("|"));

                // remove the destination city from the string
                line = line.substring(line.indexOf("|") + 1);

                String timeOrCost = line;

                System.out.println(origin + " " + destination + " " + timeOrCost);
            }
        } catch (IOException e) {
            System.out.println("Error reading file");
        }

    }


}
