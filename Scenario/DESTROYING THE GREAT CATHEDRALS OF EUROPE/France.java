import greenfoot.*;

/**
 * Write a description of class France here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class France extends Country
{
 static int spawnX =  578;
 static int spawnY = 305;
    /**
     * Constructor for objects of class France.
     * 
     */
    public France()
    { 
            generateActor("Enemy",3);
            generateActor("Cathedral",0);
            generateActor("Hero",spawnX,spawnY);
        
           }

   
}
