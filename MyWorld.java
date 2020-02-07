import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.ArrayList;

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    Player player;
    private Counter counter;
    
    public MyWorld()
    {    
        super(600, 600, 1);
        player = new Player();
        addObject(player, 300, 300);
        addObject(new ObstacleSpawner(), 300, 300);
    }
    
    public void act(){
        countScore();
    }
    
    public void countScore(){
        if(counter == null){
            counter = new Counter("Score: ");
            int x = 400;
            int y = 400;
            
            addObject(counter, x, y);
        }
        counter.increment();
    }
}
