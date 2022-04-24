import java.io.*;
import java.math.*;
import java.util.*;
import java.util.regex.*;
import java.util.stream.*;

class Pair implements Comparable<Pair> {
    public int i;
    public long n;
 
    Pair(int i, long n) {
        this.i = i;
        this.n = n;
    }

    @Override
    public int compareTo(Pair p) {
        if(n > p.n) {
            return 1;
        }
        else if(n < p.n) {
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
        int T = Integer.parseInt(st.nextToken());

        while(T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());   // k <= 1,000,000

            PriorityQueue<Pair> min_pq = new PriorityQueue<>(); // 오름차순
            PriorityQueue<Pair> max_pq = new PriorityQueue<>(Comparator.reverseOrder());    // 내림차순
            boolean[] v = new boolean[k];

            for(int i=0; i<k; i++) {
                st = new StringTokenizer(br.readLine());
                String op = st.nextToken();
                long n = Long.parseLong(st.nextToken());
                if(op.equals("I")) {
                    Pair p = new Pair(i, n);
                    min_pq.offer(p);
                    max_pq.offer(p);
                }
                else if(op.equals("D")){
                    if(n == 1) {
                        if(!max_pq.isEmpty()) {
                            Pair p = max_pq.peek();
                            if(v[p.i] == false) {
                                max_pq.poll();
                                v[p.i] = true;
                            }
                        }
                    }
                    else if(n == -1) {
                        if(!min_pq.isEmpty()) {
                            Pair p = min_pq.peek();
                            if(v[p.i] == false) {
                                min_pq.poll();
                                v[p.i] = true;
                            }
                        }
                    }
                }

                while(!min_pq.isEmpty()) {
                    if (!v[min_pq.peek().i]) {
                        break;
                    }
                    else {
                        min_pq.poll();
                    }
                }

                while(!max_pq.isEmpty()) {
                    if (!v[max_pq.peek().i]) {
                        break;
                    }
                    else {
                        max_pq.poll();
                    }
                }


            }

            if(min_pq.isEmpty() || max_pq.isEmpty()) {
                bw.write("EMPTY"+"\n");
            }
            else {
                bw.write(max_pq.poll().n + " "+ min_pq.poll().n + "\n");
            }
        }

        bw.flush();
    }
}