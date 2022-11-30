import greenfoot.*;
/**
 * Write a description of class OperationHitRock here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class OperationHitSinRock implements IScoreStrategy{
    @Override
    
    public int doOperation(int num) {
       return num + 20;
    }
}