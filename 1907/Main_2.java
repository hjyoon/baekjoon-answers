import java.util.*;
import java.io.*;
import java.math.*;

class Component {
    public int cnt_C = 0;
    public int cnt_H = 0;
    public int cnt_O = 0;
}

public class Main_2 {
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

    static void cnt_atom(String s, Component c) throws Exception {
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == 'C') {
                if(i == s.length()-1) {
                    c.cnt_C++;
                }
                else if(s.charAt(i+1) >= '2' && s.charAt(i+1) <= '9') {
                    c.cnt_C += Integer.parseInt(s.charAt(i+1)+"");
                }
                else{
                    c.cnt_C++;
                }
            }
            else if(s.charAt(i) == 'H') {
                if(i == s.length()-1) {
                    c.cnt_H++;
                }
                else if(s.charAt(i+1) >= '2' && s.charAt(i+1) <= '9') {
                    c.cnt_H += Integer.parseInt(s.charAt(i+1)+"");
                }
                else{
                    c.cnt_H++;
                }
            }
            else if(s.charAt(i) == 'O') {
                if(i == s.length()-1) {
                    c.cnt_O++;
                }
                else if(s.charAt(i+1) >= '2' && s.charAt(i+1) <= '9') {
                    c.cnt_O += Integer.parseInt(s.charAt(i+1)+"");
                }
                else{
                    c.cnt_O++;
                }
            }
        }
    }

    public static void main(String args[]) throws Exception {
        br = new BufferedReader(new FileReader("../input.txt"));
        //br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s = br.readLine().split("\\+|=");

        cnt_atom(s[0], first);
        cnt_atom(s[1], second);
        cnt_atom(s[2], third);

        perm(0, 9, 3);
    }
}