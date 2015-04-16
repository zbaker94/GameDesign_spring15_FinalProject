import greenfoot.*;

/**
 * Write a description of class Cathedral here.
 * 
 * @author Zack Baker
 * @version 3/25/15
 */
public class Cathedral extends Actor
{
    public Cathedral(){
        setImage("St_Peters_Italy.png");
        
    }
    
    public Cathedral(String img){
        setImage(img + ".png");
      
    }
    
    /**
     * Act - do whatever the Cathedral wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
      checkExplode();  // Add your action code here.
    }  
    //checks if the cathedral has been destroyed
    public void checkExplode(){
        
    }
    
    //on death, spawns another enemy, then dissapeers
    public void die(){
        int x = getX();
        int y = getY();
        
        getWorld().addObject(new Explosion(),x,y);
        getWorld().removeObject(this);
    }
}
