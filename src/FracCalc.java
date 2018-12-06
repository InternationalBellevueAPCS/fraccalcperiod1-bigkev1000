import java.util.*;
public class FracCalc {

    /**
     * Prompts user for input, passes that input to produceAnswer, then outputs the result.
     * @param args - unused
     */
	
    public static void main(String[] args) 
    {
    	Scanner console = new Scanner(System.in);
    	System.out.println("Insert your equation: ");
    	String equation = console.nextLine();
    	String output = null;
    	while (!(equation.equals("quit")))
    	{
    		output = produceAnswer(equation);
    		System.out.println(output);
    		System.out.println("Insert your equation: ");
    		equation = console.nextLine();
    	}
    	
    	
    	        // TODO: Read the input from the user and call produceAnswer with an equation
        // Checkpoint 1: Create a Scanner, read one line of input, pass that input to produceAnswer, print the result.
        // Checkpoint 2: Accept user input multiple times.
    }
    
    /**
     * produceAnswer - This function takes a String 'input' and produces the result.
     * @param input - A fraction string that needs to be evaluated.  For your program, this will be the user input.
     *      Example: input ==> "1/2 + 3/4"
     * @return the result of the fraction after it has been calculated.
     *      Example: return ==> "1_1/4"
     */
    public static String produceAnswer(String in)
    { 
        // TODO: Implement this function to produce the solution to the input
        // Checkpoint 1: Return the second operand.  Example "4/5 * 1_2/4" returns "1_2/4".
    	int space = in.indexOf(" ");
    	
    	
    	String second = in.substring(space+3, in.length());
    	int underscore = second.indexOf("_");
    	int slash = second.indexOf("/");
    	
    	
    	if (underscore>0 && slash>0)
    	{	
    		String whole = second.substring(0,underscore);
	    	String numerator = second.substring(underscore+1,slash);
	    	String denominator = second.substring(slash+1, second.length());
	    	return "Whole: "+ whole+ " Numerator: " + numerator + " Denominator: " + denominator; 
    	}
    	if (underscore<0 && slash<0)
    	{
    		String whole = second.substring(0,second.length());
    		return "Whole: " + whole;
    	}
    	if (underscore<0 && slash>0)
    	{
    		String numerator = second.substring(0,slash);
    		String denominator = second.substring(slash+1,second.length());
    		return "Numerator: " + numerator + " Denominator: " + denominator; 
    	}
    	//String output = "Whole : "+whole+" Numerator: "+numerator+" Denominator: "+denominator;
        // Checkpoint 2: Return the second operand as a string representing each part.
        //               Example "4/5 * 1_2/4" returns "whole:1 numerator:2 denominator:4".
        // Checkpoint 3: Evaluate the formula and return the result as a fraction.
        //               Example "4/5 * 1_2/4" returns "6/5".
        //               Note: Answer does not need to be reduced, but it must be correct.
        // Final project: All answers must be reduced.
        //               Example "4/5 * 1_2/4" returns "1_1/5".
        
       return in; 
    }

    // TODO: Fill in the space below with helper methods
    
    /**
     * greatestCommonDivisor - Find the largest integer that evenly divides two integers.
     *      Use this helper method in the Final Checkpoint to reduce fractions.
     *      Note: There is a different (recursive) implementation in BJP Chapter 12.
     * @param a - First integer.
     * @param b - Second integer.
     * @return The GCD.
     */
    public static int greatestCommonDivisor(int a, int b)
    {
        a = Math.abs(a);
        b = Math.abs(b);
        int max = Math.max(a, b);
        int min = Math.min(a, b);
        while (min != 0) {
            int tmp = min;
            min = max % min;
            max = tmp;
        }
        return max;
    }
    
    /**
     * leastCommonMultiple - Find the smallest integer that can be evenly divided by two integers.
     *      Use this helper method in Checkpoint 3 to evaluate expressions.
     * @param a - First integer.
     * @param b - Second integer.
     * @return The LCM.
     */
    public static int leastCommonMultiple(int a, int b)
    {
        int gcd = greatestCommonDivisor(a, b);
        return (a*b)/gcd;
    }
}
