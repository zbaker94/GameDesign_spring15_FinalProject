
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
    public GreenfootSound music4 = new GreenfootSound("German Medieval Song.wav");

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

        prepare();

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
        music4.playLoop();
    }

    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     */
    private void prepare()
    {
    }

    
}

