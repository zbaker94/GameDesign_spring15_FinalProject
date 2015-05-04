import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Belgium here.
 * 
 * @author (Dave Black) 
 * @version (v1.0)
 */
public class Belgium extends Country
{
     static int spawnX =  578;
 static int spawnY = 305;

    /**
     * Constructor for objects of class Belgium.
     * 
     */
    public Belgium(Player p)
    {
           generateActor("Enemy",1);
        generateActor("Bomb",2);
        generateActor("Cathedral",2);
        generateActor("Ammo", 2);
       addObject(p,spawnX,spawnY);
        generateActor("Pointer",spawnX - 25, spawnY,0,0);
    }
    /**
     * d. Black - add country specific background music during play
     */
    
    public void act()
    {
        play();
    }
    
     public int getAmmo(){
        return 8;
    }

    public void GenerateActor(String name, int x, int y){
        generateActor(name,x,y,0,0);
    }
    
    public void play()
    {
        Greenfoot.playSound("Belgian Medieval Song.wav");
    }
    
}
// Belgium - 3 cathedrals, four bombs, two ammo