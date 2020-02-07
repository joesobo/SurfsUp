import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Health here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Health extends Actor
{
    public Health()
    {
        GreenfootImage image = getImage();
        image.scale(image.getWidth() - 25, image.getHeight() - 25);
        setImage(image);
    }
}
