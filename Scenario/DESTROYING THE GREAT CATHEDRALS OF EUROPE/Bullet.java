import greenfoot.*;  
public class Bullet extends Mover
{
    
    private int speed;
    public Bullet(String dir)
    {
        direction = dir;
        speed = 15;
    }
    public void act()
    {
        //setRotation(direction);
        moveDir(speed);
        if(atWorldEdge()){
           World f = getWorld();
            getWorld().removeObject(this);
            checkEnemyHit();
        }
    }
    public void checkEnemyHit(){
        Enemy enemy = (Enemy) getOneIntersectingObject(Enemy.class);
        if(enemy != null){
             Greenfoot.playSound("hit_enemy.wav");
          getWorld().removeObject(this);
             
        }
    }
}