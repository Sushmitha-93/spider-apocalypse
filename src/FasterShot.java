import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FasterShot here.
 * 
 * @author (Dee) 
 * @version (v1.0)
 */
public class FasterShot extends Buff
{
    /**
     * Act - do whatever the FasterShot wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private static FasterShot theFSinstance;
    
    private FasterShot() {
        super();
    }
    
    public synchronized static FasterShot getInstance()
    {
        if (theFSinstance == null)
            theFSinstance = new FasterShot();
        return theFSinstance;
    }
    
    public static void resetInstance() {
        theFSinstance = null;
    }
    
    public void act()
    {
        // Add your action code here.
        super.act();
    }
    
    @Override
    protected void setImg() {
        if (this.getImage().toString().contains("fasterShot.png"))
        {   
            // set transparent img
            setImage(new GreenfootImage(10,10));
        } else {
            setImage(new GreenfootImage("fasterShot.png"));
            this.getImage().scale(40,40);
        }
    }
}
