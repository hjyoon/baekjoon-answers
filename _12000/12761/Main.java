import java.util.*;
import java.io.*;
import java.math.*;

class MyData {
    public int idx;
    public int cnt;

    MyData(int idx, int cnt) {
        this.idx = idx;
        this.cnt = cnt;
    }
}

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;

    public static void main(String args[]) throws Exception {
        br = new BufferedReader(new FileReader("../input.txt"));
        //br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s = br.readLine().split(" ");
        int A = Integer.parseInt(s[0]);
        int B = Integer.parseInt(s[1]);
        int N = Integer.parseInt(s[2]);
        int M = Integer.parseInt(s[3]);

        boolean[] chk = new boolean[100001];

        Queue<MyData> qu = new LinkedList<>();
        MyData start = new MyData(N, 0);
        qu.offer(start);

        int res = 0;
        while(true) {
            if(qu.isEmpty() == true) {
                break;
            }

            MyData tmp = qu.poll();
            //bw.write(tmp.idx+" "+tmp.cnt+"\n");
            if(tmp.idx == M) {
                res = tmp.cnt;
                break;
            }
            if(chk[tmp.idx] == true) {
                continue;
            }

            //bw.write(tmp.idx+" "+tmp.cnt+"\n");

            chk[tmp.idx] = true;

            if(tmp.idx-1 >= 0) {
                qu.offer(new MyData(tmp.idx-1, tmp.cnt+1));
            }
            if(tmp.idx+1 <= 100000) {
                qu.offer(new MyData(tmp.idx+1, tmp.cnt+1));
            }
            if(tmp.idx-A >= 0) {
                qu.offer(new MyData(tmp.idx-A, tmp.cnt+1));
            }
            if(tmp.idx+A <= 100000) {
                qu.offer(new MyData(tmp.idx+A, tmp.cnt+1));
            }
            if(tmp.idx-B >= 0) {
                qu.offer(new MyData(tmp.idx-B, tmp.cnt+1));
            }
            if(tmp.idx+B <= 100000) {
                qu.offer(new MyData(tmp.idx+B, tmp.cnt+1));
            }
            if(tmp.idx*A <= 100000) {
                qu.offer(new MyData(tmp.idx*A, tmp.cnt+1));
            }
            if(tmp.idx*B <= 100000) {
                qu.offer(new MyData(tmp.idx*B, tmp.cnt+1));
            }
        }




        bw.write(res+"");
        bw.flush();
    }
}