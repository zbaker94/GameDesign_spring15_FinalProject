import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class England here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class England extends Country
{

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
//         generateActor("Hero",spawnX,spawnY, getAmmo(), 0);
//         generateActor("Pointer",spawnX - 25, spawnY,0,0);
        // backgroundMusic.playLoop();
    }

}
