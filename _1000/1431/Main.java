import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;

    public static void main(String args[]) throws Exception {
        br = new BufferedReader(new FileReader("../input.txt"));
        //br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        ArrayList<String> al = new ArrayList<>();

        for(int i=0; i<N; i++) {
            String s = br.readLine();
            al.add(s);
        }

        Collections.sort(al, new Comparator<String>() {
            public int compare(String s1, String s2) {
                if(s1.length() < s2.length()) {
                    return -1;
                }
                else if(s1.length() > s2.length()) {
                    return 1;
                }
                else {
                    int sum_s1 = 0, sum_s2 = 0;
                    for(int i=0; i<s1.length(); i++) {
                        if(s1.charAt(i) >= '0' && s1.charAt(i) <= '9') {
                            sum_s1 += s1.charAt(i)-'0'; 
                        }
                    }
                    for(int i=0; i<s2.length(); i++) {
                        if(s2.charAt(i) >= '0' && s2.charAt(i) <= '9') {
                            sum_s2 += s2.charAt(i)-'0'; 
                        }
                    }
                    if(sum_s1 < sum_s2) {
                        return -1;
                    }
                    else if(sum_s1 > sum_s2) {
                        return 1;
                    }
                    else {
                       return s1.compareTo(s2);
                   }
                }
            }
        });

        for(String ss : al) {
            bw.write(ss+"\n");
        }

        bw.flush();
    }
}