import java.util.Random;
public class MontyHall
{
   public static void main(String[] args)
   {
       Random generator = new Random();
       int carBehind;
       int playerPick;
       int strategy1=0; // switching wins
       int strategy2=0; // not switching wins
       int reveal;
       int switchTo;
       for(int i = 0; i<1000000; i++)
       {
           carBehind = generator.nextInt(3);
           playerPick = generator.nextInt(3);
           do
           {
               reveal = generator.nextInt(3);
           } while(reveal==carBehind || reveal == playerPick);
           switchTo = 3-(playerPick+reveal);
           if(switchTo == carBehind)
           {
               strategy1++;
           }
           if(playerPick == carBehind)
           {
               strategy2++;
           }
       }
       System.out.println("switching wins: " + strategy1);
       System.out.println("staying wins: " + strategy2);
   }
}
