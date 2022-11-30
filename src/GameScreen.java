import greenfoot.*;
/**
 * Write a description of class GameS here.
 * 
 * @author (Jing) 
 * @version (v1.0)
 */
public class GameScreen extends Screen 
{

    private static boolean initialized = false;
    
    /**
     * Constructor for objects of class GameS
     */
    public GameScreen(MyWorld world)
    {
        super(world, new GreenfootImage("space.jpg"));
    }

    public static void initialize() {
        initialized= false;
        Buff.reset();
    }
    
    public void active()
    {
        super.active();
        act();
    }
    
    @Override
    public void act()
    {
        if (!initialized) {
            world.prepare();
            initialized = true;
        }
    }
}
