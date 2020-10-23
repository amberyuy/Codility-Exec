// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class PermMissingElem {
    public int solution(int[] A) {
        // write your code in Java SE 8
        if (A == null || A.length == 0) {
            return 1;
        }
        int xor = 1;
        int num = 2;
        while(num <= A.length + 1) {
            xor = xor ^ num;
            num++;
        }
        for (int number : A) {
            xor ^= number;
        }
        return xor;
    }
}
