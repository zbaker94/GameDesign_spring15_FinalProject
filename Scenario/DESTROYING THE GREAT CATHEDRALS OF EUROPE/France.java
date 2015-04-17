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
            generateActor("Enemy",1);
            generateActor("Cathedral",3);
            generateActor("Ammo", 0);
            generateActor("Hero",spawnX,spawnY, getAmmo(), 3);
            generateActor("Pointer",spawnX - 25, spawnY,0,0);
        
           }
public int getAmmo(){
    return 8;
}
public void GenerateActor(String name, int x, int y){
   generateActor(name,x,y,0,0);
}
   
}
