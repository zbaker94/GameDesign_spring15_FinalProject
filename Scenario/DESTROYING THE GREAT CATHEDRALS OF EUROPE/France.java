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

    /**
     * Constructor for objects of class France.
     * 
     */

    public France()
    {

        /**   
         * France - Level 4 - difficulty 4 //
         * 5 cathedrals, five bombs, four ammo
         */
        generateActor("Enemy",3);
        generateActor("Bomb",5);
        generateActor("Cathedral",5);
        generateActor("Ammo", 4);
        generateActor("Hero",spawnX,spawnY, getAmmo(), 0);
        generateActor("Pointer",spawnX - 25, spawnY,0,0);

//     public France(Player p)
    { 
//         France - 5 cathedrals, five bombs, four ammo
        generateActor("Enemy",2);
            generateActor("Cathedral",2);
            generateActor("Bomb",2);
            generateActor("Ammo", 0);
            addObject(p,spawnX,spawnY);
            generateActor("Pointer",spawnX - 25, spawnY,0,0);
       // backgroundMusic.playLoop();
>>>>>>> 430c035123f5e32a115b483b5da633f8e9c07699

    }

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

    /**
     * d black - Play country specific background music during play
     */

    public void play()
    {
        Greenfoot.playSound("french medieval song.wav");
    }

}
