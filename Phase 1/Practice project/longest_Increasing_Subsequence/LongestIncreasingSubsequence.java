package longest_Increasing_Subsequence;

import java.util.Arrays;
import java.util.Random;

public class LongestIncreasingSubsequence {
	public int[] lis(int[] X)
    {        
        int n = X.length - 1;
        int[] M = new int[n + 1];  
        int[] P = new int[n + 1]; 
        int L = 0;
 
        for (int i = 1; i < n + 1; i++)
        {
            int j = 0;
            for (int pos = L ; pos >= 1; pos--)
            {
                if (X[M[pos]] < X[i])
                {
                    j = pos;
                    break;
                }
            }            
            P[i] = M[j];
            if (j == L || X[i] < X[M[j + 1]])
            {
                M[j + 1] = i;
                L = Math.max(L,j + 1);
            }
        }

        int[] result = new int[L];
        int pos = M[L];
        for (int i = L - 1; i >= 0; i--)
        {
            result[i] = X[pos];
            pos = P[pos];
        }
        return result;             
    }

    public static void main(String[] args) 
    {    
        int length = 10;
        int[] numbers = new int[length];
        Random rand = new Random();
        int min = 0;
        int max = 100;
        for(int i = 0; i < 10; i++)
        {
            numbers[i] = rand.nextInt(max-min) + min;
        }
        System.out.println("The random array of integer is :"+Arrays.toString(numbers));
        LongestIncreasingSubsequence obj = new LongestIncreasingSubsequence(); 
        int[] result = obj.lis(numbers);       
        System.out.print("\nLongest Increasing Subsequence : ");
        for (int i = 0; i < result.length; i++)
            System.out.print(result[i] +" ");
        System.out.println();
    }
}

