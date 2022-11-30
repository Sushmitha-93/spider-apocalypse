/**
 * Write a description of class Level2 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Level2 implements ILevelState 
{
    // instance variables - replace the example below with your own
    private ILevelStateMachine sm;
    private static int count;

    /**
     * Constructor for objects of class Level2
     */
    public Level2(ILevelStateMachine machine)
    {
        sm = machine; 
        count = 1;
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void nextLevel() {
        // level 2 can have up to 3 moving rock
        if (count < 3) {
            sm.setLevel2();
        } else {
            sm.setLevel3();
            // reset count to 0 for retry
            count = 0;
        }
        count++;
    }
}
