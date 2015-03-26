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
            generateActor("Enemy",2);
            generateActor("Cathedral",1);
            generateActor("Ammo", 2);
            generateActor("Hero",spawnX,spawnY, getAmmo());
            generateActor("Pointer",spawnX - 25, spawnY,0);
        
           }
public int getAmmo(){
    return 8;
}
   
}
