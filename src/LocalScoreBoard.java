import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * An actor class that can display a scoreboard locally, using arraylist to track score.
 * Based on default ScoreBoard class in Greenfoot.
 * @author Team 8
 * @version 1.0
 */
public class LocalScoreBoard extends Actor implements IDisplayComponent
{
    // The vertical gap between user images in the scoreboard:
    private static final int GAP = 10;
    // The height of the "All Players"/"Near Me" text at the top:
    private static final int HEADER_TEXT_HEIGHT = 25;
    // The main text color:
    private static final Color MAIN_COLOR = new Color(0x60, 0x60, 0x60); // dark grey
    // The score color:
    private static final Color SCORE_COLOR = new Color(0xB0, 0x40, 0x40); // orange-y
    // The background colors:
    private static final Color BACKGROUND_COLOR = new Color(0xFF, 0xFF, 0xFF, 0xB0);
    private static final Color BACKGROUND_HIGHLIGHT_COLOR = new Color(180, 230, 255, 0xB0);

    private static LocalScoreBoard instance;
    protected GreenfootImage img;
    protected int x, y; // location 
    protected MyWorld world;
    private ArrayList<Integer> scores;
    
    /**
     * Constructor for objects of class ScoreBoard.
     * <p>
     * You can specify the width and height that the score board should be, but
     * a minimum width of 600 will be enforced.
     */
    
    private LocalScoreBoard(int width, int height, MyWorld world) {
        this.world = world;
        setImage(new GreenfootImage(Math.max(600, width), height)); 
    }
    
    public static LocalScoreBoard getInstance(int width, int height, MyWorld world) {
        if (instance == null) {
            instance = new LocalScoreBoard(width, height, world);
        }
        return instance;
    }
    
    public static void reset() {
        instance = null;
    }
    
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
    
    private void drawString(String text, int x, int y, Color color, int height)
    {   
        getImage().drawImage(new GreenfootImage(text, height, color, new Color (0,0,0,0)), x, y);
    }
    
    public void drawNewScore(String text, int x, int y, Color color, int height)
    {   
        getImage().clear();
        getImage().drawImage(new GreenfootImage(text, height, color, new Color (0,0,0,0)), x, y);
    }
    
    public void drawScores()
    {
        // 50 pixels is the max height of the user image
        final int pixelsPerUser = 50 + 2*GAP;
        // Calculate how many users we have room for:
        final int numUsers = ((getImage().getHeight() - (HEADER_TEXT_HEIGHT + 10)) / pixelsPerUser);
        final int topSpace = getImage().getHeight() - (numUsers * pixelsPerUser) - GAP;
        
        getImage().setColor(BACKGROUND_COLOR);
        getImage().fill();

        drawString("All Players", 100, topSpace - HEADER_TEXT_HEIGHT - 5, MAIN_COLOR, HEADER_TEXT_HEIGHT);
        drawString("Near You", 100 + getImage().getWidth() / 2, topSpace - HEADER_TEXT_HEIGHT - 5, MAIN_COLOR, HEADER_TEXT_HEIGHT);        
        
        //localDrawUserPanel(GAP, topSpace, (getImage().getWidth() / 2) - GAP, topSpace + numUsers * pixelsPerUser, world.getScores());
        drawUserPanel(GAP, topSpace, (getImage().getWidth() / 2) - GAP, topSpace + numUsers * pixelsPerUser, UserInfo.getTop(numUsers));
        drawUserPanel(GAP + getImage().getWidth() / 2, topSpace, getImage().getWidth() - GAP, topSpace + numUsers * pixelsPerUser, UserInfo.getNearby(numUsers));
    }
    
    private void localDrawUserPanel(int left, int top, int right, int bottom, LocalScoreList scores)
    {
        getImage().setColor(MAIN_COLOR);
        getImage().drawRect(left, top, right - left, bottom - top);
        
        if (scores == null) {
            return;
        }
        
        UserInfo me = UserInfo.getMyInfo();
        int y = top + GAP;
        for (int i = 0; i < scores.getSize(); i++)
        {            
            getImage().fillRect(left + 5, y - GAP + 1, right - left - 10, 50 + 2*GAP - 1);

            int x = left + 10;
            drawString("#" + Integer.toString(i), x, y+18, MAIN_COLOR, 14);
            x += 50;
            drawString(Integer.toString(scores.getScore(i)), x, y+18, SCORE_COLOR, 14);
            x += 80;
            x += 55;
            y += 50 + 2*GAP;
        }
    }
    
    private void drawUserPanel(int left, int top, int right, int bottom, List users)
    {
        getImage().setColor(MAIN_COLOR);
        getImage().drawRect(left, top, right - left, bottom - top);
        
        if (users == null) {
            return;
        }
        
        UserInfo me = UserInfo.getMyInfo();
        int y = top + GAP;
        for (Object obj : users)
        {
            UserInfo playerData = (UserInfo)obj;            
            Color c;
            
            if (me != null && playerData.getUserName().equals(me.getUserName()))
            {
                // Highlight our row in a sky blue colour:
                c = BACKGROUND_HIGHLIGHT_COLOR;
            }
            else
            {
                c = BACKGROUND_COLOR;
            }
            getImage().setColor(c);
            getImage().fillRect(left + 5, y - GAP + 1, right - left - 10, 50 + 2*GAP - 1);

            int x = left + 10;
            drawString("#" + Integer.toString(playerData.getRank()), x, y+18, MAIN_COLOR, 14);
            x += 25;
            drawString(playerData.getString(0), x, y+18, MAIN_COLOR, 14);
            x += 25;
            drawString(Integer.toString(playerData.getScore()), x, y+18, SCORE_COLOR, 14);
            x += 80;
            getImage().drawImage(playerData.getUserImage(), x, y);
            x += 55;
            drawString(playerData.getUserName(), x, y + 18, MAIN_COLOR, 14);
            y += 50 + 2*GAP;
        }
    }
}
