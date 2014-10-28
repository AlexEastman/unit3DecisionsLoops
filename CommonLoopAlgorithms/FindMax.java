import java.util.Scanner;


public class FindMax
{
   public static void main(String[] args)
   {
       Scanner in = new Scanner(System.in);
       System.out.println("enter a series of numbers (type 'q' to quit)");
       double max = in.nextDouble();
       while(in.hasNextDouble())
       {
           double value = in.nextDouble();
           max = Math.max(value,max);
       }
       
       System.out.println("Max value = " + max);
   }

}
