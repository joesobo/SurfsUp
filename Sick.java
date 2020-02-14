import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Random;
/**
 * Write a description of class Sick here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Sick extends Actor
{
    private GifImage sick = new GifImage("sick.gif");
    int time = 0;
    
    public void act() 
    {
        setImage(sick.getCurrentImage());
        time++;
        if (getWorld() != null) {
            if (getWorld().getObjects(Player.class).size() != 0) {
                Player player = getWorld().getObjects(Player.class).get(0);
                setLocation(player.getX(), player.getY()-80);
            }
            else {
                getWorld().removeObject(this);  
            }
        }
        if (time > 200) {
           getWorld().removeObject(this); 
        }
    }    
}
