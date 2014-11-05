import java.util.Random;
public class MontyHall2
{
    public static void main(String[] args)
    {
        Random generator = new Random();
        int strategy1 = 0;
        int strategy2 = 0;
        for(int i = 0; i<1000; i++)
        {
            int rand = generator.nextInt(3);
            if (rand == 0)
            {
                strategy2++;
            }
            else
            {
                strategy1++;
            }
        }
        System.out.println("strategy1: " + strategy1);
       System.out.println("strategy2: " + strategy2);
    }

}
