import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bomb here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bomb extends Actor
{
    int counter = 0;
    int fuse = Greenfoot.getRandomNumber(70) + 50;
    /**
     * Act - do whatever the Bomb wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Bomb(){
        setImage("bomb1.png");
    }
   public void act()
    { 
        counter++;
        if (counter == fuse){
            Cathedral c = (Cathedral) getOneIntersectingObject(Cathedral.class);
            if(c != null)
            c.die();
             int x = getX();
        int y = getY();
        
        getWorld().addObject(new Explosion(),x,y);
            getWorld().removeObject(this);
        }
        
    }
    
    
   
    
        
        
    }


