import greenfoot.*;

/**
 * Write a description of class deadBomb here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class deadBomb extends Actor
{
    /**
     * Act - do whatever the deadBomb wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int count = 0;
    public void act() 
    {
        count++;
         
        if(count <=2){
      checkOverlap();  
    } 
   
}
  public void checkOverlap(){
        GreenfootImage dBomb = new GreenfootImage("bomb2.png");
        if(getOneIntersectingObject(null) != null ){
            int x = Greenfoot.getRandomNumber(getWorld().getWidth() - 200);
            int y =Greenfoot.getRandomNumber(getWorld().getHeight());
            while(x-(dBomb.getWidth()/2) <=0 || x+(dBomb.getWidth()/2) >= getWorld().getWidth()-200){
                x = Greenfoot.getRandomNumber(getWorld().getWidth() - 200);
            }
            while(y - (dBomb.getHeight()/2) <=0 || y+(dBomb.getHeight()/2) >= getWorld().getHeight()){
                y =Greenfoot.getRandomNumber(getWorld().getHeight());
            }
            getWorld().addObject(new deadBomb(),x,y);
            getWorld().removeObject(this);
        }
    }
}
