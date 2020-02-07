import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ScoreCounter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ScoreCounter extends Actor
{
    private Counter counter;
    
    public void act() 
    {
        countScore();
    } 
    
    public void countScore(){
        if(counter == null){
            counter = new Counter("Score: ");
            int x = 525;
            int y = 25;
            
            getWorld().addObject(counter, x, y);
        }
        if(getWorld().getObjects(Player.class).size() != 0){
            counter.increment();
        }
    }
}
