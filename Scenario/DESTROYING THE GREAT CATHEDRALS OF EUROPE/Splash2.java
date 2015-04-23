import greenfoot.*;

/**
 * Write a description of class Splash2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Splash2 extends World
{

    /**
     * Constructor for objects of class Splash2.
     * 
     */
    public Splash2()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(700, 500, 1); 
    }
     public void act() 
    {
      if(Greenfoot.isKeyDown("space")){
          Greenfoot.setWorld(new France());
          
        }
       
    } 
}
