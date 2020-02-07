import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    Player player;
    
    public MyWorld()
    {    
        super(600, 600, 1);
        player = new Player();
        addObject(player, 300, 300);
        addObject(new ScoreCounter(), 300, 300);
        addObject(new ObstacleSpawner(), 300, 300);
        
        setPaintOrder(Counter.class, Obstacle.class);
    }
}
