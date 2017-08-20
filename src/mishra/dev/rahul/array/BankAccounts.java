package mishra.dev.rahul.array;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/contests/gs-codesprint/challenges/bank-accounts
 * <p>
 * Created by aleesha on 18/08/17.
 */
public class BankAccounts {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for (int a0 = 0; a0 < q; a0++) {
            int n = in.nextInt();
            int k = in.nextInt();
            int x = in.nextInt();
            int d = in.nextInt();
            int[] p = new int[n];
            for (int p_i = 0; p_i < n; p_i++) {
                p[p_i] = in.nextInt();
            }
            String result = feeOrUpfront(n, k, x, d, p);
            System.out.println(result);
        }
        in.close();
    }

    private static String feeOrUpfront(int n, int k, int x, int d, int[] p) {
        double fees = Arrays.stream(p)
                .mapToDouble(payment -> Math.max(k, x / 100.0 * payment))
                .sum();
        return d >= fees ? "fee" : "upfront";
    }
}
