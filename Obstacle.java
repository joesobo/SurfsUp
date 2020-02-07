import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Obstacle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Obstacle extends Actor
{
    private double SPEED = Greenfoot.getRandomNumber(3) + 1;
    private double xPos = 0;
    private double yPos = 0;
    private Player player = null;
    
    public void addedToWorld(World world){
        xPos = getX();
        yPos = getY();
        if(getWorld() != null){
            if(getWorld().getObjects(Player.class).size() != 0){
                player = getWorld().getObjects(Player.class).get(0);
            }
        }
    }
    
    public void act() 
    {
        move();
        
        setLocation(getX(), (int)xPos);
        setLocation(getY(), (int)yPos);
        
        checkHeight();
        checkHit();
    } 
    
    private void move()
    {
        yPos -= SPEED;
    }
    
    private void checkHeight(){
        if(yPos <= 10){
            getWorld().removeObject(this);
        }
    }
    
    private void checkHit(){
        if(getWorld() != null){
            if(isTouching(Player.class)){
                player.hitPlayer();
                getWorld().removeObject(this);
            }
        }
    }
}
