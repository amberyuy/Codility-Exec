
import java.util.*;


class LongestPassword {
    public int solution(String S) {
        // write your code in Java SE 8
        String[] words = S.split(" ");
        List<String> wordsList = new ArrayList<>();
        for (String word : words) {
            if (word.matches("^[a-zA-Z0-9]*$")) {
                wordsList.add(word);
            }
        }
        int result = Integer.MIN_VALUE;
        for (String word : wordsList) {
            if (check(word)) {
                result = Math.max(result, word.length());
            }
        }
        if (result == Integer.MIN_VALUE) {
            return -1;
        } else {
            return result;
        }

    }
    private boolean check(String word) {
        int letter = 0;
        int num = 0;
        for (char ch : word.toCharArray()) {
            if (ch >= 'a' && ch <= 'z') {
                letter++;
            } else if (ch >= 'A' && ch <= 'Z') {
                letter++;
            } else if (ch >= '0' && ch <='9') {
                num++;
            }
        }
        if (letter % 2 == 0 && num % 2 == 1) {
            return true;
        } else {
            return false;
        }
    }
}
