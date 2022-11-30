
/**
 * Write a description of class IScoreSubject here.
 * 
 * @author (Dee) 
 * @version (v1.0)
 */
public interface IScoreSubject
{
    void registerScoreObserver(IScoreObserver o);
    void notifyScoreObserver();
}
