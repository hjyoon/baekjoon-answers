import java.util.*;
import java.io.*;
import java.math.*;

class Component {
    public int cnt_C = 0;
    public int cnt_H = 0;
    public int cnt_O = 0;
}

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;

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

        Component first = new Component();
        Component second = new Component();
        Component third = new Component();

        cnt_atom(s[0], first);
        cnt_atom(s[1], second);
        cnt_atom(s[2], third);

        final int limit = 10;

        for(int i=1; i<=limit; i++) {
            for(int j=1; j<=limit; j++) {
                for(int k=1; k<=limit; k++) {
                    if(first.cnt_C*i + second.cnt_C*j != third.cnt_C*k) {
                        continue;
                    }
                    if(first.cnt_H*i + second.cnt_H*j != third.cnt_H*k) {
                        continue;
                    }
                    if(first.cnt_O*i + second.cnt_O*j != third.cnt_O*k) {
                        continue;
                    }

                    bw.write(i + " " + j + " " + k + " " + "\n");
                    bw.flush();
                    return;
                }
            }
        }
    }
}