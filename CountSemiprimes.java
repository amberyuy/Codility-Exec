import java.util.*;

class CountSemiprimes {
    public int[] solution(int N, int[] P, int[] Q) {
        // write your code in Java SE 8
        boolean[] primes = new boolean[N + 1];
        Arrays.fill(primes, true);
        primes[0] = false;
        primes[1] = false;
        for (int i = 2; i < (int)Math.sqrt(N); i++) {
            if (primes[i]) {
                for (int j = i * 2; j <= N; j += i) {
                    primes[j] = false;
                }
            }
        }
        List<Integer> primesList = new ArrayList<>();
        for (int i = 2; i <= N; i++) {
            if (primes[i]) {
                primesList.add(i);
            }
        }
        // System.out.println(primesList);
        boolean[] semiprimes = new boolean[N + 1];
        long temp;
        for (int i = 0; i < primesList.size(); i++) {
            for (int j = 0; j < primesList.size(); j++) {
                temp = (long)primesList.get(i) * (long)primesList.get(j);
                if (temp <= N) {
                    semiprimes[(int)temp] = true;
                }
            }
        }
        // for (int i = 0; i < semiprimes.length; i++) {
        //     if (semiprimes[i]) {
        //         System.out.println(i);
        //     }
        // }
        int[] count = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            count[i] = count[i - 1];
            if (semiprimes[i]) {
                count[i]++;
            }
        }
        int[] result = new int[P.length];
        for (int i = 0; i < P.length; i++) {
            result[i] = count[Q[i]] - count[P[i] - 1];
        }
        return result;
    }
}
