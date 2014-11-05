
public class ArmstrongTest
{
    public static void main(String[] args)
    {
        int number = 0;
        for(int i = 0; i<10; i++)
        {
            for(int j = 0; j<10;j++)
            {
                for(int k = 0; k<10; k++)
                {
                    if (Math.pow(i,3)+Math.pow(j,3)+Math.pow(k,3)==number)
                    {
                        System.out.println(number+" is an armstrong number");
                    }
                    number++;
                }
            }
        }
    }
}
