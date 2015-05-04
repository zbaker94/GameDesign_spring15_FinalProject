import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)

import java.awt.Color;
import java.awt.Graphics;

/**
 * Display showing information regarding the state of the game.
 */
public class Counter extends Actor
{
    int Bomb = 0;
    public void act() {
        getBomb();
        setImage (new GreenfootImage("Bombs : " + Bomb, 24, Color.ORANGE, Color.BLACK ));
        
    }
    
    public void addBomb()
    {
        Bomb++;
    }

    public void removeBomb()
    {
        Bomb--;
    }

public void setBomb(int b){
    Bomb = b;
}
public void getBomb(){
    Player p = (Player) getWorld().getObjects(Player.class).get(0);
    if (p!= null){
    Bomb = p.bombs;
}}
}
