import greenfoot.*;

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Mover
{
    public Player(){
        setImage("Cowboy2.png");
    }
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        checkKeys();
        checkCollide();
        
      
    }   

    //checks to see if directional keys are pressed, and makes movement based on that
    public void checkKeys(){
        if(Greenfoot.isKeyDown("left")){
           direction = "left";
           setImage("Cowboy2.png");
           moveDir(4);
        }
        if(Greenfoot.isKeyDown("right")){
           direction = "right";
           setImage("Cowboy1.png");
           moveDir(4);
        }
        if(Greenfoot.isKeyDown("up")){
            direction = "up";
            moveDir(4);
        }
        if(Greenfoot.isKeyDown("down")){
            direction = "down";
            moveDir(4);
        }
    }
    //checks if player is colliding, if it is with an enemy, player dies and respawns
    public void checkCollide(){
        if(isTouching(Enemy.class)){
            Greenfoot.playSound("die.wav");
            World f =  getWorld();
            
            f.removeObject(this);
           
        }
    }
   }

