import java.util.*;

class Brakets {
    public int solution(String S) {
        // write your code in Java SE 8
        if (S == null || S.length() == 0) {
            return 1;
        }
        if (S.length() % 2 == 1) {
            return 0;
        }
        Map<Character, Character> brakets = new HashMap<>();
        brakets.put('(', ')');
        brakets.put('[', ']');
        brakets.put('{', '}');
        Deque<Character> stack = new ArrayDeque<>();
        for (char ch : S.toCharArray()) {
            if (brakets.containsKey(ch)) {
                stack.offerFirst(brakets.get(ch));
            } else {
                if (stack.isEmpty()) {
                    return 0;
                } else {
                    char top = stack.pollFirst();
                    if (top != ch) {
                        return 0;
                    }
                }

            }
        }
        return stack.isEmpty() ? 1 : 0;
    }
}
