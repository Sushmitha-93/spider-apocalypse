/**
 * Write a description of class Settings here.
 * 
 * @author (Jing) 
 * @version (v1.0)
 */
public class Settings  
{
    private MODE mode;
    
    private static Settings theSettings = null;
    
    public enum MODE {
        ONE_PLAYER,
        TWO_PLAYER
    }
    /**
     * Constructor for objects of class Settings
     */
    public Settings()
    {
        this.mode = MODE.ONE_PLAYER;
    }
    
    public synchronized static Settings getInstance() {
        if(theSettings == null) {
            theSettings = new Settings();
            return theSettings;
        }
        return theSettings;
    }

    public MODE getPlayMode() {
        return mode;
    }
    
    public void setPlayMode(MODE mode) {
        this.mode = mode;
    }
    
}