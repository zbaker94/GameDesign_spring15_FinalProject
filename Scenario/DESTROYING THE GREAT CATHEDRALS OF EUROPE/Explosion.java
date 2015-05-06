import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)

/**
 * An explosion. It starts by expanding and then collapsing. 
 * The explosion will explode other obejcts that the explosion intersects.
 * 
 * @author Poul Henriksen
 * @version 1.0.1
 */
public class Explosion extends Actor
{
    /** How many images should be used in the animation of the explostion */
    private final static int IMAGE_COUNT= 15;
    
    /** 
     * The images in the explosion. This is static so the images are not
     * recreated for every object (improves performance significantly).
     */
    private static GreenfootImage[] images;
    
    /** Current size of the explosion */
    private int imageNo = 0;
    
    /** How much do we increment the index in the explosion animation. */
    private int increment=1;
    
//     private int I = 9999;
    
    /**
     * Create a new explosion.
     */
    public Explosion() 
    {
        initializeImages();
        setImage(images[0]);
        Greenfoot.playSound("short-explosion.wav");
    }    
    
    /** 
     * Create the images for explosion.
     */
    public synchronized static void initializeImages() 
    {
        if(images == null) {
            String imageName = "explosionNULL";
            
            images = new GreenfootImage[IMAGE_COUNT];
            for (int i = 0; i < IMAGE_COUNT; i++)
            {
                imageName = "explosion" + i + ".png";
                GreenfootImage image = new GreenfootImage(imageName);
                images[i] = image;
            }
        }
    }
    
    /**
     * Explode!
     */
    public void act()
    {  
        setImage(images[imageNo]);

        imageNo += increment;
        if(imageNo >= IMAGE_COUNT) {
            increment = -increment;
            imageNo += increment;
            getWorld().removeObject(this);
        }
       
        
    }
}
