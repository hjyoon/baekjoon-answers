import java.io.*;
import java.math.*;
import java.util.*;
import java.util.regex.*;
import java.util.stream.*;

class Solution {
    BufferedReader br;
    BufferedWriter bw;
    StringTokenizer st;
    String path;
    ArrayList<Integer> al_s;
    ArrayList<Integer> al_b;
    int T;
    int N;
    int M;

    Solution(String path) throws Exception {
        this.path = path;
        br = new BufferedReader(new FileReader(path));
        //br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
    }

    void run() throws Exception {
        read_T();
        while(T-- > 0) {
            var_init();
            read_case();
            step_1();
            while(!step_2()){}
            print_reslut_of_case();
        }
    }

    void print_reslut_of_case() throws Exception {
        if(al_s.size() > 0) {
            bw.write("S\n");
        }
        else if(al_b.size() > 0) {
            bw.write("B\n");
        }
        else {
            bw.write("C\n");
        }
        bw.flush();
    }

    void step_1() {
        Collections.sort(al_s);
        Collections.sort(al_b);
    }

    boolean step_2() {
        if(al_s.size() == 0 || al_b.size() == 0) {
            return true;
        }

        if(al_s.get(0) > al_b.get(0)) {
            al_b.remove(0);
        }
        else if(al_s.get(0) < al_b.get(0)) {
            al_s.remove(0);
        }
        else {
            al_b.remove(0);
        }

        return false;
    }

    void var_init() throws Exception {
        al_s = new ArrayList<>();
        al_b = new ArrayList<>();
    }

    void read_case() throws Exception {
        String line = br.readLine();
        if(line.equals("")) {
            line = br.readLine();
        }
        st = new StringTokenizer(line);
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            al_s.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++) {
            al_b.add(Integer.parseInt(st.nextToken()));
        }
    }


    void read_T() throws Exception {
        st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
    }
}

public class Main {
	static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        new Solution("../input.txt").run();
    }
}