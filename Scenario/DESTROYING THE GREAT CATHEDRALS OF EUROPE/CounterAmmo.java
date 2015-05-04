import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)

import java.awt.Color;
import java.awt.Graphics;

/**
 * Display showing information regarding the state of the game.
 */
public class CounterAmmo extends Actor
{
    int Ammo = 0;
    public void act() {
        getAmmo();
        setImage (new GreenfootImage("Ammo : " + Ammo, 24, Color.ORANGE, Color.BLACK ));
        
    }
    
        public void addAmmo()
    {
        Ammo+=3;
    }
    public void removeAmmo()
    {
        Ammo--;
    }

    public void setAmmo(int a){
        Ammo = a;
    }
    public void getAmmo(){
    Player p = (Player) getWorld().getObjects(Player.class).get(0);
    if (p!= null){
    Ammo = p.ammo;
}
}
}
