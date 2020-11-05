class CommonPrimeDivisors {
    public int solution(int[] A, int[] B) {
        // write your code in Java SE 8
        if (A == null || A.length == 0 || A.length != B.length) {
            return 0;
        }
        int result = 0;
        for (int i = 0; i < A.length; i++) {
            if (checkGdc(A[i], B[i])) {
                result++;
            }
        }
        return result;
    }
    private boolean checkGdc(int a, int b) {
        int gdc = computeGdc(a, b);
        while (a != 1) {
            int gdcA = computeGdc(a, gdc);
            if (gdcA == 1) {
                break;
            }
            a /= gdcA;
        }
        if (a != 1) {
            return false;
        }
        while (b != 1) {
            int gdcB = computeGdc(b, gdc);
            if (gdcB == 1) {
                break;
            }
            b /= gdcB;
        }
        if (b != 1) {
            return false;
        }
        return true;

    }
    private int computeGdc(int a, int b) {
        if (a % b == 0) {
            return b;
        }
        return computeGdc(b, a % b);
    }
}
