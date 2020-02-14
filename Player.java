
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.ArrayList;

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    private double xVel = 0;
    private double yVel = 0;
    private double xPos = 0;
    private double yPos = 0;
    private GreenfootImage player;
    List<Health> healthList = new ArrayList<Health>();
    private int hitCooldown = 0;
    private int trailCount = 0;
    private int trailFreq = 20;
    private int coinWorth = 100;
    private int coins = 0;
    private int invincibleTimer = 0;
    private InvincibleDisplay invincible;
    private GreenfootSound hurt = new GreenfootSound("hurt.wav");

    public Player(){
        hurt.setVolume(76);
        player = getImage();
    }

    public void addedToWorld(World world){
        xPos = getX();
        yPos = getY();

        world.addObject(new Health(), 15, 15);
        world.addObject(new Health(), 45, 15);
        world.addObject(new Health(), 75, 15);

        healthList = world.getObjects(Health.class);
    }

    public void act() 
    {
        processKeys();

        setLocation(getX(), (int)xPos);
        setLocation(getY(), (int)yPos);

        checkCollision();

        handleTrailDrop();
        trailCount++;

        if(hitCooldown > 0){
            hitCooldown--;
        }
        if(invincible != null){
            if(invincibleTimer > 0){
                invincibleTimer--;
                invincible.setPos(getX(), getY());
            }else{
                getWorld().removeObject(invincible);
            }
        }
    }    

    private void processKeys(){
        if(Greenfoot.isKeyDown("right")){
            xVel += 0.5;
        }
        if(Greenfoot.isKeyDown("left")){
            xVel -= 0.5;
        }
        if(Greenfoot.isKeyDown("up")){
            yVel += 0.5;
        }
        if(Greenfoot.isKeyDown("down")){
            yVel -= 0.5;
        }

        if(yVel > 0){
            yPos -= yVel / 10;
            yVel -= 0.01;
        }
        if(yVel < 0){
            yPos -= yVel / 10;
            yVel += 0.01;
        }
        if(xVel > 0){
            xPos += xVel / 10;
            xVel -= 0.01;
        }
        if(xVel < 0){
            xPos += xVel / 10;
            xVel += 0.01;
        }

        setImage(player);
    }

    private void checkCollision(){
        //check floor
        if(getY() > 590){
            yVel = 0;
            yPos = 590;
        }
        //check ceiling
        if(getY() < 10){
            yVel = 0;
            yPos = 10;
        }

        //check right wall
        if(getX() > 590){
            xVel = 0;
            xPos = 590;
        }
        //check left wall
        if(getX() < 10){
            xVel = 0;
            xPos = 10;
        }
    }

    public void hitPlayer(){

        if (isTouching(Barrel.class) || isTouching(Shark.class)){
            if(hitCooldown == 0 && invincibleTimer == 0){
                if (isTouching(Shark.class)) Greenfoot.playSound("bite.wav");
                hitCooldown = 15;
                removeHealth();
                hurt.play();
            }
        }
        if(getWorld() != null){
            if(getWorld().getObjects(Player.class).size() != 0){
                if (isTouching(Heart.class)){
                    addHealth();
                    Greenfoot.playSound("heart.wav");
                }
            }
        }
        if(getWorld() != null){
            if(getWorld().getObjects(Player.class).size() != 0){
                if (isTouching(Invulnerable.class)){
                    Greenfoot.playSound("invu.wav");
                    invincibleTimer = 150;
                    if (invincible != null) getWorld().removeObject(invincible);
                    invincible = new InvincibleDisplay();
                    getWorld().addObject(invincible, getX(), getY());
                    invincible.setLocation(getX(), getY());
                }
            }
        }
        if(getWorld() != null){
            if(getWorld().getObjects(Player.class).size() != 0){
                if (isTouching(Coin.class)){
                    //getWorld().getObjects(Counter.class).get(0).incrementAmount(coinWorth);
                    coins++;
                }
            }
        }
    }

    private void removePlayer(){
        if(getWorld() != null){
            //start displaying final score
            FinalScreen finalScreen = new FinalScreen("Score: ", getWorld().getObjects(Counter.class).get(0).value, coins, (int)Math.floor(getWorld().getObjects(Counter.class).get(0).value / 1000));
            int x = 300;
            int y = 300;
            
            getWorld().addObject(new RipImage(),x , y);
            getWorld().addObject(finalScreen, x, y);            
            
            //destroy player
            getWorld().removeObject(this);
            
        }
    }

    private void removeHealth(){
        int size = healthList.size();

        getWorld().addObject(new HitVisual(), 300, 320);

        if(getWorld() != null){
            getWorld().removeObject(healthList.get(size-1));
            healthList.remove(size-1);
        }

        if(size == 1){
            removePlayer();
        }
    }
    
    private void addHealth(){
        int size = healthList.size();
        
        if(getWorld() != null){
            if(size > 0 && size < 3){
                if(size == 2){
                    getWorld().addObject(new Health(), 75, 15);
        
                }else{
                    getWorld().addObject(new Health(), 45, 15);
                }
                healthList = getWorld().getObjects(Health.class);
            }
        }
    }

    private void handleTrailDrop(){
        if(trailCount % trailFreq == 0){
            WaterTrail t = new WaterTrail();
            getWorld().addObject(t, getX(), getY());
        }
    }
}
