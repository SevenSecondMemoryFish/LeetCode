package Stack;

import java.util.Stack;

public class _1598_文件夹操作日志搜集器 {

    public int minOperations(String[] logs) {
        Stack<String> stringStack = new Stack<>();
        for (int i = 0; i < logs.length; i++) {
            String str = logs[i];
            if (str.equals("./")) {
                continue;
            }
            if (str.equals("../")) {
                if (stringStack.isEmpty()) {
                    stringStack.pop();
                }
            } else {
                stringStack.push(str);
            }

        }
        return stringStack.size();
    }
}
