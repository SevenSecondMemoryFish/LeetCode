package Stack;

import java.util.Stack;

public class _71_简化路径 {

    public static void main(String[] args) {
        String path = simplifyPath("/../");
    }
    public static String simplifyPath(String path) {

        Stack<String> stack = new Stack();
        String[] paths = path.split("/");
        for (int i = 0; i < paths.length; i++) {
            path = paths[i];
            if (path.isEmpty() || path.equals(".") || (path.equals("..") && stack.size() == 0))continue;
            if (path.equals("..")) {
                stack.pop();
            } else  {
                stack.push(path);
            }
        }
        if (stack.size() == 0)return "/";

        StringBuffer buffer = new StringBuffer("");
        while (stack.size() > 0) {
            String hh = stack.pop();
            buffer.insert(0,hh);
            buffer.insert(0,"/");
        }
        return buffer.toString();
    }
}
