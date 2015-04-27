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
        setImage (new GreenfootImage("Bombs : " + Bomb, 24, Color.ORANGE, Color.BLACK));
        //setImage (new GreenfootImage("Bullets : " + Bullet, 24, Color.ORANGE, Color.BLACK));
        
    }
    
    public void addBomb()
    {
        Bomb++;
    }
    
        public void addBullet()
    {
        //Bullet++;
    }
    public void removeAmmo()
    {
        //Bullet--;
    }
    public void removeBomb()
    {
        Bomb--;
    }


}
