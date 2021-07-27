package com.zcc.algorithm_practise.prime;

public class prime {
    public static void main(String[] args) {
        int count = 0;
        for (int i = 2; i < 100; i++) {
            count += isPrime(i) ? 1:0 ;
        }
        System.out.println("count :" + count);
    }

    private static boolean isPrime(int x) {
        for (int i = 2; i < x; i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }
}
