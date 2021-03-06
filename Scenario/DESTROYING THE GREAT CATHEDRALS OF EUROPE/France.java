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
    public France(Player p)
    { 
//         France - 5 cathedrals, five bombs, four ammo
        generateActor("Enemy",2);
            generateActor("Cathedral",2);
            generateActor("Bomb",3);
            generateActor("Ammo", 1);
            addObject(p,spawnX,spawnY);
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
