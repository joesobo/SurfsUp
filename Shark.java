import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

public class Shark extends AnimatedActor
{
    private final int MOVE_SLOWER = 5;
    private int frames = 0;
    private int direction = 1; // -1 is left and 1 is right
    private Player player = null;
    
    public Shark() {
        super("finright_", ".png", 5, 3, true); // last param is boolean scale up
        super.setAnimSlower(5);
    }
    public void act() 
    {
        // Add your action code here.
        super.act();
        if(getWorld() != null){
            if(getWorld().getObjects(Player.class).size() != 0){
                player = getWorld().getObjects(Player.class).get(0);
            }
        }
        frames++;
        if (frames % MOVE_SLOWER == 0) {
            moveToSurfer();
        }
        checkHit();
    }
    
    private void moveToSurfer() {
        List l = getObjectsInRange(1000, null);
        for (Object o : l) {
            if (o.getClass() == Player.class) {
                // found a surfer, time to attack >:)
                Player s = ((Player) o);
                int surferX = s.getX();
                int surferY = s.getY();
                // x movement
                if (surferX - getX() > 0) {
                    setLocation(getX()+1, getY());
                    if (Math.abs(surferX - getX()) < 10) {
                        super.changeAnim("finforward_", ".png", 5, 3, true);
                    }
                    else 
                        super.changeAnim("finright_", ".png", 5, 3, true);
                }
                else if (surferX - getX() < 0) {
                    setLocation(getX()-1, getY());
                    if (Math.abs(surferX - getX()) < 10) {
                        super.changeAnim("finforward_", ".png", 5, 3, true);
                    }
                    else 
                        super.changeAnim("finleft_", ".png", 5, 3, true);
                }
                else {
                    super.changeAnim("finforward_", ".png", 5, 3, true);
                }
                
                // y movement
                if (surferY - getY() > 0) {
                    setLocation(getX(), getY()+1);
                }
                else if (surferY - getY() < 0) {
                    setLocation(getX(), getY()-1);
                }
                
            }
        }
    }
    
    private void checkHit(){
        if(getWorld() != null){
            if(getWorld().getObjects(Player.class).size() != 0){
                if(isTouching(Player.class)){
                    player.hitPlayer();
                }
            }
        }
    }
    
    
}
