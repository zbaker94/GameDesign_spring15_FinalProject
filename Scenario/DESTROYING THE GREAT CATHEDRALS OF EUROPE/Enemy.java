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

    public Enemy(){
        axis = getDir();
        if(axis == "horizontal"){
            direction = "right";
        }else{
            direction = "up";
        }
        movement = Greenfoot.getRandomNumber(4) + 2;
    }

    /**
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    public void act() 
    {
        if(this !=null){
        if(atWorldEdge()){
            turnAway();
        }
        if(checkCollide()){
            turnAway();
        }
        if(count == 90){
            count =0;
            //Greenfoot.delay(20);
            shootPlayer();
            //Greenfoot.delay(20);

        }else{
            ++count;
        }
       
        
           
        
        moveDir(movement);
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
    public boolean checkCollide(){
        if(isTouching(Player.class)){
            return true;
        }else{
            return false;
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
    //stops moving and will shoot at player's x,y location at execution 
    public void shootPlayer(){

        
    }
}

