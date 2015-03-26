import greenfoot.*;

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Mover
{
    int ammo = 0;
    boolean canShoot;
    private static final int gunReloadTime = 20;         // The minimum delay between firing the gun.
    private int reloadDelayCount;
    private boolean canMove = true;
    
    public Player(){
       World f = (France) getWorld();
        ammo = 3;
              reloadDelayCount = 5;
        direction = "left";
      
    }
     public Player(int ammo){
        setImage("Cowboy2.png");
         this.ammo = ammo;
        reloadDelayCount = 5;
        direction = "left";
      
    }
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
         reloadDelayCount++;
        checkKeys();
        checkCollide();
       
      
    }   

    //checks to see if directional keys are pressed, and makes movement based on that
    public void checkKeys(){
       if(canMove){
        if(Greenfoot.isKeyDown("left")){
           direction = "left";
           setImage("Cowboy2.png");
           moveDir(5);
        }
        if(Greenfoot.isKeyDown("right")){
           direction = "right";
           setImage("Cowboy1.png");
           moveDir(5);
        }
        if(Greenfoot.isKeyDown("up")){
            direction = "up";
            moveDir(5);
        }
        if(Greenfoot.isKeyDown("down")){
            direction = "down";
            moveDir(5);
        }
        if(Greenfoot.isKeyDown("space")){
            
                
                if(ammo != 0 && reloadDelayCount >= gunReloadTime){
                shoot();
            }
        }
    }
}
    //checks if player is colliding, if it is with an enemy, player dies 
    public void checkCollide(){
        if(isTouching(Enemy.class)){
            Greenfoot.playSound("die.wav");
            World f =  getWorld();
            
            f.removeObject(this);
           
        }else if(isTouching(Ammo.class)){
            Ammo a = (Ammo) getOneIntersectingObject(Ammo.class);
            a.die();
            ammo += 5;
        }else while(isTouching(Cathedral.class)){
            canMove = false;
            if(direction == "up"){
                canMove = true;
                setLocation(getX(),getY() + 10);
            }
             if(direction == "down"){
                  canMove = true;
                setLocation(getX(),getY() - 10);
            }
             if(direction == "left"){
                  canMove = true;
                setLocation(getX() +10,getY());
            }
             if(direction == "right"){
                  canMove = true;
                setLocation(getX() - 10,getY());
            }
            
        }
    }
    
    
    //creates a bulllet that moves in the same direction as the player
    public void shoot(){
        ammo--;
        reloadDelayCount = 0;
        Greenfoot.playSound("shoot.wav");
        getWorld().addObject(new Bullet(direction), getX(), getY());
    }
    
    public void die(){
        getWorld().removeObject(this);;
    }
   }

