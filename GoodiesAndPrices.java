import java.util.Arrays;
import java.util.Scanner;

public class GoodiesAndPrices {

    static int findDiff(int array[], int N, int M)
    {
        int result = Integer.MAX_VALUE;
        Arrays.sort(array);
        for (int i=0; i<= N-M;i++)
            result = Math.min(result, array[i + M - 1] - array[i]);
        return result;
    }

    static int findProducts(int res,int array[], int N, int M)
    {
        int result = Integer.MAX_VALUE;
        for(int i=0; i<=N; i++)
        {
            result = Math.min(result, array[i + M - 1] - array[i]);
            if (res==result)
                return i;
        }
        return 0;
    }

    public static void main(String[] args) {

        int arrayPrice[]={7980,22349,999,2799,229900,11101,9999,2195,9800,4999};

        String items[]={ "MI Band: 999","Sandwich Toaster: 2195" ,"Cult Pass: 2799","Scale: 4999","Fitbit Plus: 7980",
						 "Microwave Oven: 9800"  ,"Alexa: 9999","Digital Camera: 11101", "IPods: 22349","Macbook Pro: 229900" };

        int n = arrayPrice.length;

        System.out.println("Enter the number of employees");
        Scanner scn = new Scanner(System.in);
        int m = scn.nextInt();

        int result = findDiff(arrayPrice, n, m);

        System.out.println("Number of the employees:"+m);
        int startIndex = findProducts(result,arrayPrice,n,m);

        System.out.println("\nHere the goodies that are selected for distribution are:\n");
        for(int i=startIndex; i<startIndex + m; i++)
            System.out.println(items[i]);

        System.out.println("\nAnd the difference between the chosen goodies with highest price and the lowest price is:"+result);
    }
}
