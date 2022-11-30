
/**
 * Write a description of class IStopSubject here.
 * 
 * @author (Dee) 
 * @version (v1.0)
 */
public interface IStopSubject
{
    void registerStopObserver(IStopObserver o);
    void notifyGameOverObserver();
}
