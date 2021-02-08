
/**
 * Write a description of class MinTerm here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MinTerm
{
    public String term;
    public boolean marked;

    /**
     * Constructor for objects of class MinTerm
     */
    public MinTerm()
    {
    }

    @Override
    public String toString() {
    	return marked ? term + "*" : term;
    }
}
