import java.io.*;
import java.math.*;
import java.util.*;
import java.util.regex.*;
import java.util.stream.*;

class Bale implements Comparable<Bale> {
    int s;
    int p;
    Bale(int s, int p) {
        this.s = s;
        this.p = p;
    }

    @Override
    public int compareTo(Bale d) {
        if(p > d.p) {
            return 1;
        }
        else if(p < d.p) {
            return -1;
        }
        else {
            return 0;
        }
    }
}

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;

    public static void main(String args[]) throws Exception {
        br = new BufferedReader(new FileReader("../input.txt"));
        //br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        Bale[] bales = new Bale[N];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            bales[i] = new Bale(s, p);
        }

        Arrays.sort(bales);

        int res = 0;

        for(int i=0; i<N-1; i++) {
            int l = i;
            int r = i+1;
            boolean escape = false;
            while(true) {
                if(l <= -1 || r >= N) {
                    escape = true;
                    break;
                }
                int distance = bales[r].p - bales[l].p;
                if(distance <= bales[l].s && distance <= bales[r].s) {
                    break;
                }
                if(bales[r].s < distance) {
                    r++;
                }
                if(bales[l].s < distance) {
                    l--;
                }
            }
            if(escape == false) {
                res += (bales[i+1].p-bales[i].p);
            }
        }

        bw.write(res+"");
        bw.newLine();

        bw.flush();
    }
}