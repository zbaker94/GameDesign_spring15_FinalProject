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
    int bombs =0;
    boolean canShoot;
    private static final int gunReloadTime = 20;         // The minimum delay between firing the gun.
    private static final int bombReloadTime = 50;
    private int reloadDelayCount;
    private boolean canMove = true;
    private int currentLevel = 1;

    public Player(Counter AmmoCounter){

        ammo = 3;
        bombs = 2;
        reloadDelayCount = 5;
        direction = "left";

    }

    public Player(int ammo, int bomb ){
        setImage("Cowboy2.png");
        this.ammo = ammo;
        bombs = bomb;
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

        checkCollide();
        checkEdge();
        checkKeys();

    }   
    //checks to see if directional keys are pressed, and makes movement based on that
    public void checkKeys(){
        Pointer p = null;
        if( !getWorld().getObjects(Pointer.class).isEmpty()){
            p = (Pointer) getWorld().getObjects(Pointer.class).get(0);
        }
        if(canMove){
            if(Greenfoot.isKeyDown("left") || Greenfoot.isKeyDown("a")){
                direction = "left";

                setImage("Cowboy2.png");
                p.direction = "left";
                p.setImage("pointer_left.png");
                p.setLocation(getX() - 25,getY());
                p.moveDir(5);
                moveDir(5);

            }
            if(Greenfoot.isKeyDown("right") || Greenfoot.isKeyDown("d")){
                direction = "right";
                setImage("Cowboy1.png");
                p.direction = "right";
                p.setImage("pointer_right.png");
                p.setLocation(getX() + 25,getY());
                p.moveDir(5);
                moveDir(5);
            }
            if(Greenfoot.isKeyDown("up") || Greenfoot.isKeyDown("w")){
                direction = "up";
                p.direction = "up";
                p.setImage("pointer_up.png");
                p.setLocation(getX(),getY() - 30);
                p.moveDir(5);
                moveDir(5);
            }
            if(Greenfoot.isKeyDown("down") || Greenfoot.isKeyDown("s")){
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

            if(Greenfoot.isKeyDown("shift")){

                if(bombs > 0 && reloadDelayCount >= bombReloadTime){
                    Country country = (Country)getWorld();
                    Counter counter = country.getCounter();
                    counter.removeBomb();

                    bomb();
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
            Greenfoot.playSound("ammo.wav");
            a.die();
            Country country = (Country)getWorld();
            Counter counterammo = country.getCounter();
            ammo+=3;

        }
        else if(isTouching(Explosion.class)){
            Explosion e = (Explosion) getOneIntersectingObject(Explosion.class);
            if(e != null){
                die();

            }
        }
        else if(isTouching(deadBomb.class)){
            deadBomb a = (deadBomb) getOneIntersectingObject(deadBomb.class);
            Greenfoot.playSound("ammo.wav");
            getWorld().removeObject(a);
            Country country = (Country)getWorld();
            Counter counter = country.getCounter();
            counter.addBomb();
            bombs++;

        }
    }

    //creates a bulllet that moves in the same direction as the player
    public void shoot(){

        ammo--;
        reloadDelayCount = 0;
        Greenfoot.playSound("shoot.wav");
        getWorld().addObject(new Bullet(direction), getX(), getY());
    }

    public void bomb(){
        Greenfoot.playSound("drop.wav");
        bombs--;
        reloadDelayCount = 0;
        getWorld().addObject(new Bomb(), getX(), getY());
    }

    public void die(){
        Greenfoot.playSound("die.wav");
        Pointer p = null;
        if( !getWorld().getObjects(Pointer.class).isEmpty()){
            p = (Pointer) getWorld().getObjects(Pointer.class).get(0);
            p.die();
        }
        World myWorld = getWorld();
        GameOver gameover = new GameOver();
        myWorld.addObject(gameover, myWorld.getWidth()/2, myWorld.getHeight()/2);
        Greenfoot.delay(20); 
        getWorld().removeObject(this);
        Greenfoot.setWorld(new Germany());
        // d black 6 apr 15
        // Display loss banner
        // stop game
    }

    public void checkEdge(){
        if(this != null){
            if(getWorld().getObjects(Cathedral.class).size() == 0){
                getWorld().addObject(new Arrow(),80,getWorld().getHeight()/2);

                if(getX() <= (20)){
                    if (currentLevel == 1) {
                        Greenfoot.playSound("transition.wav");
                        currentLevel = 2;
                        getWorld().removeObject(this);
                        Greenfoot.setWorld(new Belgium(this));
                    }
                    else if(currentLevel == 2){
                        Greenfoot.playSound("transition.wav");
                        currentLevel = 3;
                        getWorld().removeObject(this);
                        Greenfoot.setWorld(new France(this));
                    }
                }else if(currentLevel == 3){
                    Greenfoot.playSound("transition.wav");
                    currentLevel = 4;
                    getWorld().removeObject(this);
                    Greenfoot.setWorld(new England(this));
                }
                else if(currentLevel == 4){

                    //code for ending game
                }
            } 

        }
    }
}

