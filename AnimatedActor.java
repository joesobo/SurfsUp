import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)

/**
 * The AnimatedActor class serves as a superclass for other, more specific
 * Actor classes. It provides a mechanism to give actors an animated image.<p>
 * 
 * To use this class, you need a sequence of image files to be used for the
 * animation. Let's say we create four files named "cat0.png", "cat1.png",
 * "cat2.png" and "cat3.png". In this case, our base name would be "cat", the
 * suffix is ".png", and the number of images is 4.<p>
 * 
 * You can create an animated actor by subclassing this class, and calling this
 * class's constructor with the base name, suffix, and number of images as a 
 * parameter. So, to make an animated cat, I might have a subclass 'Cat' with 
 * the folling constructor"<p>
 * 
 * <pre>
 *   public Cat() {
 *       super("cat", ".png", 4);
 *   }
 * <pre>
 * 
 * The image files have to be numbered starting at 0, and they have to ve in the
 * scenario's 'image' folder.<p>
 * 
 * The image will change with every act step.
 * 
 * @author mik
 * @version 1.0
 */
public class AnimatedActor extends Actor
{
    private int animSlower = 2;
    private GreenfootImage[] images;
    private int currentImage = 0;
    private int animCount = 0;
    private int scale = 100;
   
    public AnimatedActor(String basename, String suffix, int noOfImages, int scale, boolean scaleUp)
    {
        this.scale = scale;
        images = new GreenfootImage[noOfImages];
        for(int i=0; i < noOfImages; i++) {
            images[i] = new GreenfootImage(basename + i + suffix);
            if (scaleUp)
                images[i].scale(images[i].getWidth() * scale, images[i].getHeight() * scale);
            else 
                images[i].scale(images[i].getWidth() / scale, images[i].getHeight() / scale);
        }
        setImage(images[currentImage]);
    }
    
    /**
     * Act - do whatever the AnimatedActor wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // slows the animation down a bit
        animCount++;
        if (animCount % animSlower == 0) currentImage = ((currentImage + 1) % images.length);
        GreenfootImage i = images[currentImage];
        setImage(i);
    }
    
    public void setScale(int scale) {
        this.scale = scale;
    }
    
    public void setAnimSlower(int slowBy) {
        this.animSlower = slowBy;
    }
    
    public void changeAnim(String basename, String suffix, int noOfImages, int scale, boolean scaleUp) {
        this.scale = scale;
        images = new GreenfootImage[noOfImages];
        for(int i=0; i < noOfImages; i++) {
            images[i] = new GreenfootImage(basename + i + suffix);
            if (scaleUp)
                images[i].scale(images[i].getWidth() * scale, images[i].getHeight() * scale);
            else 
                images[i].scale(images[i].getWidth() / scale, images[i].getHeight() / scale);
        }
        setImage(images[currentImage]);
    }
    
    public void transitionAnim(String basename, String suffix, int noOfImages, int scale, boolean scaleUp) {
        for (int i = 0; i < noOfImages; i++) {
            GreenfootImage current = new GreenfootImage(basename + i + suffix);
            if (scaleUp)
                current.scale(current.getWidth() * scale, current.getHeight() * scale);
            else
                current.scale(current.getWidth() / scale, current.getHeight() / scale);
                
            setImage(current);
        }
        
    }
}
