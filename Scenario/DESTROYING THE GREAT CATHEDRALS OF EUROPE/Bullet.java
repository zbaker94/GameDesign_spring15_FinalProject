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
        Enemy e =(Enemy)getOneIntersectingObject(Enemy.class);
        Cathedral c = (Cathedral)getOneIntersectingObject(Cathedral.class);
        if (e != null){
            Greenfoot.playSound("hit_enemy.wav");
            e.damage(5);
            getWorld().removeObject(this);  // Removes the Shot
        }
        if(c != null){
            // getWorld().removeObject(this); // Removes the Shot
        }

    }

}