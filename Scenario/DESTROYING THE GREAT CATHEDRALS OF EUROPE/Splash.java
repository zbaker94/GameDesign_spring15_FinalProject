import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * SplashPage is the first thing the user will see upon opening the game.  It will describe the game, introduce
 * actors, introduce command keys, credit authors, invite user to press a certain key to proceed to game play.
 * author: dblack
 * version 1.0
 */
public class Splash extends World
{

    /**
     * Constructor for objects of class Splash.
     * 
     */
    public Splash()
    {    
        // Create a new world with 750 by 500 cells with a cell size of 1x1 pixels.
        super(750, 500, 1); 
        
    }
   public void act() 
    {
      if(Greenfoot.isKeyDown("space")){
          Greenfoot.playSound("select.wav");
          Greenfoot.setWorld(new France());
          
        }
        if(Greenfoot.isKeyDown("enter")){
            Greenfoot.playSound("select.wav");
            Greenfoot.setWorld(new Splash2());
        }
    }  
    
}
