import java.util.Scanner;
public class FindDuplicate
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a series of numbers or press 'q'to quit");
        double oldDouble = in.nextDouble();
        while(in.hasNextDouble())
        {
            double newDouble = in.nextDouble();
            if (newDouble == oldDouble)
            {
                System.out.println("duplicate found");
            }
            oldDouble = newDouble;
        }
    }

}
