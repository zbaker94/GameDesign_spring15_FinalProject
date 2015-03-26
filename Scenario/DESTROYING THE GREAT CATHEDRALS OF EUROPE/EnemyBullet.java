import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EnemyBullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EnemyBullet extends Bullet
{
    int speed = 8;
    public EnemyBullet(String direction){
        super(direction);
    }
    /**
     * Act - do whatever the EnemyBullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
         moveDir(speed);
        if(atWorldEdge()){
            World f = getWorld();
            getWorld().removeObject(this);
            return;
        }
        checkCollision();
    }    
     public void checkCollision()
    {
        Player p =(Player)getOneIntersectingObject(Player.class);
        Cathedral c = (Cathedral)getOneIntersectingObject(Cathedral.class);
        if (p != null){
       Greenfoot.playSound("hit_enemy.wav");
       p.die();
        getWorld().removeObject(this);  // Removes the Shot
    }
    if(c != null){
        getWorld().removeObject(this); // Removes the Shot
    }
}
}


