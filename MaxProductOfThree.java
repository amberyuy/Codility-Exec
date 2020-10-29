class MaxProductOfThree {
    public int solution(int[] A) {
        // write your code in Java SE 8
        if (A == null || A.length < 3) {
            return 0;
        }
        Arrays.sort(A);
        int n = A.length;
        int mul1 = A[n - 1] * A[n - 2] * A[n - 3];
        int mul2 = A[0] * A[1] * A[n - 1];
        return Math.max(mul1, mul2);
    }
}
