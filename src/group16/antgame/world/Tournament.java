/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package group16.antgame.world;

import group16.antgame.ant.AntBrain;

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
    
    public Tournament(World[] listOfWorld, AntBrain[] listOfBrain, String[] listOfPlayer,int numOfPlayer,int numOfWorld){
        this.listOfWorld = listOfWorld;
        this.listOfBrain = listOfBrain;
        this.listOfPlayer = listOfPlayer;
        this.numOfPlayer = numOfPlayer;
        this.numOfWorld = numOfWorld;
    }
    public void Matching()
    {
        for(int i = 0; i < numOfPlayer; i++)
            for(int j = i + 1; j < numOfPlayer; j++)
                
    }
}
