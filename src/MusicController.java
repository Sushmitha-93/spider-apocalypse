import greenfoot.Greenfoot;
import greenfoot.GreenfootSound;
import java.util.HashMap;

/**
 * Write a description of class musicController here.
 * 
 * @author (Jing) 
 * @version (v1.0)
 */
public class MusicController  
{
    private HashMap<MusicState, GreenfootSound> musicMap;
    private final GreenfootSound startMusic = new GreenfootSound("startMusic.mp3");
    private final GreenfootSound gameMusic = new GreenfootSound("gameMusic.mp3");
    private final GreenfootSound gameOverMusic = new GreenfootSound("gameOver.mp3");
    
    private static MusicController theMusicController = null;
    
    private MusicState currentMusicState = MusicState.NO_MUSIC;

    enum MusicState {
        START,
        GAME,
        GAME_OVER,
        NO_MUSIC
    }
    /**
     * Constructor for objects of class musicController
     */
    public MusicController(){}

    public synchronized static MusicController getNewInstance() {
            theMusicController = new MusicController();
            theMusicController.startUp();
            return theMusicController;
    }
    
    public synchronized static MusicController getInstance() {
        if(theMusicController == null) {
            return getNewInstance();
        }
        return theMusicController;
    }

    public void startUp() {
        musicMap = new HashMap<>();
        musicMap.put(MusicState.START,startMusic);
        musicMap.put(MusicState.GAME,gameMusic);
        musicMap.put(MusicState.GAME_OVER,gameOverMusic);
        
        currentMusicState = MusicState.START;
        musicMap.get(currentMusicState).stop();
    }
    public void play(MusicState state)
    {
        stop();
        currentMusicState = state;
        if(currentMusicState != MusicState.NO_MUSIC) {
            GreenfootSound cur = musicMap.get(currentMusicState);
            cur.setVolume(15);
            cur.play();
        }
    }
    public void playLoop(MusicState state)
    {
        stop();
        currentMusicState = state;
        if(currentMusicState != MusicState.NO_MUSIC) {
            GreenfootSound cur = musicMap.get(currentMusicState);
            cur.setVolume(15);
            cur.playLoop();
        }
    }
    public void stop()
    {
        if(currentMusicState != MusicState.NO_MUSIC) {
            musicMap.get(currentMusicState).stop();
        }
        currentMusicState = MusicState.NO_MUSIC;
    }
}
