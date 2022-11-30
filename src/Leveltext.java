import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Leveltext here.
 * 
 * @author (Joseph, Dee) 
 * @version (v1.1)
 */
public class Leveltext extends Actor
{
    private int level = 1;
    /**
     * Act - do whatever the Leveltext wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        update();
    }
    
    public void update()
    {
        World world = getWorld();
        MyWorld myWorld = (MyWorld)world;
        Counter counter = myWorld.getCounter();
        int value = counter.getValue();
        if (value <= 100){
            level = 1;
        }  else if (value <= 400) {
            level = 2;
        } else {
            level = 3;
        }
        GreenfootImage img = getImage();
        img.clear();
        setImage(new GreenfootImage("Level : " + level , 25 , Color.ORANGE, Color.BLACK));
    }
    
}
