/**
 * Write a description of class ScoreContext here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ScoreContext {
   private IScoreStrategy strategy;

   public ScoreContext(IScoreStrategy strategy){
      this.strategy = strategy;
   }

   public int executeStrategy(int num){
      return strategy.doOperation(num);
   }
}