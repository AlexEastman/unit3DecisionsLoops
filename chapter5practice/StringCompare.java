


public class StringCompare
{
   
    public static void main(String[] args)
    {
        String word1 = "catalog";
        String word2 = "cat";
        
        if (word1.compareTo("aaa")>0)
        {
            System.out.println("word1 is greater than \"aaa\"");
        
        }
        else
        {
            System.out.println("word1 is not greater than \"aaa\"");
        }
        
        if (word1.equals(word2))
        {
            System.out.println("they equal man");
        }
        else
        {
            System.out.println("they aint tho");
        }
        
        if (word1.compareTo(word2) < 0)
        {
            System.out.println("it small man");
        }
        else
        {
            System.out.println("it big dow");
        }
        
        if (word1.substring(0,3).equals(word2.substring(0,3)))
        {
            System.out.println("same pre");
        }
        else
        {
            System.out.println("naw man");
            }
    }

}
