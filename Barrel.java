import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Random;
/**
 * Write a description of class Obstacle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Barrel extends Obstacle
{
    private int maxSpeed = 0;
    private double minSpeed = 0.5;
    private double speed = 0;
    //high values = slower increase
    private int rateOfSpeedIncrease = 1000;
    private String[] images = {"barrel.png", "firehydrant.png", 
        "cat.png", "tree.png"};
    
    public Barrel() {
        super.setSound("impact.wav");
    }
    
    public void addedToWorld(World world){
        maxSpeed = (int)Math.floor(getWorld().getObjects(Counter.class).get(0).value / rateOfSpeedIncrease);
        speed = minSpeed + Math.random() * (maxSpeed + 1);
        setRandImage();
        super.setXPos(getX());
        super.setYPos(getY());
        if(getWorld() != null){
            if(getWorld().getObjects(Player.class).size() != 0){
                super.setPlayer(getWorld().getObjects(Player.class).get(0));
            }
        }
    }

    public void act() {
        if(getWorld() != null){
            if(getWorld().getObjects(Player.class).size() != 0){
                move();
            }
        }
        
        super.act();
        
        checkHeight();
    } 

    private void move()
    {
        yPos -= speed;
    }

    private void checkHeight(){
        if(yPos <= 10){
            getWorld().removeObject(this);
        }
    }
    
    public void setRandImage() {
        Random r = new Random();
        int randomNumber = r.nextInt(images.length);
        setImage(images[randomNumber]);
    }
}
