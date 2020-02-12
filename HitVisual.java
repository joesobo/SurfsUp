import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HitVisual here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HitVisual extends Actor
{
    private int timer;
    private int transparency = 150;
    private GreenfootImage image;
    
    public HitVisual() 
    {
        image = getImage();
        image.scale(image.getWidth() + 600, image.getHeight() + 600);
        image.setTransparency(transparency);
        setImage(image);
        timer = 15;
    }
    
    public void act(){
        if(timer > 0){
            timer--;
            transparency -= 10;
            image.setTransparency(transparency);
            setImage(image);
        }
        if(timer == 0){
            getWorld().removeObject(this);
        }
    }
}
