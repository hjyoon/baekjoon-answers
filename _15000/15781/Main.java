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

        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);

        Integer[] arr_N = new Integer[N];
        Integer[] arr_M = new Integer[M];
        //ArrayList<Integer> arr_N = new ArrayList<>();
        //ArrayList<Integer> arr_M = new ArrayList<>();

        s = br.readLine().split(" ");
        for(int i=0; i<N; i++) {
            arr_N[i] = Integer.parseInt(s[i]);
            //arr_N.add(Integer.parseInt(s[i]));
        }

        s = br.readLine().split(" ");
        for(int i=0; i<M; i++) {
            arr_M[i] = Integer.parseInt(s[i]);
            //arr_M.add(Integer.parseInt(s[i]));
        }



        Arrays.sort(arr_N, Comparator.reverseOrder());
        Arrays.sort(arr_M, Comparator.reverseOrder());
        //Arrays.sort(arr_N);
        //Arrays.sort(arr_M);
        //Collections.sort(arr_N, Comparator.reverseOrder());
        //Collections.sort(arr_M, Comparator.reverseOrder());

        int max_N = arr_N[0];
        int max_M = arr_M[0];
        //int max_N = arr_N.get(0);
        //int max_M = arr_M.get(0);


        bw.write(max_N+max_M+"");
        bw.flush();
    }
}