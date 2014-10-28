import java.util.Scanner;



public class FindFirstMatch
{
   public static void main(String[] args)
   {
       Scanner in = new Scanner(System.in);
       System.out.println("Enter a string");
       String str = in.nextLine();
       int index = -1;
       char ch = 'a';
       while(ch!=' ' && index<str.length())
       {
           index++;
           ch = str.charAt(index);
       }
       if (ch == ' ')
       {
           System.out.println("index at: " +index);
       }
       
       else
       {
           System.out.println("not found");
       }
   }

}
