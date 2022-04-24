import java.io.*;
import java.math.*;
import java.util.*;
import java.util.regex.*;
import java.util.stream.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new FileReader("../input.txt"));
        //br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        int res_max[] = new int[3];
        int res_min[] = new int[3];

        st = new StringTokenizer(br.readLine());
        for(int j=0; j<3; j++) {
            res_max[j] = Integer.parseInt(st.nextToken());
            res_min[j] = res_max[j];
        }
        for(int i=0; i<n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int[] input = new int[3];
            for(int j=0; j<3; j++) {
                input[j] = Integer.parseInt(st.nextToken());
            }

            int tmp_max[] = new int[3];
            tmp_max[0] = Math.max(res_max[0], res_max[1]) + input[0];
            tmp_max[1] = Math.max(Math.max(res_max[0], res_max[1]), res_max[2]) + input[1];
            tmp_max[2] = Math.max(res_max[1], res_max[2]) + input[2];
            res_max = tmp_max;

            int tmp_min[] = new int[3];
            tmp_min[0] = Math.min(res_min[0], res_min[1]) + input[0];
            tmp_min[1] = Math.min(Math.min(res_min[0], res_min[1]), res_min[2]) + input[1];
            tmp_min[2] = Math.min(res_min[1], res_min[2]) + input[2];
            res_min = tmp_min;
        }

        // for(int i=0; i<3; i++) {
        //     bw.write(res_max[i]+" ");
        // }
        // bw.newLine();

        // for(int i=0; i<3; i++) {
        //     bw.write(res_min[i]+" ");
        // }
        // bw.newLine();

        Arrays.sort(res_max);
        Arrays.sort(res_min);

        bw.write(res_max[2]+" "+res_min[0]);
        bw.newLine();

        bw.flush();
    }
}