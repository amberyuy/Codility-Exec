class DifferentCharacters {
    private Range[] ranges;
    public int solution(String S, int K) {
        if (K == 0) {
            return S.length();
        }
        int min = Integer.MAX_VALUE;
        int count = 0;
        ranges = new Range[26];
        for (int i = 0; i < S.length(); i++) {
            int index = S.charAt(i) - 'a';
            if (ranges[index] == null) {
                ranges[index] = new Range(i, i);
                count++;
            } else {
                ranges[index].end = i;
            }
        }
        if (count < K) {
            return -1;
        } else if (count == K) {
            return 0;
        }
        int remove = count - K;
        for (int i = 0; i < 26; i++) {
            if (ranges[i] == null) {
                continue;
            }
            int startI = ranges[i].start;
            for (int j = 0; j < 26; j++) {
                if (ranges[j] == null) {
                    continue;
                }
                int endJ = ranges[j].end;
                int countRange = 0;
                for (int k = 0; k < 26; k++) {
                    if (ranges[k] == null) {
                        continue;
                    }
                    if (startI <= ranges[k].start && ranges[k].end <= endJ) {
                        countRange++;
                    }
                }
                if (countRange == remove) {
                    min = Math.min(min, endJ - startI + 1);
                }
            }
        }
        return min;
    }
    public class Range {
        public int start;
        public int end;
        public Range(int start, int end) {
            this.start = start;
            this.end = end;
        }

    }
}
