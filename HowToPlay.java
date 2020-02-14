import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HowToPlay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HowToPlay extends World
{

    private GifImage howto = new GifImage("howtoplay.gif");
    public HowToPlay()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
    }
    
    public void act() {
        setBackground(howto.getCurrentImage());
        if (Greenfoot.isKeyDown("space")) Greenfoot.setWorld(new MyWorld());
    }

}
