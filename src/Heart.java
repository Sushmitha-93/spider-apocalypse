import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Heart1 here.
 * 
 * @author (Joseph, Dee) 
 * @version (v1.1)
 */
public class Heart extends Actor
{
    private int lifeamount = 1;
    /**
     * Act - do whatever the Heart1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        updateImage();
    }
    
    private void updateImage()
    {
        if(lifeamount != 0){
            GreenfootImage image = new GreenfootImage("heart.png");
            setImage(image);
        }
        else{
            GreenfootImage image = new GreenfootImage("emptyheart.png");
            setImage(image);
        }
    }
    
    public void setLifeAmount(int life)
    {
        lifeamount=life;
    }
}
