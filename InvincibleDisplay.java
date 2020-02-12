import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class InvincibleDisplay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class InvincibleDisplay extends Actor
{
    int x = 0;
    int y = 0;
    
    public InvincibleDisplay(){
        updateImage();
    }
    
    public void setPos(int xPos, int yPos){
        setLocation(xPos, yPos);
        updateImage();
    }
    
    private void updateImage(){
        int size = 50;
        GreenfootImage image = new GreenfootImage(size + 1, size + 1);
        int alpha = 60;
        image.setColor(new Color(50, 200, 150, alpha));
        image.fillOval(0, 0, size, size);
        setImage(image);
    }
}
