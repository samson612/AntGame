/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package group16.antgame.world;

import group16.antgame.ant.AntBrain;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author cc483
 */
public class Tournament {
    private final World[] listOfWorld;
    private final AntBrain[] listOfBrain;
    private final String[] listOfPlayer;
    private final int numOfPlayer;
    private final int numOfWorld;
    private ArrayList<World> matchsWorld;
    private ArrayList<String> matchsInfo;
    
    public Tournament(World[] listOfWorld, AntBrain[] listOfBrain, String[] listOfPlayer,int numOfPlayer,int numOfWorld){
        this.listOfWorld = listOfWorld;
        this.listOfBrain = listOfBrain;
        this.listOfPlayer = listOfPlayer;
        this.numOfPlayer = numOfPlayer;
        this.numOfWorld = numOfWorld;
        this.matchsWorld = new ArrayList();
        this.matchsInfo = new ArrayList();
    }
    public void Matching()
    {
        for(int i = 0; i < numOfPlayer; i++)
            for(int j = i + 1; j < numOfPlayer; j++)
            {
                int number = new Random().nextInt();
                matchsWorld.add(new World(listOfWorld[number % numOfWorld].toString(),listOfBrain[i],listOfBrain[j]));
                matchsInfo.add("Red: " + listOfPlayer[i] + "Black: " + listOfPlayer[j]);
                matchsWorld.add(new World(listOfWorld[number % numOfWorld].toString(),listOfBrain[j],listOfBrain[i]));
                matchsInfo.add("Red: " + listOfPlayer[j] + "Black: " + listOfPlayer[i]);
            }
    }
    public ArrayList<World> getMatchsWorld()
    {
            return matchsWorld;
    }
    
    public ArrayList<String> getMatchsInfo()
    {
            return matchsInfo;
    }
    
}
