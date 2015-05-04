import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class England here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class England extends Country
{
<<<<<<< HEAD

    static int spawnX =  578;
    static int spawnY = 305;
    GreenfootSound backgroundMusic = new GreenfootSound("English Medieval Song.wav");

=======
static int spawnX =  578;
 static int spawnY = 305;
>>>>>>> 430c035123f5e32a115b483b5da633f8e9c07699
    /**
     * Constructor for objects of class England.
     * 
     */
    public England(Player p)
    {
 generateActor("Enemy",3);
        generateActor("Bomb",3);
        generateActor("Cathedral",3);
        generateActor("Ammo", 1);
<<<<<<< HEAD
        generateActor("Hero",spawnX,spawnY, getAmmo(), 0);
        generateActor("Pointer",spawnX - 25, spawnY,0,0);
       
        backgroundMusic.playLoop();
        
=======
       addObject(p,spawnX,spawnY);
        generateActor("Pointer",spawnX - 25, spawnY,0,0);
>>>>>>> 430c035123f5e32a115b483b5da633f8e9c07699
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
