import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)

public class FinalScreen extends Actor
{
    private int score = 0;
    private int coins = 0;
    private int level = 0;
    private String text;

    /**
     * Create a counter without a text prefix, initialized to zero.
     */
    public FinalScreen()
    {
        this("", 0, 0, 0);
    }

    /**
     * Create a counter with a given text prefix, initialized to zero.
     */
    public FinalScreen(String prefix, int score, int coins, int level)
    {
        text = prefix;
        setImage(new GreenfootImage(300, 300));
        
        this.score = score;
        this.coins = coins;
        this.level = level;
        updateImage();
    }

    /**
     * Show the current text and count on this actor's image.
     */
    private void updateImage()
    {
        GreenfootImage image = getImage();
        image.clear();
        image.setColor(Color.WHITE);
        image.setFont(new Font("", true, false, 32));
        image.drawString(text + score + "\nLevel: " + level + "\nCoins: " + coins + "\nCoin Score: " + level * coins * 10 + "\n\nFinal Score: " + (score + ((coins * 10) * level)), 1, 32);
    }
}