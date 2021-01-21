import java.util.*;
import java.io.*;
import java.math.*;

class Component {
    public int cnt_C = 0;
    public int cnt_H = 0;
    public int cnt_O = 0;
}

public class Main_3 {
    static BufferedReader br;
    static BufferedWriter bw;

    static Component first = new Component();
    static Component second = new Component();
    static Component third = new Component();

    static int data[] = new int[]{1,2,3,4,5,6,7,8,9,10};
    static int flag[] = new int[3];

    static void check(int k) throws Exception {
        int x = data[flag[0]];
        int y = data[flag[1]];
        int z = data[flag[2]];
        if(first.cnt_C*x + second.cnt_C*y != third.cnt_C*z) {
            return;
        }
        if(first.cnt_H*x + second.cnt_H*y != third.cnt_H*z) {
            return;
        }
        if(first.cnt_O*x + second.cnt_O*y != third.cnt_O*z) {
            return;
        }
        bw.write(x + " " + y + " " + z + " " + "\n");
        bw.flush();
        System.exit(0);
    }

    static void perm(int depth, int n, int k) throws Exception {
        if (depth == k) {
            check(k);
            return;
        }
        for (int i = 0; i <= n; i++) {
            flag[depth] = i;
            perm(depth+1, n, k);
        }
    }

    static void cnt_atom(String[] s, Component c) throws Exception {
        for(int i=0; i<s.length; i++) {
            if(s[i].length() == 1) {
                if(s[i].charAt(0) == 'C') {
                    c.cnt_C++;
                }
                else if(s[i].charAt(0) == 'H') {
                    c.cnt_H++;
                }
                else {
                    c.cnt_O++;
                }
            }
            else {
                if(s[i].charAt(0) == 'C') {
                    c.cnt_C += Integer.parseInt(s[i].charAt(1)+"");
                }
                else if(s[i].charAt(0) == 'H') {
                    c.cnt_H += Integer.parseInt(s[i].charAt(1)+"");
                }
                else {
                    c.cnt_O += Integer.parseInt(s[i].charAt(1)+"");
                }
            }
        }
    }

    public static void main(String args[]) throws Exception {
        br = new BufferedReader(new FileReader("../input.txt"));
        //br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s = br.readLine().split("\\+|=");
        String[] ss1 = s[0].split("(?=[A-Z])");
        String[] ss2 = s[1].split("(?=[A-Z])");
        String[] ss3 = s[2].split("(?=[A-Z])");

        cnt_atom(ss1, first);
        cnt_atom(ss2, second);
        cnt_atom(ss3, third);

        perm(0, 9, 3);
    }
}