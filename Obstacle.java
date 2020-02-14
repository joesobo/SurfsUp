import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Random;
/**
 * Write a description of class Obstacle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Obstacle extends Actor
{
    public double xPos = 0;
    public double yPos = 0;
    private Player player = null;
    private String soundFile = null;
    
    public void act() {
        if(getWorld() != null){
            if(getWorld().getObjects(Player.class).size() != 0){
                setLocation(getX(), (int)xPos);
                setLocation(getY(), (int)yPos);

                checkHit();
            }
        }
    }  
    
    private void move(){}
    
    private void checkHit(){
        if(getWorld() != null){
            if(getWorld().getObjects(Player.class).size() != 0){
                if(isTouching(Player.class)){
                    player.hitPlayer();
                    if (soundFile != null) {
                        GreenfootSound sound = new GreenfootSound(soundFile);
                        sound.setVolume(80);
                        sound.play();
                        
                    }
                    getWorld().removeObject(this);
                }
            }
        }
    }
    
    public double getXPos(){
        return xPos;
    }
    
    public double getYPos(){
        return yPos;
    }
    
    public void setXPos(double x){
        xPos = x;
    }
    
    public void setYPos(double y){
        yPos = y;
    }
    
    public Player getPlayer(){
        return player;
    }
    
    public void setPlayer(Player p){
        player = p;
    }
    
    public void setSound(String filename) {
        this.soundFile = filename;
    }
   
}
