import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SinRock here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class SinRock extends Rock
{
    private boolean destroyed = false;
    private double d;
    private int y;
    private int speed;
    /**
     * Act - do whatever the SinRock wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public SinRock() {
        this.d = 0.0;
        this.y = 600;
        this.speed = 4;
        setImage(new GifImage("rocket.gif").getCurrentImage()); 
        
    }
 
    
    @Override
    public void scroll()
    {
        if (!destroyed) {
            if ( isAtEdge() )
            {
                reset(); 
            } else {
                this.d += 0.02;
                this.y = this.getY() - (int)(Math.sin(this.d) * 4.5);
                setLocation(this.getX() - this.speed, this.y);
            }
        } else {
            super.reset();
            this.destroyed = false;
        }
    }
}
