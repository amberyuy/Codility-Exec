class MaxDoubleSliceSum {
    public int solution(int[] A) {

        int[] leftSum = new int[A.length];
        int[] rightSum = new int[A.length];
        for (int i = 1; i < A.length; i++) {
            leftSum[i] = Math.max(0, leftSum[i - 1] + A[i]);
        }
        for (int i = A.length - 2; i >= 0; i--) {
            rightSum[i] = Math.max(0, rightSum[i + 1] + A[i]);
        }
        int result = 0;
        for (int i = 1; i < A.length - 1; i++) {
            result = Math.max(result, leftSum[i - 1] + rightSum[i + 1]);
        }
        return result;
    }
}
