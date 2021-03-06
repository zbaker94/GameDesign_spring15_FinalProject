import greenfoot.*;

/**
 * Write a description of class Cathedral here.
 * 
 * @author Zack Baker
 * @version 3/25/15
 */
public class Cathedral extends Actor
{
    int count =0;
    public Cathedral(){
        int rando = Greenfoot.getRandomNumber(3) + 1;
        String img = "tower";
        if(rando <= 3 && rando > 2){
            img = "spire";
        }else if(rando <=2 && rando > 1){
            img = "dome";
        }else{
            img = "tower";
        }
        setImage(img+".png");

    }

    public Cathedral(String img){
        setImage(img + ".png");

    }

    /**
     * Act - do whatever the Cathedral wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        count++;
        checkExplode();  // Add your action code here.
        if(count <=2){
            checkOverlap();  
        }

    }  

    /**
     * checks if the cathedral has been destroyed
     */

    public void checkExplode(){
        if(isTouching(Explosion.class)){
            Explosion e = (Explosion) getOneIntersectingObject(Explosion.class);
            if(e != null){
                die();

            }
        }
    }

    /**
     * Checks to see if random cathedral placement results in cathedral images overlapping each other.  If so,
     * re-spawn in new location.  repeat until no overlaps.
     */

    public void checkOverlap(){
        GreenfootImage cathedral = new GreenfootImage("spire.png");
        if(getOneIntersectingObject(null) != null ){
            int x = Greenfoot.getRandomNumber(getWorld().getWidth() - 200);
            int y =Greenfoot.getRandomNumber(getWorld().getHeight());
            while(x-(cathedral.getWidth()/2) <=0 || x+(cathedral.getWidth()/2) >= getWorld().getWidth()-200){
                x = Greenfoot.getRandomNumber(getWorld().getWidth() - 200);
            }
            while(y - (cathedral.getHeight()/2) <=0 || y+(cathedral.getHeight()/2) >= getWorld().getHeight()){
                y =Greenfoot.getRandomNumber(getWorld().getHeight());
            }
            getWorld().addObject(new Cathedral(),x,y);
            getWorld().removeObject(this);
        }
    }

    public void die(){

        getWorld().removeObject(this);
    }
}
