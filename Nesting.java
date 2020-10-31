import java.util.*;
class Nesting {
    public int solution(String S) {
        // write your code in Java SE 8
        if (S == null || S.length() == 0) {
            return 1;
        }
        if (S.length() % 2 == 1) {
            return 0;
        }
        Deque<Character> stack = new ArrayDeque<>();
        for (char ch : S.toCharArray()) {
            if (ch == '(') {
                stack.offerFirst(')');
            } else if (ch == ')') {
                if (stack.isEmpty()) {
                    return 0;
                } else {
                    char top = stack.pollFirst();
                    if (top != ch) {
                        return 0;
                    }
                }
            } else {
                return 0;
            }
        }
        return stack.isEmpty() ? 1 : 0;
    }
}
