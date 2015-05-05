import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * SplashPage is the first thing the user will see upon opening the game.  It will describe the game, introduce
 * actors, introduce command keys, credit authors, invite user to press a certain key to proceed to game play.
 * author: dblack
 * version 1.2
 */
public class Splash extends World
{
    String currentBackground = "church ruin 1.jpg";
    public int count = 0;
    /**
     * Constructor for objects of class Splash.
     * 
     */
    public Splash()
    {    
        // Create a new world with 600 by 450 cells with a cell size of 1x1 pixels.
        super(600, 450, 1); 

        Color myCol1 = new Color (255,255,255,0);

        String titleLine1 = "DESTROYING THE GREAT CATHEDRALS OF EUROPE";
        String titleLine2 = "Z.Taylor, D.Black, R.Southern, B.Wallace";
        String titleLine3 = "CS2301/01 Spring 2015 Final Project";
        String titleLine4 = "press RIGHT ARROW for next screen";
        String titleLine5 = "press SPACE to play";

        GreenfootImage background = getBackground();

        background.setColor(myCol1);
        background.fillRect(0, 0, background.getWidth(), 70);

        java.awt.Font text1 = new java.awt.Font("Arial", java.awt.Font.BOLD, 16);
        background.setFont(text1);
        background.setColor(java.awt.Color.RED);
        background.drawString((titleLine1), 90, 20); 

        java.awt.Font text2 = new java.awt.Font("Times New Roman", java.awt.Font.BOLD, 12);
        background.setFont(text2);
        background.setColor(java.awt.Color.BLACK);
        background.drawString((titleLine2), 90, 40); 
        background.drawString((titleLine3), 90, 60); 

        Color myCol2 = new Color (0,0,255,40);
        background.setColor(myCol1);
        background.fillRect(190, 100, 220, 50);

        java.awt.Font text3 = new java.awt.Font("Arial", java.awt.Font.BOLD, 14);
        background.setFont(text3);
        background.setColor(java.awt.Color.WHITE);
        background.drawString((titleLine4), 200, 115); 
        background.drawString((titleLine5), 235, 140); 

    }

    public void act() 
    {       
        checkKeys();
        count = count + 1;
    }  

    public void checkKeys()
    {
        if ((Greenfoot.isKeyDown("left")) && currentBackground == "rules1.jpg" && count > 10  ) 
        {
            setBackground(new GreenfootImage("players1.jpg"));
            currentBackground = "players1.jpg";
            count = 0;
        }

        if ((Greenfoot.isKeyDown("left")) && currentBackground == "commands1.jpg" && count > 10)
        {
            setBackground(new GreenfootImage("rules1.jpg"));
            currentBackground = "rules1.jpg";
            count = 0;
        }

        else if ((Greenfoot.isKeyDown("right")) && currentBackground == "rules1.jpg" && count > 10 )
        {
            setBackground(new GreenfootImage("commands1.jpg"));
            currentBackground = "commands1.jpg";
            count = 0;
        }

        else if ((Greenfoot.isKeyDown("right")) && currentBackground == "players1.jpg" && count > 10  )
        {
            setBackground(new GreenfootImage("rules1.jpg"));
            currentBackground = "rules1.jpg";
            count = 0;
        }

        else if ((Greenfoot.isKeyDown("right")) && currentBackground == "church ruin 1.jpg" && count > 10  ) 
        {
            setBackground(new GreenfootImage("players1.jpg"));
            currentBackground = "players1.jpg";
            count = 0;
        }

        else if(Greenfoot.isKeyDown("space")){
            Greenfoot.playSound("select.wav");
            Greenfoot.setWorld(new Germany());
        }
        //Never could get else if sequence to go back from rules to players.  curious.
    }
}
