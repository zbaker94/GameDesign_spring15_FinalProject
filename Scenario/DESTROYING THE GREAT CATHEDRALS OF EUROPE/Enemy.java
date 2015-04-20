import greenfoot.*;

/**
 *adversary to the player, will move either horizontally or vertically, ocaisionally shooting at the player 
 * 
 * @author Zack Baker
 * @version 3/25/15
 */
public class Enemy extends Mover
{
    private String axis;

    private int count = 0;
    private int interval = Greenfoot.getRandomNumber(20);
    private String currentImage;
    private int movement;
    private int hp = 10;
    private int shootInterval = Greenfoot.getRandomNumber(70) +50;
    private  int wait = shootInterval;
    private boolean canMove = true;
    public Enemy(){

        axis = getDir();
        if(axis == "horizontal"){
            direction = "right";
        }else{
            direction = "up";
        }

        movement = Greenfoot.getRandomNumber(2) + 2;
    }

    /**
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    public void act() 
    {
        
      
        if(this !=null){
            
            if(shootInterval > 0 && canMove){
                shootInterval--;
             if(atWorldEdge()){
                turnAway();
            }
            checkTurn();
                
            
            

            moveDir(movement);
            
           }else
           if(shootInterval == 0){
              canMove = false;
               shootPlayer();
               shootInterval = wait;
               canMove = true;
               
            }
             
           checkCollide();
        }
        
        
    }

    //uses a random number to determine which direction the enemy should move
    public String getDir(){
        String dir;
        int a = Greenfoot.getRandomNumber(2);
        if(a < 1){
            dir = "vertical";
        }else{
            dir = "horizontal";
        }
        return dir;
    }

    //returns which axis the enemy is moving on
    public String getDirection(){
        return direction;
    }
    //returns whether this is colliding with any object
    public boolean checkTurn(){
        if(isTouching(Player.class) || isTouching(Cathedral.class)){
            turnAway();
            return true;
        }else{
            return false;
        }
    }
    public void checkCollide(){
         if(isTouching(Explosion.class)){
           Explosion e = (Explosion) getOneIntersectingObject(Explosion.class);
           if(e != null){
               die();
               
            }
        }
         if(isTouching(Bomb.class)){
           Bomb e = (Bomb) getOneIntersectingObject(Bomb.class);
           if(e != null){
              int x = e.getX();
              int y = e.getY();
              Greenfoot.playSound("defuse.wav");
             getWorld().removeObject(e);
              getWorld().addObject(new deadBomb(),x,y);
              
             
               
            }
        }
            
            
    }

    //turns the character in opposite  direction
    public void turnAway(){
        if(direction == "up"){
            direction = "down";
            //moveDir(2);
        }else
        if(direction == "down"){
            direction = "up";
            //moveDir(2);

        }else
        if(direction == "left"){
            setImage("Police1.png");
            direction = "right";
            //moveDir(2);

        }else
        if(direction == "right"){
            setImage("Police2.png");
            direction = "left";
            //moveDir(2);

        }

    }
    //stops moving and will shoot at player's direction location at execution 
    public void shootPlayer(){
        Greenfoot.playSound("enemy_shoot.wav");
        getWorld().addObject(new EnemyBullet(getPlayerRelativeDirection(getX(),getY() + 20)), getX(), getY());
        
        }
    
    //damages enemy by decreasing hit points, then causes it to switch directions
    public void damage(int amount){
        int r = Greenfoot.getRandomNumber(100) + 1;
        hp -= amount;
        if(hp <= 0){
            die();
        }else{
            turnTowardsPlayer();  
        }
    }
    //removes the actor from the world and plays 1 of 2 death sounds
    public void die(){
        String sound;
        int s = Greenfoot.getRandomNumber(3);
        if(s > 1){
            sound = "grunt";
        }else{
            sound = "groan";
        }
        Greenfoot.playSound(sound + ".wav");
        
       
        int r = Greenfoot.getRandomNumber(2);
        int x = getX();
        int y = getY();
        if(r == 0){
        
        getWorld().addObject(new deadBomb(),x,y);
        }else if(r == 1){
            getWorld().addObject(new Ammo(),x,y);
            }
        
        getWorld().removeObject(this);
    }

    //actor turns in the general direction of the player and switches axes
    public void turnTowardsPlayer(){
       direction = getPlayerRelativeDirection(getX(),getY());
       if(direction == "right"){
           setImage("Police1.png");
        }
         if(direction == "left"){
           setImage("Police2.png");
        }
       
    }
    //determines if player is above, left, right , or below shooter
    public String getPlayerRelativeDirection(int x, int y){
        Player p = null;
        if( !getWorld().getObjects(Player.class).isEmpty()){
            p = (Player) getWorld().getObjects(Player.class).get(0);
        }

        if(p != null){
            int pX = p.getX();
            int pY = p.getY();

            if(pX > x){
                if(pY > y){
                    if(pX - x > pY - y){
                        return "right";
                    }else{
                        return "down";
                    }
                }else{
                    if(pX - x > y - pY){
                        return "right";
                    }else{
                        return "up";
                    }
                }
            }else{
                if(pY > y){
                    if(x - pX > pY - y){
                        return "left";
                    }else{
                        return "down";
                    }
                }else{
                    if(x-pX > y - pY){
                        return "left";
                    }else{
                        return "up";

                    }
                }
            }

        }else{
            return direction;  
        }
    }
}

