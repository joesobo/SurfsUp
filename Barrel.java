import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Obstacle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Barrel extends Obstacle
{
    private int maxSpeed = 0;
    private double speed = 0;
    
    public void addedToWorld(World world){
        maxSpeed = (int)Math.floor(getWorld().getObjects(Counter.class).get(0).value / 1000);
        int ran = Greenfoot.getRandomNumber((10 * maxSpeed) + 1) + 10;
        speed = (double)ran / 10;

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
}
