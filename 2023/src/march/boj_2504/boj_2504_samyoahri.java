package march.boj_2504;

import java.io.*;
import java.util.Stack;

public class boj_2504_samyoahri {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder ans = new StringBuilder();

        String str = in.readLine();
        Stack<Character> stack = new Stack<>();
        int tmp = 1;
        int res = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch==')') {
                if (stack.isEmpty() || stack.peek() == '[') {
                    tmp = 0;
                    break;
                }
                if (str.charAt(i - 1) == '(') {
                    res += tmp;
                }
                stack.pop();
                tmp = tmp/2;
            }
            else if (ch == ']') {
                if (stack.isEmpty() || stack.peek() == '(') {
                    tmp = 0;
                    break;
                }
                if (str.charAt(i - 1) == '[') {
                    res += tmp;
                }
                stack.pop();
                tmp = tmp / 3;
            }
            else {
                if (ch == '(') {
                    stack.push('(');
                    tmp *= 2;
                } else if (ch == '[') {
                    stack.push('[');
                    tmp *= 3;
                }
            }
        }
        if (stack.isEmpty() && tmp != 0) {
            ans.append(res);
        } else {
            ans.append(0);
        }

        out.write(ans.toString());
        out.flush();
        in.close();
        out.close();
    }
}
