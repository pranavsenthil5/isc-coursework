import java.util.*;
class PrimeProduct
{
    public static void main(String[] args)
    {
        Scanner s =new Scanner(System.in);
        System.out.println("Input:");
        int input=s.nextInt();
        outer:
        for(int i=4;i<input;i++)
        {
            for(int j=2;j<i;j++)
            {
                if(isPrime(j))
                {
                    
                    if(i%j==0)
                    {
                        if(isPrime(i/j))
                        {
                            //
                            System.out.println(i);
                            continue outer;
                        }
                    }
                }
            }
        }
    }
    public static boolean isPrime(int x)
    {
        for(int i=2;i<x;i++)
        {
            if(x%i==0)
            {
                return false;
            }
        }
        return true;
    }
}