class MinMaxDivision {
    public int solution(int K, int M, int[] A) {
        // write your code in Java SE 8
        if (K <= 0 || A == null || A.length == 0) {
            return 0;
        }
        // binary search
        int maxSum = 0;
        int minSum = 0;
        int result = 0;
        for (int a : A) {
            maxSum += a;
            minSum = Math.max(minSum, a);
        }
        while (minSum <= maxSum) {
            int midSum = minSum + (maxSum - minSum) / 2;
            if (checkSum(K, midSum, A)) {
                result = midSum;
                maxSum = midSum - 1;
            } else {
                minSum = midSum + 1;
            }
        }
        return result;
    }
    private boolean checkSum(int K, int sum, int[] A) {
        int curSum = 0;
        for (int a : A) {
            curSum += a;
            if (curSum > sum) {
                K--;
                curSum = a;
            }
            if (K == 0) {
                return false;
            }
        }
        return true;
    }
}
