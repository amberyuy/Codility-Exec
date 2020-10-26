class FrogJmp {
    public int solution(int X, int Y, int D) {

        if (Y <= X) {
            return 0;
        }
        int result = (Y - X) / D;
        if ((Y - X) % D == 0) {
            return result;
        } else {
            return result + 1;
        }
    }
}
