import greenfoot.*;

/**
 * Write a description of class Germany here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Germany extends Country
{
 static int spawnX =  578;
 static int spawnY = 305;

    /**
     * Constructor for objects of class France.
     * 
     */
    public Germany(Player p)
    { 
            generateActor("Enemy",2);
            generateActor("Cathedral",4);
            generateActor("Bomb",4);
            generateActor("Ammo", 3);
            addObject(p,spawnX,spawnY);
             generateActor("Hero",spawnX,spawnY, getAmmo(), 0);
            generateActor("Pointer",spawnX - 25, spawnY,0,0);
        
           }
 public int getAmmo(){
        return 8;
    }

    public void GenerateActor(String name, int x, int y){
        generateActor(name,x,y,0,0);
    }


    /** 
     * d.black - add country specific background music during play 
     */
    
    public void act()
    {
        play();
    }
    
    public void play()
    {
        Greenfoot.playSound("German Medieval Song.wav");
    }
    
    
    
   
}
// Germany - 4 cathedrals, four bombs, three ammo