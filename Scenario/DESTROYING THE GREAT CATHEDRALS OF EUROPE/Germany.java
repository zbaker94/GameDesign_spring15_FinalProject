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
    public Germany()
    { 

        generateActor("Enemy",1);
        generateActor("Bomb",1);
        generateActor("Cathedral",1);
        generateActor("Ammo", 2);
        generateActor("Hero",spawnX,spawnY, getAmmo(), 0);
        generateActor("Pointer",spawnX - 25, spawnY,0,0);

        prepare();
    }

    public int getAmmo(){
        return 4;
    }

    public void GenerateActor(String name, int x, int y){
        generateActor(name,x,y,0,0);
    }

    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     */
    private void prepare()
    {
    }
}
// Germany - 4 cathedrals, four bombs, three ammo