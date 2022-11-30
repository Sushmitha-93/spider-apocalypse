import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Label here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Mode extends Glyph 
{
    private Settings settings;
    private Settings.MODE mode;
    
    /**
     * Constructor for objects of class Mode
     */
    public Mode(MyWorld world) {
        super(world);
    }

    @Override
    public void create(Boolean hasInputImg, String str, int fontSize, Color textColor, int width, int height, Color bgColor) {
        if(hasInputImg) {
            img = new GreenfootImage(str);
            setImage(img);
        }
        else {
            img = new GreenfootImage(width, height);
            img.setFont(new Font( true, true , 20));
            img.setColor(textColor);
            img.drawString(str, width / 2 - str.length()*5, height / 2 + 10);
            setImage(img);
        }
    }
    
    public void setMode(Settings.MODE mode ){
        this.mode = mode;
    }
    
    public void onClick() {
        settings = Settings.getInstance();
        settings.setPlayMode(mode);
        clickSound.setVolume(30);
        clickSound.play();
        img.setTransparency(150);
        setImage(img);
    }
    
    public void unClick() {
        img.setTransparency(255);
        setImage(img);
    }
}
