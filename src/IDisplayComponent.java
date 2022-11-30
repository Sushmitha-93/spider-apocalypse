/**
 * Write a description of class IDisplayComponent here.
 * 
 * @author (Jing) 
 * @version (v1.0)
 */
public interface IDisplayComponent  
{
    void addSubComponent( IDisplayComponent c );
    void removeSubCompnent( IDisplayComponent c );
    void setLocation(int x, int y);    
    void display();
    
}
