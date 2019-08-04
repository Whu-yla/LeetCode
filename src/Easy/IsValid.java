package Easy;

import java.util.Stack;

public class IsValid {
    /**
     * create by: Hugo
     * description:建立一个栈stack来装char[]，然和进行
     * create time: 17:20 2019/8/4
     * @Param: s
     * @return boolean
     */
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if (stack.size() == 0) {
                stack.push(aChar);
            } else if (isSym(stack.peek(), aChar)) {// 唯一值得注意的就是stack.peek方法，要取出栈顶元素但不需要pop出就需要peek方法
                stack.pop();
            } else {
                stack.push(aChar);
            }
        }
        return stack.size() == 0;
    }
    private static boolean isSym(char c1, char c2) {
        return (c1 == '(' && c2 == ')') || (c1 == '[' && c2 == ']') || (c1 == '{' && c2 == '}');
    }
}
