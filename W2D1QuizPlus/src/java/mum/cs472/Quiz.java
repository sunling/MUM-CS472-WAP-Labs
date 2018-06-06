package mum.cs472;

import java.util.Arrays;
import java.util.Iterator;

/**
 *
 * @author sunling
 */
public class Quiz {
    private final String[] questions ={
        "3,1,4,1,5",
        "1,1,2,3,5",
        "1,4,9,16,25",
        "2,3,5,7,11",
        "1,2,4,8,16"
    };
    private final Integer[] answers ={9,8,36,13,32} ;
    
    private final String[] hints = {
        "PI",
        "Fibonacci",
        "Squares",
        "Primes",
        "Power of 2"
    };
    
    private Iterator qIterator = null;
    private Iterator aIterator = null;
    private Iterator hIterator = null;
    
    public Quiz(){
        qIterator = Arrays.asList(questions).iterator();
        aIterator = Arrays.asList(answers).iterator();
        hIterator = Arrays.asList(hints).iterator();
    }
    public boolean hasQ(){
        return qIterator.hasNext();
    } 
    public String getNextQ(){
        if (hasQ()) {
            return (String)qIterator.next();
        }
        return null;
    }
    
    public boolean hasA(){
        return aIterator.hasNext();
    }
    public Integer getAnswer(){
        if (aIterator.hasNext()) {
            return (Integer)aIterator.next();
        }
        return null;
    }
    
    public boolean hasHint(){
        return hIterator.hasNext();
    }
    public String getHint(){
        if(hasHint()) return (String) hIterator.next();
        return "";
    } 
    public boolean check(int answer,int guess){ 
        return hasA() && guess==answer;
    }
}
