package com.example.arhomeimprovement;

public class Globals {

    private static Globals instance;

    private static boolean visitedScan  = false;
    private static boolean visitedCreateRoom = false;
    private static boolean visitedViewScannedRooms = false;

    private Globals(){

    }

    public void setVisitedScan(){
        visitedScan = true;
    }

    public boolean getVisitedScan(){
        return visitedScan;
    }

    public void setVisitedCreateRoom(){
        visitedCreateRoom = true;
    }

    public boolean getVisitedCreateRoom(){
        return visitedCreateRoom;
    }

    public void setVisitedViewScannedRooms(){
        visitedViewScannedRooms = true;
    }

    public boolean getVisitedViewScannedRooms(){
        return visitedViewScannedRooms;
    }

    public static synchronized Globals getInstance(){
        if(instance == null){
            instance = new Globals();
        }
        return instance;
    }
}
