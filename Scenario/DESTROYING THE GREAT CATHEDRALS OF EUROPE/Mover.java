import greenfoot.*;

public class Mover extends Actor
{
    private static final double WALKING_SPEED = 5.0;
      String direction;
    /**
     * Turn 90 degrees to the right (clockwise).
     */
    public void turn()
    {
        turn(90);
    }
    
    /**
     * Move a bit to the right.
     */
    public void moveRight(int speed)
    {
        setLocation ( getX() + speed, getY() );
    }
    
    /**
     * Move a bit to the left.
     */
    public void moveLeft(int speed)
    {
        setLocation ( getX() - speed, getY() );
    }
    /**
     * Move up a bit.
     */
    public void moveUp(int speed)
    {
        setLocation ( getX(), getY()  - speed );
    }
    /**
     * Move down a bit.
     */
    public void moveDown(int speed)
    {
        setLocation ( getX(), getY() + speed );
    }

    /**
     * Turn 'angle' degrees towards the right (clockwise).
     */
    public void turn(int angle)
    {
        setRotation(getRotation() + angle);
    }
    

    /**
     * Move a bit forward in the current direction.
     */
    public void move()
    {
        move(WALKING_SPEED);
    }

    
    /**
     * Move a specified distance forward in the current direction.
     */
    public void move(double distance)
    {
        double angle = Math.toRadians( getRotation() );
        int x = (int) Math.round(getX() + Math.cos(angle) * distance);
        int y = (int) Math.round(getY() + Math.sin(angle) * distance);
        
        setLocation(x, y);
    }
    
    public void moveDir(int speed){
        if(direction == "up"){
            moveUp(speed);
        }
          if(direction == "down"){
            moveDown(speed);
        }
          if(direction == "left"){
            moveLeft(speed);
        }
          if(direction == "right"){
            moveRight(speed);
        }
        
    }

    
    /**
     * Test if we are close to one of the edges of the world. Return true is we are.
     */
    public boolean atWorldEdge()
    {
        if(getX() < 20 || getX() > getWorld().getWidth() - 20)
            return true;
        if(getY() < 20 || getY() > getWorld().getHeight() - 20)
            return true;
        else
            return false;
    }
    /**
     * End this game (that is: stop the simuation).
     */
    private void gameEnd()
    {
        Greenfoot.stop();
    }
    
    public void setDirection(String dir){
        direction = dir;
    }
    public String getDirection(){
        return direction;
    }
}