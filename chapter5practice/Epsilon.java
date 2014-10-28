import java.util.Scanner;

public class Epsilon
{   
    public static void main(String[] args)
    {
        final double EPSILON = 1e-14;
        
        Scanner in  = new Scanner(System.in);
        
        System.out.print("Enter a floating point number: ");
        double num = in.nextDouble();
        
        String magnitude = "";
        
        if(Math.abs(num) <1.0)
        {
            magnitude = "small";
        }
        
        else if(Math.abs(num)>1000000)
        {
            magnitude = "large";
        }
        
        if(Math.abs(num) < EPSILON)
        {
            System.out.println("its zero");       
        
        }
        else if(num>0)
        {
            System.out.println("its a " + magnitude + " positve #");
        }
        else
        {
            System.out.println("its a " + magnitude + " negative #");
        }
    }
    
}