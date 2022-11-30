import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Button here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Button extends Glyph 
{
    private MyWorld.SCREENS nextScreen;

    public Button(MyWorld world) {
        super(world);
    }
    
    @Override
    public void create(Boolean hasInputImg, String str, int fontSize, Color textColor, int width, int height, Color backgroundColor) {
        
        if(hasInputImg){
            img = new GreenfootImage(str);
            setImage(img);
        }
        else {
            img = new GreenfootImage(width, height);
            img.setColor(backgroundColor);
            img.fill();
            
            img.setFont(new Font(fontSize));
            img.setColor(textColor);
            img.drawString(str, width / 2 - str.length() * 8, height / 2 + 10);
            setImage(img);
        }
        
        
    }
    
    public void setNextScreen(MyWorld.SCREENS nextScreen){
        this.nextScreen = nextScreen;
    }
    
    /**
     * This method is called when button is clicked.
     * To transite to nextScreen.
     */   
    public void onClick() {
        clickSound.setVolume(30);
        clickSound.play();
        world.setNextScreen(nextScreen);

    }
    
    
}
