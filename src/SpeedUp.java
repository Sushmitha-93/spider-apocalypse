import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SpeedUp here.
 * 
 * @author (Dee) 
 * @version (v1.0)
 */
public class SpeedUp extends Buff
{
    /**
     * Act - do whatever the SpeedUp wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private static SpeedUp theSUinstance;
    
    private SpeedUp() {
        super();
    }
    
    public synchronized static SpeedUp getInstance()
    {
        if (theSUinstance == null)
            theSUinstance = new SpeedUp();
        return theSUinstance;
    }
    
    public static void resetInstance() {
        theSUinstance = null;
    }
    
    public void act()
    {
        // Add your action code here.
        super.act();
    }
    
    @Override
    protected void setImg() {
        if (this.getImage().toString().contains("speedup.png"))
        {   
            // set transparent img
            setImage(new GreenfootImage(10,10));
        } else {
            setImage(new GreenfootImage("speedup.png"));
            this.getImage().scale(40,40);
        }
    }
    
}
