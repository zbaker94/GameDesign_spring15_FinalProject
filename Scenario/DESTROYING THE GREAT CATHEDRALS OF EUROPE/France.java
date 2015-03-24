import greenfoot.*;

/**
 * Write a description of class France here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class France extends Country
{

    /**
     * Constructor for objects of class France.
     * 
     */
    public France()
    { for(int i = 0; i<1; i++){
            generateEnemy();
            generateCathedral();
            generateCathedral();
        }

        Player hero = new Player();
        addObject(hero,578,305);

    }

    public void generateEnemy(){
        GreenfootImage agent = new GreenfootImage("Police1.png");

        int x = Greenfoot.getRandomNumber((480) +1); 
        int y = Greenfoot.getRandomNumber(500 +1); 

        while(x < (agent.getWidth()) || (x + agent.getWidth()) > 700){
            x = Greenfoot.getRandomNumber((700 - agent.getHeight()) +1); 
        }
        while(y < (agent.getHeight()) || y  > 366){
            y = Greenfoot.getRandomNumber(500 +1);
        }

        addObject(new Enemy(),x,y);

    }
    public void generateCathedral(){
        GreenfootImage cathedral = new GreenfootImage("St_Peters_Italy.png");
        int x = Greenfoot.getRandomNumber((450) +1); 
        int y = Greenfoot.getRandomNumber(500 +1); 
        while(x - cathedral.getWidth() < 0){
            x = Greenfoot.getRandomNumber((450) +1); 
        }

        while (y - cathedral.getHeight()/2 < 0 || y + cathedral.getHeight()/2 > 500){
            y =  Greenfoot.getRandomNumber(500 +1);
        }
       
        
       addObject(new Cathedral(),x,y);
    }
}
