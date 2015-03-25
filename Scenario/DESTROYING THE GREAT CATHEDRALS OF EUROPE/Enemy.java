import greenfoot.*;

/**
 *adversary to the player, will move either horizontally or vertically, ocaisionally shooting at the player 
 * 
 * @author Zack Baker
 * @version 3/25/15
 */
public class Enemy extends Mover
{
    private String direction; 
    private int count = 0;
    private int interval = Greenfoot.getRandomNumber(20);
    private String currentImage;
    private int movement;

    public Enemy(){
        direction = getDir();
        movement = Greenfoot.getRandomNumber(4) + 2;
    }

    /**
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    public void act() 
    {

        patrol();
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
        move(movement);

    }    

    
    //uses a random number to determine which direction the enemy should move
    public String getDir(){
        String dir;
        int direction = Greenfoot.getRandomNumber(2);
        if(direction < 1){
            dir = "vertical";
        }else{
            dir = "horizontal";
        }
        return dir;
    }
    //(outdated) sets enemy to correct direction and turns around if he is at world edge
    public void patrol(){
        if(direction == "vertical"){
            if(getRotation() != 90 && getRotation() != 270){
                setImage("Police1-up.png");
                currentImage = "Police1-up";
                setRotation(270);
            }
            if(getRotation() == 90){
                setImage("Police1-down.png");
                currentImage = "Police1-down";
            }else{
                setImage("Police1-up.png");
                currentImage = "Police1-up";
            }
        }
        if(direction == "horizontal"){
            if(getRotation() != 0 && getRotation() != 180){
                setImage("Police1.png");
                currentImage = "Police1";
                setRotation(0);
            }
            if(getRotation() == 180){
                setImage("Police1-left.png");
                currentImage = "Police1-left";
            }else{
                setImage("Police1.png"); 
                currentImage = "Police1";
            }
        }

        if(atWorldEdge()){
            turnAway();

        }
    }
    //returns which axis the enemy is moving on
    public String getDirection(){
        return direction;
    }
    //returns whether this is colliding with any object
    public boolean checkCollide(){
        if(isTouching(null)){
            return true;
        }else{
            return false;
        }
    }
    
    //turns the character
    public void turnAway(){
        turn(180);
        move(2);
    }
    //stops moving and will shoot at player's x,y location at execution 
    public void shootPlayer(){
        setImage(currentImage + "-s.png");
        //Greenfoot.delay(10);
        setImage(currentImage+".png");

    }
}

