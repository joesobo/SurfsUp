import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ObstacleSpawner here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ObstacleSpawner extends Actor
{
    int numOfObj = 10;
    
    public void act(){
        if(getWorld().getObjects(Player.class) != null){
            if(getWorld().getObjects(Obstacle.class).size() < 10){
                createObstacle();
            }
        }
    }
    
    private void createObstacle(){
       getWorld().addObject(new Barrel(), Greenfoot.getRandomNumber(600), 600);
    }
}
