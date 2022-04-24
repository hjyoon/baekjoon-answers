import java.io.*;
import java.math.*;
import java.util.*;
import java.util.regex.*;
import java.util.stream.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;

    final static int LIMIT = 1<<20; 

    static int cal(int n, int[] A) throws Exception {
        int sum = 0;
        int i = 1;
        int cnt = 0;
        while(true) {
            if(i == LIMIT) {
                break;
            }
            if((n & i) == i) {
                //bw.write(n+" "+i+"\n");
                //bw.flush();
                sum += A[cnt];
            }
            i <<= 1;
            cnt++;
        }
        return sum;
    }

    public static int upperBound_for_list(List<Integer> data, int front, int rear, int target) {      
        int mid = 0;
        while(front < rear) {
            mid = (front + rear) / 2;
            if(data.get(mid) <= target) {
                front = mid + 1;
            }
            else {
                rear = mid;
            }
        }
        return rear;
    }

    public static int lowerBound_for_list(List<Integer> data, int front, int rear, int target) {
        int mid = 0;
        while(front < rear) {
            mid = (front + rear) / 2;
            if(data.get(mid) < target) {
                front = mid + 1;
            }
            else {
                rear = mid;
            }
        }
        return rear;
    }

    public static void main(String args[]) throws Exception {
        br = new BufferedReader(new FileReader("../input.txt"));
        //br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int l1 = N/2;
        int l2 = N-l1;
        
        int[] A1 = new int[l1];
        int[] A2 = new int[l2];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<l1; i++){
            A1[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<l2; i++){
            A2[i] = Integer.parseInt(st.nextToken());
        }

        //bw.write(l1+"\n");
        //bw.write(l2+"\n");
        //bw.flush();

        ArrayList<Integer> al1 = new ArrayList<>();
        int l1_limit = 1<<l1;
        for(int i=0; i<l1_limit; i++) {
            int tmp = cal(i, A1);
            al1.add(tmp);
        }
        Collections.sort(al1);

        ArrayList<Integer> al2 = new ArrayList<>();
        int l2_limit = 1<<l2;
        for(int i=0; i<l2_limit; i++) {
            int tmp = cal(i, A2);
            al2.add(tmp);
        }
        Collections.sort(al2);

        long res = 0;
        for(int i=0; i<al1.size(); i++) {
            int target = S - al1.get(i);
            int tmp = upperBound_for_list(al2, 0, al2.size(), target) - lowerBound_for_list(al2, 0, al2.size(), target);
            //bw.write(target+" ");
            //bw.write(tmp+" ");
            res += tmp;
        }

        //bw.newLine();
        // for(int i : al1) {
        //     bw.write(i+" ");
        // }
        // bw.newLine();
        // for(int i : al2) {
        //     bw.write(i+" ");
        // }
        // bw.newLine();

        if(S == 0) {
            res--;
        }
        bw.write(res+"");
        bw.newLine();

        bw.flush();
    }
}