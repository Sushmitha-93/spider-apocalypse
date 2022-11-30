import greenfoot.*; 
/**
 * Write a description of class MenuScreenGlyphFactory here.
 * 
 * @author (Jing) 
 * @version (v1.0)
 */
public class LeaderboardScreenGlyphFactory implements IGlyphFactory
{
    public static Button backToMenuButton;
    public static Label screenTitle;
    public static LocalScoreBoard leaderboard;
    private Color backToMenuButtonBgColor;
    private Color backToMenuButtonTxtColor;
    private static LeaderboardScreenGlyphFactory leaderboardScreenGlyphFactory = null;
    private MyWorld world;
    /**
     * Constructor for objects of class MenuScreenGlyphFactory
     */
    private LeaderboardScreenGlyphFactory(MyWorld world)
    {
        this.world = world;
        CreateButton();
        CreateLabel();
    }

    public static void reset() {
        leaderboardScreenGlyphFactory = null;
    }
    
    public synchronized static LeaderboardScreenGlyphFactory getInstance(MyWorld world) {
        if(leaderboardScreenGlyphFactory == null) {
            leaderboardScreenGlyphFactory = new LeaderboardScreenGlyphFactory(world);
        }
        return leaderboardScreenGlyphFactory;
    }
    
    public void CreateButton() {
        backToMenuButton = new Button(world);
        backToMenuButton.create(false, "Back", 30, new Color(0, 0, 0, 0), world.WIDTH/4, world.HEIGHT/10, new Color(0, 0, 0, 0));
        backToMenuButton.setLocation(world.WIDTH/2, world.HEIGHT*8/9);
        backToMenuButton.setNextScreen(MyWorld.SCREENS.MENU);
    }
    
    public void CreateLabel() {
        //screenTitle = new Label(world);
        //screenTitle.create(false, "Leaderboard", 50, Color.RED, world.WIDTH/2, world.HEIGHT/8, new Color(0, 0, 0, 0));
        //screenTitle.setLocation(world.WIDTH/2, world.HEIGHT/6);

        leaderboard = LocalScoreBoard.getInstance(400,300,world);
        leaderboard.setLocation(world.WIDTH/2, world.HEIGHT/2);
    }
}
