import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Random;

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    Player player;
    
    private GifImage water = new GifImage("water.gif");
    private GreenfootSound music = new GreenfootSound("music.mp3");
    String[] sounds = {"yes_1.wav", "yes_2.wav", "come_on_1.wav", "you_got_it_1.wav"};
    
    public MyWorld()
    {    
        super(600, 600, 1);
        player = new Player();
        addObject(player, 300, 300);
        addObject(new Surfer(), 300, 300);
        addObject(new ScoreCounter(), 300, 300);
        addObject(new ObstacleSpawner(), 300, 300); 
        addObject(new Shark(), 30, 30);
        
        setPaintOrder(FinalScreen.class, RipImage.class, Counter.class, Health.class, InvincibleDisplay.class, Player.class, Surfer.class, Obstacle.class, WaterTrail.class);
    }
    public void act() {
        setBackground(water.getCurrentImage());
        if(!music.isPlaying())
        {
            music.setVolume(20);
            music.play();
        }
        makeSick();
    }
    
    public void makeSick() {
        if (getObjects(Counter.class).size() > 0) {
            if ((getObjects(Counter.class).get(0).value % 1000) == 0) {
                Random r = new Random();
                int randomNumber = r.nextInt(sounds.length);
                Greenfoot.playSound(sounds[randomNumber]);
                addObject(new Sick(), player.getX(), player.getY());
            }            
        }
    }
}
