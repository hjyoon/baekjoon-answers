import java.io.*;
import java.math.*;
import java.util.*;
import java.util.regex.*;
import java.util.stream.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;

    public static int getPriority(char c) {
        if(c == '+' || c == '-') {
            return 0;
        }
        else if(c == '*' || c == '/') {
            return 1;
        }
        else {
            return -1;
        }
    }

    public static boolean isOperator(char c) {
        if(c == '+' || c == '-' || c == '*' || c == '/') {
            return true;
        }
        return false;
    }

    public static boolean isOperand(char c) {
        if(c >= 'A' && c <= 'Z') {
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new FileReader("../input.txt"));
        //br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());
        String S = st.nextToken();

        int l = S.length();

        Stack<Character> stk = new Stack<>();
        //stk.push(start);
        //stk.peak();
        //stk.pop();

        int i = 0;
        while(i < l) {
            char next = S.charAt(i++);
            //bw.write("next: " + next);
            //bw.newLine();
            if(isOperand(next)) {
                stk.push(next);
                //bw.write("push: " + next);
                //bw.newLine();
                bw.write(stk.pop()+"");
                //bw.newLine();
            }
            else if(isOperator(next)) {
                while(true) {
                    if(stk.empty()) {
                        //bw.write("push");
                        //bw.newLine();
                        stk.push(next);
                        //bw.write("push: " + next);
                        //bw.newLine();
                        break;
                    }
                    char tmp = stk.peek();
                    if(isOperator(tmp) && getPriority(next) <= getPriority(tmp)) {
                        bw.write(stk.pop()+"");
                        //bw.newLine();
                    }
                    else {
                        //bw.write("push");
                        //bw.newLine();
                        stk.push(next);
                        break;
                    }
                }
            }
            else if(next == '(') {
                //bw.write("push");
                //bw.newLine();
                stk.push(next);
            }
            else if(next == ')') {
                while(true) {
                    if(stk.empty()) {
                        break;
                    }
                    char tmp = stk.peek();
                    if(tmp == '(') {
                        stk.pop();
                        break;
                    }
                    else {
                        //bw.write("print:");
                        bw.write(stk.pop()+"");
                        //bw.newLine();
                    }
                }
            }
        }

        while(!stk.empty()) {
            //bw.write("print:");
            bw.write(stk.pop()+"");
            //bw.newLine();
        }
        
        //bw.write(S+"");
        bw.newLine();

        bw.flush();
    }
}