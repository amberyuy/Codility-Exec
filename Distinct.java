class Distinct {
    public int solution(int[] A) {
        // write your code in Java SE 8
        if (A == null || A.length == 0) {
            return 0;
        }
        Set<Integer> distinct = new HashSet<>();
        for (int a : A) {
            distinct.add(a);
        }
        return distinct.size();
    }
}
