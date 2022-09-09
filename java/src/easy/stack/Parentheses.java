package easy.stack;

import java.util.*;

/**
 给定一个只包括 '('，')'，'{'，'}'，'['，']'的字符串 s ，判断字符串是否有效。
 <p>
 有效字符串需满足：
 左括号必须用相同类型的右括号闭合。
 左括号必须以正确的顺序闭合。
 每个右括号都有一个对应的相同类型的左括号。
 来源：力扣（LeetCode）
 链接：https://leetcode.cn/problems/valid-parentheses
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 */
public class Parentheses {
    private static Map<Character, Character> characterMap;

    static {
        characterMap = new HashMap<>();
        characterMap.put(')', '(');
        characterMap.put('}', '{');
        characterMap.put(']', '[');
    }

    private static List<Character> leftParentheses = Arrays.asList('(', '{', '[');


    public boolean isValid(String s) {
        int length = s.length();
        if (length % 2 != 0) {
            return false;
        }
        char[] chars = s.toCharArray();
        List<Character> stack = new ArrayList<>();
        for (char c : chars) {
            if (leftParentheses.contains(c)) {
                stack.add(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    int leftLast = stack.size() - 1;
                    if (!characterMap.get(c).equals(stack.get(leftLast))) {
                        return false;
                    }
                    stack.remove(leftLast);
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {

        System.out.println(new Parentheses().isValid("([}}])"));
    }
}
