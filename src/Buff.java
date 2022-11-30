import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Buff here.
 * 
 * @author (Dee) 
 * @version (V1.0)
 */
public class Buff extends Actor implements IStopObserver
{
    /**
     * Act - do whatever the Buff wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    private static int timer;
    private int duration;
    private int frequency;
    private static boolean isStopped;
    
    protected Buff() {
         timer = 0;
         duration = 150;
         frequency = 20;
         GreenfootImage image = getImage();  
         image.scale(40,40);
         setImage(image);
         isStopped = false;
    }
    
    public void act()
    {
        if (!isStopped) {
            timer++;
            if (timer < duration) {
                if (timer % (frequency * 2) == 0) {
                    setImg();
                }
            } else if (timer < 1.5 * duration) {
                if (timer % frequency == 0) {
                    setImg();
                }
            } else if (timer < 2 * duration) {
                if (timer % (frequency / 2) == 0) {
                    setImg();
                }
            } else {
                getWorld().removeObject(this);
                timer = 0;
            }
        }
    }
    
    protected void setImg() {
        // wait for override
    }

    public void stop() {
        isStopped = true;
    }
    
    public static void reset() {
        isStopped = false;
        timer = 0;
    }
}
