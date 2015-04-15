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
      Pointer p = null;
           if( !getWorld().getObjects(Pointer.class).isEmpty()){
            p = (Pointer) getWorld().getObjects(Pointer.class).get(0);
        }
        if(canMove){
        if(Greenfoot.isKeyDown("left")){
           direction = "left";
          
           setImage("Cowboy2.png");
           p.direction = "left";
           p.setImage("pointer_left.png");
           p.setLocation(getX() - 25,getY());
            p.moveDir(5);
           moveDir(5);
          
        }
        if(Greenfoot.isKeyDown("right")){
           direction = "right";
           setImage("Cowboy1.png");
           p.direction = "right";
           p.setImage("pointer_right.png");
           p.setLocation(getX() + 25,getY());
            p.moveDir(5);
           moveDir(5);
        }
        if(Greenfoot.isKeyDown("up")){
            direction = "up";
            p.direction = "up";
           p.setImage("pointer_up.png");
           p.setLocation(getX(),getY() - 30);
            p.moveDir(5);
            moveDir(5);
        }
        if(Greenfoot.isKeyDown("down")){
            direction = "down";
              p.direction = "down";
           p.setImage("pointer_down.png");
           p.setLocation(getX(),getY() + 30);
            p.moveDir(5);
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
           
            die();
           
        }else if(isTouching(Ammo.class)){
            Ammo a = (Ammo) getOneIntersectingObject(Ammo.class);
            a.die();
            ammo += 5;
        }else if(isTouching(Cathedral.class)){
           Cathedral c = (Cathedral) getOneIntersectingObject(Cathedral.class);
           if(c != null){
               c.die();
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
         Greenfoot.playSound("die.wav");
          Pointer p = null;
           if( !getWorld().getObjects(Pointer.class).isEmpty()){
            p = (Pointer) getWorld().getObjects(Pointer.class).get(0);
            p.die();
        }
        getWorld().removeObject(this);
        // d black 6 apr 15
        // Display loss banner
        // stop game
    }
   }

