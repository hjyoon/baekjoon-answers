import java.util.*;
import java.io.*;
import java.math.*;

class Vertex {
    int s;
    int x;
    int y;

    Vertex(int s, int x, int y) {
        this.s = s;
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static ArrayList<Vertex> al;

    static int distance(Vertex a, Vertex b) {
        return Math.abs(b.x-a.x) + Math.abs(b.y-a.y);
    }

    static int find_distance(Vertex v) {
        int min = Integer.MAX_VALUE;
        int idx = -1;
        for(int i=0; i<al.size(); i++) {
            if(al.get(i).s == 1 && min > distance(v, al.get(i))) {
                min = distance(v, al.get(i));
                idx = i;
            }
        }
        return idx;
    }

    public static void main(String args[]) throws Exception {
        br = new BufferedReader(new FileReader("../input.txt"));
        //br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int T = Integer.parseInt(s[1]);

        al = new ArrayList<>();

        for(int i=0; i<N; i++) {
           s = br.readLine().split(" ");
           int tmp_s = Integer.parseInt(s[0]);
           int tmp_x = Integer.parseInt(s[1]);
           int tmp_y = Integer.parseInt(s[2]);
           al.add(new Vertex(tmp_s, tmp_x, tmp_y));
        }

        int M = Integer.parseInt(br.readLine());
        while(M-->0) {
            s = br.readLine().split(" ");
            int A = Integer.parseInt(s[0]);
            int B = Integer.parseInt(s[1]);

            Vertex tmp_A = al.get(A-1);
            Vertex tmp_B = al.get(B-1);

            int res = 0;
            if(tmp_A.s == 1 && tmp_B.s == 1) {
                res = Math.min(distance(tmp_A, tmp_B), T);
            }
            else if(tmp_A.s == 0 && tmp_B.s == 0) {
                int idx_a_d = find_distance(tmp_A);
                int idx_b_d = find_distance(tmp_B);
                if(idx_a_d == idx_b_d || idx_a_d == -1) {
                    res = distance(tmp_A, tmp_B);
                }
                else {
                    res = distance(tmp_A, al.get(idx_a_d)) + distance(tmp_B, al.get(idx_b_d)) + T;
                    res = Math.min(res, distance(tmp_A, tmp_B));
                }
            }
            else if(tmp_A.s == 1 && tmp_B.s == 0) {
                int idx_b_d = find_distance(tmp_B);
                if(A-1 == idx_b_d || idx_b_d == -1) {
                    res = distance(tmp_A, tmp_B);
                }
                else {
                    res = distance(tmp_B, al.get(idx_b_d)) + T;
                    res = Math.min(res, distance(tmp_A, tmp_B));
                }
            }
            else if(tmp_A.s == 0 && tmp_B.s == 1) {
                int idx_a_d = find_distance(tmp_A);
                if(B-1 == idx_a_d || idx_a_d == -1) {
                    res = distance(tmp_A, tmp_B);
                }
                else {
                    res = distance(tmp_A, al.get(idx_a_d)) + T;
                    res = Math.min(res, distance(tmp_A, tmp_B));
                }
            }

            bw.write(res+"\n");
        }

        //bw.write(sum+" ");
        bw.flush();
    }
}