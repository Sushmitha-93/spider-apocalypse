import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Label here.
 * 
 * @author (Jing) 
 * @version (v1.0)
 */
public class Label extends Glyph
{
    /**
     * Constructor for objects of class Label
     */

    public Label(MyWorld world) {
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
            img.setFont(new Font(40));
            img.setColor(textColor);
            img.drawString(str, width / 2 - str.length()*9, height / 2 + 10);
            setImage(img);
        }
        
    }
    
}
