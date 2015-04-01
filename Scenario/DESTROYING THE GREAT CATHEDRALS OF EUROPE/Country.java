import greenfoot.*;

/**
 * Simply a superclass for any code that needs to be incorporated into the country levels.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Country extends World
{

    /**
     * Constructor for objects of class Country.
     * 
     */
    public Country()
    {    
        
        // Create a new world with 700x500 cells with a cell size of 1x1 pixels.
        super(700, 500, 1); 
        setPaintOrder(Enemy.class,Player.class,Cathedral.class);
    }
    
    //method for randomly generating an actor
  public void generateActor(String actor, int count){
      for(int i = 0; i < count; i++){
      
      if (actor == "Enemy"){
          
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
        if(actor == "Cathedral"){
            
             int rando = Greenfoot.getRandomNumber(3) + 1;
            String img = "tower";
            if(rando <= 3 && rando > 2){
                img = "spire";
            }else if(rando <=2 && rando > 1){
                img = "dome";
            }else{
                img = "tower";
            }
            
            GreenfootImage cathedral = new GreenfootImage("St_Peters_Italy.png");
        int x = Greenfoot.getRandomNumber((450) +1); 
        int y = Greenfoot.getRandomNumber(500 +1); 
        while(x - cathedral.getWidth() < 0){
            x = Greenfoot.getRandomNumber((450) +1); 
        }

        while (y - cathedral.getHeight()/2 < 0 || y + cathedral.getHeight()/2 > 500){
            y =  Greenfoot.getRandomNumber(500 +1);
        }
       
        
       addObject(new Cathedral(img),x,y);
        
    }
        if(actor == "Ammo"){
            GreenfootImage ammo = new GreenfootImage("ammo.png");
            int x = Greenfoot.getRandomNumber((450) +1); 
        int y = Greenfoot.getRandomNumber(500 +1); 
        while(x - ammo.getWidth() < 0){
            x = Greenfoot.getRandomNumber((450) +1); 
        }

        while (y - ammo.getHeight()/2 < 0 || y + ammo.getHeight()/2 > 500){
            y =  Greenfoot.getRandomNumber(500 +1);
        }
            addObject(new Ammo(),x,y);
        }
    }

}
//special generateActor for placing an actor at specific location
public void generateActor(String actor, int x, int y,int ammo){
     if(actor == "Hero"){
         Player hero = new Player(ammo);
        addObject(hero,x,y );
    }
     if(actor == "Enemy"){
         Enemy enemy = new Enemy();
        addObject(enemy,x,y);
    }
     if(actor == "Cathedral"){
         Cathedral cath = new Cathedral();
        addObject(cath,x,y);
    }
    if(actor == "Pointer"){
        Pointer point = new Pointer();
        addObject(point,x,y);
    }
    
}

}
