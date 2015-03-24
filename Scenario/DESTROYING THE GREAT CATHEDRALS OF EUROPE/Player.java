import greenfoot.*;

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Mover
{
    
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        checkKeys();
        checkCollide();
        
    }   
    
    public void checkKeys(){
        if(Greenfoot.isKeyDown("left")){
            setRotation(180);
            move(4);
        }
    }
    public void checkCollide(){
        
    }
}
