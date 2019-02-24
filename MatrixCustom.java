import java.util.*;
class MatrixCustom 
{
    /**
     * Create a 2d array;
     * input all the values to a 1d array;
     * sort the 1d array;
     * 
     * start asigning values from going left to right(along the 1st row).Then down(along the last column), Then right to left
     * then up. When coming back to the same place go one step less. Kepp decreasing the number of steps.
     */
    public static void main(String []args)
    {
        Scanner s = new Scanner (System.in);
        System.out.print("Input:");
        String input=s.next();
        String[] inp=input.split("x");
        int a=Integer.parseInt(inp[0]);
        int b=Integer.parseInt(inp[1]);
        int c=0;

        int[][] matrix=new int[a][b];
        int[] array=new int[a*b];
        //int d=1;
        System.out.print("\nInput type(1-Custom 2-Random):");
        int choice =s.nextInt();
        
        for(int i=0;i<a;i++)
            for(int j=0;j<b;j++)
            {
                if(choice==1){
                System.out.println("Enter the value for element ["+i+"]["+j+"]");
                matrix[i][j]=s.nextInt();
                array[c++]=matrix[i][j];
            }
            else if(choice==2)
            {
                matrix[i][j]=randInt(100);
                array[c++]=matrix[i][j];
            }
            else
            {
                System.out.println("Invalid Input");
                System.exit(0);
            }
            }
        
        // for(int i=0;i<a;i++)
        // for(int j=0;j<b;j++)
        // {
        // System.out.println("Enter the value for element ["+i+"]["+j+"]");
        // matrix[i][j]=d++;
        // array[c++]=matrix[i][j];
        // } 

        System.out.println("________________________");
        display(matrix);
        System.out.println("________________________");
        display(array);
        System.out.println("________________________");
        int[][] output=spiral(array,a,b);
        display(output);
    }

    static int randInt(int x)
    {
        return (int)(Math.random()*x);
    }
    static void display(int matrix[][])
    {
        int x=5;
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[0].length;j++)
            {
                try
                {
                    System.out.printf("%5d",matrix[i][j]);
                }
                catch(Exception E)
                {
                    //System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

    static void display(int x[])
    {

        for(int j=0;j<x.length;j++)
        {
            System.out.print(x[j]+" ");
        }
    }

    static int[] sort(int x[])
    {
        int temp;
        for(int i=0;i<x.length-1;i++)
            for(int j=0;j<x.length-i-1;j++)
            {
                if(x[j]>x[j+1])
                {
                    temp=x[j+1];
                    x[j+1]=x[j];
                    x[j]=temp;
                }
            }

        return x;
    }

    static int[][] spiral(int a[],int x,int y)
    {
        int[][] matrix=new int[x][y];
        a=sort(a);
        System.out.println("++++++++++");
        display(a);
        int temp=0;
        int m=0;
        for(int i=0;i<(x+1)/2;i++)
        {
            System.out.println("x-x-x-x-x");
            for(int j=temp;j<y-temp;j++)
            {
                if(m==a.length)
                    break;
                matrix[i][j]=a[m++];
                display(matrix);
                System.out.println("------");
            }
            temp++;
            System.out.println("x-x-x-x-x");
            for(int j=temp;j<=x-temp;j++)
            {
                if(m==a.length)
                    break;
                matrix[j][y-1-i]=a[m++];
                display(matrix);
                System.out.println("------");
            }
            System.out.println("x-x-x-x-x");
            for(int j=y-1-temp;j>=i;j--)
            {
                if(m==a.length)
                    break;
                matrix[x-1-i][j]=a[m++];
                display(matrix);
                System.out.println("------");
            }
            temp++;
            System.out.println("x-x-x-x-x");
            for(int j=x-i-2;j>i;j--)
            {
                if(m==a.length)
                    break;
                matrix[j][i]=a[m++];
                display(matrix);
                System.out.println("------");
            }
            temp--;
        }   
        return matrix;
    }
}
