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
        long N = Long.parseLong(st.nextToken());
        long K = Long.parseLong(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        int[][] d = new int[P+1][P+1];

        // �Ľ�Į �ﰢ�� �����
        for(int i=0; i<=P; i++) {
            d[i][0] = d[i][i] = 1;
            for(int j=1; j<=i-1; j++) {
                d[i][j] = d[i-1][j-1] + d[i-1][j];
                d[i][j] %= P;
            }
        }

        // print test
        for(int i=0; i<=P; i++) {
            for(int j=0; j<=P; j++) {
                bw.write(d[i][j]+" ");
            }
            bw.newLine();
        }

        // P�������� �����
        ArrayList<Integer> a = new ArrayList<>();   // N�� P���� ����
        ArrayList<Integer> b = new ArrayList<>();   // K�� P���� ����
        while (N > 0 || K > 0) {
            a.add((int)(N%P));
            b.add((int)(K%P));
            N /= P;
            K /= P;
        }

        // a.get(i) : P���� N�� i��° �ڸ���
        // b.get(i) : P���� K�� i��° �ڸ���

        for(int i : a) {
            bw.write(i+" ");
        }
        bw.newLine();

        for(int i : b) {
            bw.write(i+" ");
        }
        bw.newLine();

        long res = 1;
        for (int i=0; i<a.size(); i++) {
            res *= d[a.get(i)][b.get(i)];
            bw.write(d[a.get(i)][b.get(i)]+" ");
            res %= P;
        }
        bw.newLine();
        bw.write(res+"");
        bw.newLine();
        bw.flush();
    }
}