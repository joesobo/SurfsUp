import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Surfer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Surfer extends AnimatedActor
{
    public Surfer() {
        super("frontidle_", ".png", 8, 2, true);
        super.setAnimSlower(4);
    }
    public void act() 
    {
        super.act();
        if (getWorld() != null) {
            if (getWorld().getObjects(Player.class).size() != 0) {
                Player player = getWorld().getObjects(Player.class).get(0);
                setLocation(player.getX()+7, player.getY()-15);
            }
            else {
                getWorld().removeObject(this);  
            }
        }
    }    
}
