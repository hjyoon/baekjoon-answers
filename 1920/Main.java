import java.io.*;
import java.math.*;
import java.util.*;
import java.util.regex.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    //static String[] s;

    public static void main(String args[]) throws Exception {
    	br = new BufferedReader(new FileReader("../input.txt"));
        //br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");

        HashSet<String> hs = new HashSet<>();

        for(int i=0; i<N; i++) {
            hs.add(s[i]);
        }

        // ó���� ��Ұ� ������ sort, ������ parallelSort ���
        //Arrays.sort(A);
        //Arrays.parallelSort(A); // �����带 ����Ͽ� ����

        //Arrays.sort(A, Collections.reverseOrder());

        //Integer[] t = A;

        // for(int tmp : hs) {
        //     bw.write(tmp + "");
        // }

        int M = Integer.parseInt(br.readLine());
        s = br.readLine().split(" ");
        for(int i=0; i<M; i++) {
            if(hs.contains(s[i])) {
                bw.write("1\n");
            }
            else {
                bw.write("0\n");   
            }
        }

		bw.flush();
    }
}