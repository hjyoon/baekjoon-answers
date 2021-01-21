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
        String[] s = br.readLine().split(" ");

        int[] arr = new int[N];
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        ArrayList<Integer> res = new ArrayList<>();
        //int[] res = new int[N];
        //res[0] = 1;
        res.add(1);
        for(int i=1; i<N; i++) {
            res.add(1);
            for(int j=0; j<i; j++) {
                if(arr[i] > arr[j] && res.get(j)+1 > res.get(i)) {
                    res.set(i, res.get(j)+1);
                }
            }
        }

        //Arrays.sort(res);
        int ans = Collections.max(res);
        bw.write(ans+"");

        // for(int i : res) {
        //     bw.write(i+" ");
        // }

        bw.flush();
    }
}