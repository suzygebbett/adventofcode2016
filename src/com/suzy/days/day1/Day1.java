package com.suzy.days.day1;

import javax.xml.stream.Location;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day1 {

    public static void main(String[] args) {
        File myFile = new File("C:\\Users\\sgebbett001\\IdeaProjects\\adventofcode2016\\src\\com\\suzy\\days\\day1\\input.txt");
        String directions = new String();

        try {
            Scanner sc = new Scanner(myFile);
            directions = sc.nextLine();
            System.out.printf(directions + "%n");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String[] directionsList = directions.split(", ");
        LocationTracker locationTracker = new LocationTracker();
        for (String dir: directionsList){
            System.out.println(dir);
            String turnDirection = dir.substring(0,1);
            int stringDistance = Integer.parseInt(dir.substring(1));
            locationTracker.whereNow(turnDirection,stringDistance);
        }

        System.out.println(locationTracker.getAnswer());

    }
}
class LocationTracker {
    private int xFromOrigin = 0;
    private int yFromOrigin = 0;
    private String direction = "N";

    public int getxFromOrigin() {
        return xFromOrigin;
    }

    public int getyFromOrigin() {
        return yFromOrigin;
    }

    public String getDirection() {
        return direction;
    }

    public int getAnswer() {
        return Math.abs(xFromOrigin) + Math.abs(yFromOrigin);
    }

    public void whereNow(String turnDirection, int distance){
        switch (direction){
            case "N":
                if (turnDirection.equals("L")) direction = "W";
                if (turnDirection.equals("R")) direction = "E";
                break;

            case "S":
                if (turnDirection.equals("L")) direction = "E";
                if (turnDirection.equals("R")) direction = "W";
                break;

            case "E":
                if (turnDirection.equals("L")) direction = "N";
                if (turnDirection.equals("R")) direction = "S";
                break;

            case "W":
                if (turnDirection.equals("L")) direction = "S";
                if (turnDirection.equals("R")) direction = "N";
                break;
        }
        switch (direction){
            case "N":
                yFromOrigin += distance;
                break;
            case "S":
                yFromOrigin -= distance;
                break;
            case "E":
                xFromOrigin += distance;
                break;
            case "W":
                xFromOrigin -= distance;
                break;
        }


    }
}
