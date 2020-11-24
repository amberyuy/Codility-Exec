import java.util.*;


class Peaks {
    public int solution(int[] A) {
        // write your code in Java SE 8
        List<Integer> peaks = new ArrayList<>();
        for (int i = 1; i < A.length - 1;i++) {
            if (A[i - 1] < A[i] && A[i + 1] < A[i]) {
                peaks.add(i);
            }
        }

        for (int i = A.length; i >= 1; i--) {
            if (A.length % i != 0) {
                continue;
            }
            int blockSize = A.length / i;
            int count = 0;
            for (int peak : peaks) {
                if (peak / blockSize == count) {
                    count++;
                }
            }
            if (count == i) {
                return count;
            }
        }
        return 0;
    }
}
