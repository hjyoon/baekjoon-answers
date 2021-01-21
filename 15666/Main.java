import java.io.*;
import java.math.*;
import java.util.*;
import java.util.regex.*;
import java.util.stream.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static LinkedHashSet<String> lhs;

    public static void print(int[] data, int[] flag) throws Exception {
        for(int i=0; i<flag.length; i++) {
            bw.write(data[flag[i]]+" ");
        }
        bw.newLine();
    }

    public static void print(int[] data, int[] flag, int r) throws Exception {
        for(int i=0; i<r; i++) {
            bw.write(data[flag[i]]+" ");
        }
        bw.newLine();
    }

    public static String print_buf(int[] data, int[] flag, int r) {
        String res = "";
        for(int i=0; i<r; i++) {
            res += data[flag[i]]+" ";
        }
        return res;
    }

    public static void swap(int[] arr, int pos1, int pos2) {
        int tmp = arr[pos1];
        arr[pos1] = arr[pos2];
        arr[pos2] = tmp;
    }

    public static boolean next_comb_overlab_non_recursive(int[] flag, int n, int r) {
        /* this check is not strictly necessary, but if r is not close to n,
        it makes the whole thing quite a bit faster */
        // if(flag[r-1] < n-1) {
        //  flag[r-1]++;
        //  return true;
        // }
        int i = r-1;
        while(flag[i] >= n-1) {
            i--;
            if(i < 0) {
                return false;
            }
        }
        flag[i]++;
        while(i < r-1) {
            flag[i+1] = flag[i];
            i++;
        }
        return true;
    }

    public static void main(String args[]) throws Exception {
        br = new BufferedReader(new FileReader("../input.txt"));
        //br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] data = new int[N];
        for(int i=0; i<N; i++) {
            data[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(data);

        int[] flag = new int[N];
        for(int i=0; i<N; i++) {
            flag[i] = 0;
        }

        // 중복제거
        lhs = new LinkedHashSet<>();

        do {
            //print(data, flag, M);
            lhs.add(print_buf(data, flag, M));
        } while(next_comb_overlab_non_recursive(flag, N, M));

        for(String i : lhs) {
            bw.write(i+"\n");
        }

        bw.flush();
    }
}