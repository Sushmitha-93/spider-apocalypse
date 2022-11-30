import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Rock here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Rock extends HorizontalScrolling
{
    private boolean destroyed = false;
    /**
     * Act - do whatever the Salmon wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if (!destroyed) {
            super.act();
        } else {
            super.reset();
            this.destroyed = false;
        }
    }
    
    public void destroyed() {
        this.destroyed = true;
    }
}
