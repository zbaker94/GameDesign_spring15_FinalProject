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
       addObject(p,spawnX,spawnY);
        generateActor("Pointer",spawnX - 25, spawnY,0,0);
    }

}
