import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class Rocket here.
 * 
 * @author (Dee, Joseph) 
 * @version (v1.3)
 */
public class Rocket extends Actor implements IStopSubject
{
    private int speed;
    private int coolDown;
    private int coolDownRange;
    private int speedEffect;
    private int cdEffect;
    public int life;
    protected static boolean isStopped;
    protected static int crashedCount;
    private ArrayList<IStopObserver> observers;
    private List<Heart> hp;
    private boolean notified;
    
    /**
     * Reference: https://www.greenfoot.org/topics/5092
     */ 
    public Rocket() {
        observers = new ArrayList<>();
        GreenfootImage image = getImage();  
        image.scale(110,140);
        setImage(image);
        speed = 5;
        coolDown = 0;
        coolDownRange = 25;
        speedEffect = 0;
        cdEffect = 0;
        life = 2;
        isStopped = false;
        crashedCount = 1;
        notified = false;
    }
    
    /**
     * Act - do whatever the rocket wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if (crashedCount == 0 && !notified) {
            notifyGameOverObserver() ;
            notified = true;
        }
        
        updateHP();
        
        move();
    }
    
    protected void updateHP() {
        if (isStopped) {
            rescured();
        } else if (isTouching(Rock.class)) {
            if (life == 0){
                //notifyGameOverObserver( ) ;
                isStopped = true; 
                crashedCount--;
                GreenfootImage image = new GreenfootImage("CrashedRocket.png");  
                image.scale(110, 140);
                setImage(image);
            }
            removeRock();
            Heart heart = hp.get(life);
            heart.setLifeAmount(0);
            life--;
            life = Math.max(0, life);
        }
    }
    
    protected void move() {
        if (!isStopped) {
            getBuff();
            keySet();
       }
    }
    
    protected void keySet() {
        if ( Greenfoot.isKeyDown("up") )
        {
            setLocation( getX(), getY() - speed );
        }

        if ( Greenfoot.isKeyDown("down") )
        {
            setLocation( getX(), getY() + speed );
        }

        if ( Greenfoot.isKeyDown("left") )
        {
            setLocation( getX() - speed , getY() );
        }

        if ( Greenfoot.isKeyDown("right") )
        {
            setLocation( getX() + speed , getY() );
        }
        
        if (coolDown > 0) {
            coolDown--;
        } else if (Greenfoot.isKeyDown("enter")) {
            getWorld().addObject(new Shot(this), getX(), getY());
            coolDown = coolDownRange;
        }
    }
    
    public void registerStopObserver(IStopObserver o) {
        observers.add(o);
    }
    
    public void notifyGameOverObserver() {
        for (int i = 0; i < observers.size(); i++)
        {
            IStopObserver observer = observers.get(i) ;
            observer.stop();
        }
    }
    
    protected void getBuff() {
        speedEffect--;
        cdEffect--;
        speedEffect = Math.max(0, speedEffect);
        cdEffect = Math.max(0, cdEffect);
        
        // when exceed the effect time, set speed to initial value
        if (speedEffect == 0) {
            this.speed = 5;
        }
        
        // when exceed the effect time, set cool down time to initial value
        if (cdEffect == 0) {
            this.coolDownRange = 25;
        }
        
        // check speed up buff
        if (isTouching(SpeedUp.class)) {
            // maximum speed is 10
            this.speed = Math.min(2 + speed, 10);
            this.speedEffect = 300;
            removeTouching(SpeedUp.class);
        }
        
        // check faster shot buff
        if (isTouching(FasterShot.class)) {
            // minimum cool down range is 10
            this.coolDownRange = Math.max(coolDownRange - 10, 10);
            this.cdEffect = 300;
            removeTouching(FasterShot.class);
        }
    }
    
    protected void removeRock() {
        Rock theRock = (Rock)(getOneIntersectingObject( Rock.class ));
        SinRock theSinRock = (SinRock)(getOneIntersectingObject( SinRock.class ));
        if (theSinRock != null) {
            theSinRock.destroyed();
        }
        else if (theRock != null) {
            theRock.destroyed();
        }
    }
    
    public static void setPlayerNum(int num) {
        crashedCount = num;
    }
    
    private void rescured() {
         if (isTouching(Rocket2P.class)) {
             crashedCount++;
             isStopped = false;
             life = 2;
             for (Heart heart : hp) {
                 heart.setLifeAmount(1);
             }
             GreenfootImage image = new GreenfootImage("rocket.png");  
             image.scale(110, 140);
             setImage(image);
        }
    }
    
    public void setHP(List<Heart> list) {
        hp = list;
    }
}
