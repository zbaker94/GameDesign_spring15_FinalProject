import greenfoot.*;

/**
 * Write a description of class Pointer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pointer extends Mover
{
    public Pointer(){
        setImage("pointer_left.png");
    }
    /**
     * Act - do whatever the Pointer wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }  
    public  void die(){
        getWorld().removeObject(this);
    }
}
