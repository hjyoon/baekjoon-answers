import java.util.*;
import java.io.*;
import java.math.*;

class Duration {
    int start;
    int end;
    Duration(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;

    public static void main(String args[]) throws Exception {
        br = new BufferedReader(new FileReader("../input.txt"));
        //br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true) {
            String ss = br.readLine();
            if(ss.equals("0 0")) {
                break;
            }
            String[] s = ss.split(" ");
            int T = Integer.parseInt(s[0]);
            int M = Integer.parseInt(s[1]);

            ArrayList<Duration> al = new ArrayList<>();
            ArrayList<Duration> chk = new ArrayList<>();
            for(int i=0; i<T; i++) {
                s = br.readLine().split(" ");
                int start = Integer.parseInt(s[2]);
                int end = start + Integer.parseInt(s[3]);
                al.add(new Duration(start, end));
            }
            for(int i=0; i<M; i++) {
                s = br.readLine().split(" ");
                int start = Integer.parseInt(s[0]);
                int end = start + Integer.parseInt(s[1]);
                chk.add(new Duration(start, end));
            }

            for(Duration tmp1 : chk) {
                int res = 0;
                for(Duration tmp2 : al) {
                    if(!(tmp2.end <= tmp1.start) && !(tmp2.start >= tmp1.end)) {
                        res++;
                        //bw.write(tmp1.start+" "+tmp1.end+"\n");
                        //bw.write(tmp2.start+" "+tmp2.end+"\n");
                    }
                }
                bw.write(res+"\n");
            }
        }

        bw.flush();
    }
}