import java.util.Random;
public class DrunkardsWalk
{
    public static void main(String[] args)
    {
        int x = 0;
        int y = 0;
        Random generator = new Random();
        int move;
        for(int i = 0; i<100;i++)
        {
            move = generator.nextInt(4);
            switch(move)
            {
                case 0:
                x++;
                break;
                case 1:
                x--;
                break;
                case 2:
                y++;
                break;
                case 3:
                y--;
                break;
            }
        }
        System.out.println("x = " + x + " y = " + y);
    }
}
