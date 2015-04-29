import greenfoot.*;
import java.util.List;

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

//GreenfootSound backgroundMusic = new GreenfootSound("your sound file path");

    /**
     * Constructor for objects of class France.
     * 
     */
    public France()
    { 
//         France - 5 cathedrals, five bombs, four ammo
        generateActor("Enemy",3);
        generateActor("Bomb",5);
        generateActor("Cathedral",5);
        generateActor("Ammo", 4);
        generateActor("Hero",spawnX,spawnY, getAmmo(), 0);
        generateActor("Pointer",spawnX - 25, spawnY,0,0);
       // backgroundMusic.playLoop();

    }
    
    
    public int getAmmo(){
        return 8;
    }

    public void GenerateActor(String name, int x, int y){
        generateActor(name,x,y,0,0);
    }

}
