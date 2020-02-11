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
    private int coinSpawnChance = 1;
    
    public void act(){
        if(getWorld().getObjects(Player.class) != null){
            if(getWorld().getObjects(Obstacle.class).size() < 10){
                createObstacle();
            }
        }
    }
    
    private void createObstacle(){
       int coinSpawn = getRandomNumber(0, coinSpawnChance);
       if(coinSpawn == 1){
           getWorld().addObject(new Coin(), Greenfoot.getRandomNumber(600), 600);
       }else{
           getWorld().addObject(new Barrel(), Greenfoot.getRandomNumber(600), 600);
       }
    }
    
    public int getRandomNumber(int start,int end){
       int normal = Greenfoot.getRandomNumber(end-start+1);
       return normal+start;
    }
}
