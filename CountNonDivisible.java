import java.util.*;

class CountNonDivisible {
    public int[] solution(int[] A) {
        // write your code in Java SE 8
        Map<Integer, Integer> map = new HashMap<>();
        for (int a : A) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        Map<Integer, Integer> occur = new HashMap<>();
        for (int num : map.keySet()) {
            int count = 0;
            for (int i = 1; i <= (int)Math.sqrt(num); i++) {
                if (num % i == 0) {
                    int divisor = num / i;
                    if (map.containsKey(i)) {
                        count += map.get(i);
                    }
                    if (divisor != i && map.containsKey(divisor)) {
                        count += map.get(divisor);
                    }
                }
            }
            occur.put(num, A.length - count);
        }
        int[] result = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            result[i] = occur.get(A[i]);
        }
        return result;
    }
}
