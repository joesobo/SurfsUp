import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class WaterTrail here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WaterTrail extends Actor
{
    private final static int MAX_INTENSITY = 180;
    private int intensity;
    
    public WaterTrail(){
        intensity = MAX_INTENSITY;
        updateImage();
    }    
    
    public void act() 
    {
        intensity -= 0.1;
        if (intensity <= 0){
            getWorld().removeObject(this);
        }else{
            if ((intensity % 4) == 0) {
                updateImage();
            }
        }
    }
    
    private void updateImage(){
        int size = intensity / 3 + 2;
        GreenfootImage image = new GreenfootImage(size + 1, size + 1);
        int alpha = intensity / 3;
        image.setColor(new Color(255, 255, 255, alpha));
        image.fillOval(0, 0, size, size);
        setImage(image);
    }
}
