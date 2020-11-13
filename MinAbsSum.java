class MinAbsSum {
    public int solution(int[] A) {
        // write your code in Java SE 8
        int len = 0;
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            A[i] = Math.abs(A[i]);
            sum += A[i];
            len = Math.max(len, A[i]);
        }
        int[] occurs = new int[len + 1];
        for (int a : A) {
            occurs[a]++;
        }
        boolean[] dp = new boolean[sum / 2 + 1];
        dp[0] = true;
        for (int i = 1; i < occurs.length; i++) {
            if (occurs[i] != 0) {
                int[] remains = new int[dp.length];
                for (int j = 0; j < remains.length; j++) {
                    remains[j] = dp[j] ? occurs[i] : -1;
                }
                for (int j = 0; j + i < remains.length; j++) {
                    if (remains[j] > 0) {
                        remains[j + i] = Math.max(remains[j + i], remains[j] - 1);
                    }
                }
                // System.out.println(dp.length);
                // System.out.println(remains.length);
                for (int j = 0; j < remains.length; j++) {
                    if (remains[j] >= 0) {
                        // System.out.println(j);
                        dp[j] = true;
                    }
                }
            }
        }
        for (int i = dp.length - 1; i >= 0; i--) {
            if (dp[i]) {
                return sum - 2 * i;
            }
        }
        return 0;
    }
}
