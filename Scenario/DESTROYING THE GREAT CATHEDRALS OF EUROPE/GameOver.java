import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Write a description of class GameOver here.
 * 
 * @author Z. Taylor 
 * @version 1.2
 */
public class GameOver extends Actor
{
    /**
     * Act - do whatever the GameOver wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    public GameOver()
    {
        setImage(new GreenfootImage("You Died", 48, Color.BLACK, Color.RED));
    }
}
