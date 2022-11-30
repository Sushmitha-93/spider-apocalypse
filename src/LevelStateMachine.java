import greenfoot.*;  
/**
 * Write a description of class LevelStateMachine here.
 * 
 * @author (Dee) 
 * @version (v1.0)
 */
public class LevelStateMachine implements ILevelStateMachine, IScoreObserver 
{
    // instance variables - replace the example below with your own
    private ILevelState level1;
    private ILevelState level2;
    private ILevelState level3;
    private ILevelState currentLevel;
    private MyWorld myWorld;

    /**
     * Constructor for objects of class Level2
     */
    public LevelStateMachine(MyWorld world)
    {
        level1 = new Level1(this);
        level2 = new Level2(this);
        level3 = new Level3(this);
        myWorld = world;
        currentLevel = level1;
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void setLevel1() {
        currentLevel = level1;
        myWorld.addRocks(4); 
    }
    
    public void setLevel2() {
        currentLevel = level2;
        SinRock s_rock = new SinRock();
        myWorld.addObject(s_rock, myWorld.getWidth(), myWorld.getHeight() / 2);
    }
    
    public void setLevel3() {
        currentLevel = level3;
        int speed = HorizontalScrolling.getScrollSpeed() - 1;
        HorizontalScrolling.setScrollSpeed(speed);
    }
    
    public void setNextLevel() {
        currentLevel.nextLevel();
    }
}
