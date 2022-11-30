import greenfoot.*; 
/**
 * Write a description of class Glyph here.
 * 
 * @author (Jing) 
 * @version (v1.0)
 */
public abstract class Glyph extends Actor implements IDisplayComponent 
{
    protected GreenfootImage img;
    protected int x, y; // location 
    protected MyWorld world;
    protected static final GreenfootSound clickSound = new GreenfootSound("select-click.mp3");
    
    /**
     * Constructor for objects of class Glyph
     */
    public Glyph(MyWorld world)
    {
        this.world = world;
    };
    public void addSubComponent( IDisplayComponent c ) {
        // nothing
    };
    
    public void removeSubCompnent( IDisplayComponent c ) {
        // nothing
    };
    
    public void setLocation(int x, int y) {
        this.x = x;
        this.y = y;
    };
    public void display(){
        world.addObject(this, x, y);
    };

    public abstract void create(Boolean hasInputImg, String text, int fontSize, Color textColor, int width, int height, Color backgroundColor);

}
