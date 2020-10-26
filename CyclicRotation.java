class CyclicRotation {
    public int[] solution(int[] A, int K) {

        if (A == null || A.length == 0 || K == 0) {
            return A;
        }
        int[] result = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            int idx = (i + K) % A.length;
            result[idx] = A[i];
        }
        return result;
    }
}
