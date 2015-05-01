import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Belgium here.
 * 
 * @author (Dave Black) 
 * @version (v1.0)
 */
public class Belgium extends Country
{

    /**
     * Constructor for objects of class Belgium.
     * 
     */
    public Belgium()
    {
        generateActor("Enemy",2);
        generateActor("Bomb",4);
        generateActor("Cathedral",3);
        generateActor("Ammo", 2);
//         generateActor("Hero",spawnX,spawnY, getAmmo(), 0);
//         generateActor("Pointer",spawnX - 25, spawnY,0,0);
        // backgroundMusic.playLoop();
    }
}
// Belgium - 3 cathedrals, four bombs, two ammo