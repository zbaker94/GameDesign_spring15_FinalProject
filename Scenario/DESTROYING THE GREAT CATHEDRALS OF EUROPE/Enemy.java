import greenfoot.*;

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends Mover
{
    private String direction; 
    private int count = 0;
    private int interval = Greenfoot.getRandomNumber(20);
    private String currentImage;
    private int movement;
    /**
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    public Enemy(){
        direction = getDir();
       movement = Greenfoot.getRandomNumber(4) + 2;
        }

    

    public void act() 
    {

        patrol();
        if(checkCollide()){
            turnAway();
        }
        if(count == 90){
            count =0;
            Greenfoot.delay(20);
            shootPlayer();
            Greenfoot.delay(20);

        }else{
            ++count;
        }
        move(movement);

    }    

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

    public String getDirection(){
        return direction;
    }

    public boolean checkCollide(){
        if(isTouching(null)){
            return true;
        }else{
            return false;
        }
    }

    public void turnAway(){
        turn(180);
        move(2);
    }

    public void shootPlayer(){
        setImage(currentImage + "-s.png");
        Greenfoot.delay(10);
        setImage(currentImage+".png");

    }
}

