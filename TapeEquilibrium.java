class TapeEquilibrium {
    public int solution(int[] A) {
        // write your code in Java SE 8
        if (A == null || A.length <= 1) {
            return 0;
        }
        int sum = 0;
        int result = Integer.MAX_VALUE;
        for (int a : A) {
            sum += a;
        }
        int leftSum = 0;
        for (int p = 1; p < A.length; p++) {
            leftSum += A[p - 1];
            int rightSum = sum - leftSum;
            int diff = Math.abs(leftSum - rightSum);
            result = Math.min(result, diff);

        }
        return result;
    }
}
