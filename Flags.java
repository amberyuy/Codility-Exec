// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        if (A == null || A.length == 0) {
            return 0;
        }
        List<Integer> peaks = new ArrayList<>();
        for (int i = 1; i < A.length - 1; i++) {
            if (A[i] > A[i - 1] && A[i] > A[i + 1]) {
                peaks.add(i);
            }
        }
        int left = 1;
        int right = peaks.size();
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (checkFlags(peaks, mid)) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (checkFlags(peaks, right)) {
            return right;
        }
        if (checkFlags(peaks, left)) {
            return left;
        }
        return 0;
    }
    private boolean checkFlags(List<Integer> peaks, int num) {
        if (peaks.size() == 0) {
            return false;
        }
        int lastIdx = peaks.get(0);
        int usedFlags = 1;
        for (int p = 1; p < peaks.size(); p++) {
            int pIdx = peaks.get(p);
            if (pIdx - lastIdx >= num) {
                usedFlags++;
                lastIdx = pIdx;
            }
            if (usedFlags == num) {
                return true;
            }
        }
        return usedFlags == num;
    }
}
