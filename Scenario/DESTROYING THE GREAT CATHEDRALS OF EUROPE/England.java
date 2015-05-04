import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class England here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class England extends Country
{

    static int spawnX =  578;
    static int spawnY = 305;
    GreenfootSound backgroundMusic = new GreenfootSound("English Medieval Song.wav");

    /**
     * Constructor for objects of class England.
     * 
     */
    public England()
    {
        generateActor("Enemy",1);
        generateActor("Bomb",4);
        generateActor("Cathedral",2);
        generateActor("Ammo", 1);
        generateActor("Hero",spawnX,spawnY, getAmmo(), 0);
        generateActor("Pointer",spawnX - 25, spawnY,0,0);
       
        backgroundMusic.playLoop();
        
    }

    /**
     * D. Black - Add country specific background music during play
     */
   

     public int getAmmo(){
        return 8;
    }

    public void GenerateActor(String name, int x, int y){
        generateActor(name,x,y,0,0);
    }
   
}
