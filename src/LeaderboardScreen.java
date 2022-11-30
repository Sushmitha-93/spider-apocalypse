import greenfoot.*;
import java.util.ArrayList;
/**
 * Write a description of class LeaderboardScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date) 
 */
public class LeaderboardScreen extends Screen implements IDisplayComponent
{   
    private LeaderboardScreenGlyphFactory lbGlyphFactory; 
    private final ArrayList<IDisplayComponent> components;

    /**
     * Constructor for objects of class LeaderboardScreen
     */
    public LeaderboardScreen(MyWorld world)
    {
        super(world, new GreenfootImage("leaderboard.png"));
        components = new ArrayList<>();
        lbGlyphFactory = LeaderboardScreenGlyphFactory.getInstance(world);
    
    }
    
    public void addSubComponent( IDisplayComponent c ) {
        components.add(c);
    };
    
    public void removeSubCompnent( IDisplayComponent c ) {
        components.remove(c);
    };
    
    public void display(){
        for (IDisplayComponent dc : components) {
            dc.display();
        }
    };
    
    public void setLocation(int x, int y){
    // do nothing
    }; 

    public void active()
    {
        super.active();
        //addSubComponent(lbGlyphFactory.screenTitle);
        addSubComponent(lbGlyphFactory.leaderboard);
        addSubComponent(lbGlyphFactory.backToMenuButton);
        display();
        act();

    }

    @Override
    public void act()
    {
        if(Greenfoot.mouseClicked(lbGlyphFactory.backToMenuButton)){
            lbGlyphFactory.backToMenuButton.onClick();
        }
    }
}
