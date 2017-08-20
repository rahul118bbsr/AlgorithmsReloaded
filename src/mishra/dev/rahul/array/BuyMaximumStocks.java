package mishra.dev.rahul.array;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/contests/gs-codesprint/challenges/buy-maximum-stocks
 * <p>
 * Created by aleesha on 18/08/17.
 */
public class BuyMaximumStocks {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int arr_i = 0; arr_i < n; arr_i++) {
            arr[arr_i] = in.nextInt();
        }
        long k = in.nextLong();
        long result = buyMaximumProducts(n, k, arr);
        System.out.println(result);
        in.close();
    }

    private static long buyMaximumProducts(int n, long k, int[] a) {
        long numOfStocks = 0;
        for(int i = 0; i < a.length; i++) {
            int count =  i + 1;
            while(count > 0) {
                count--;
                k = k - a[i];
                if(k > 0) {
                    numOfStocks++;
                } else {
                    return numOfStocks;
                }
            }
        }
        return numOfStocks;
    }
}
