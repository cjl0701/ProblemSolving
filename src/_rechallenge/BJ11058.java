package _rechallenge;
//크리보드

import java.util.Scanner;

//최대 2^33 이므로  long 타입
public class BJ11058 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] d = new long[n + 1]; //d[i] = max(d[i-1]+1, d[i-k]*(k-1))
        for (int i = 1; i <= n; i++) {
            d[i] = d[i - 1] + 1;
            for (int j = 1; j <= i - 3; j++)
                d[i] = Math.max(d[i], d[j] * (i - j - 1));
        }
        System.out.println(d[n]);
    }
}
