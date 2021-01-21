import java.io.*;
import java.math.*;
import java.util.*;
import java.util.regex.*;
import java.util.stream.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;

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
        int S = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] A = new int[N];
        int[] B = new int[M];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            A[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            B[i] = Integer.parseInt(st.nextToken());
        }

        int cnt = 0;

        ArrayList<Integer> al1 = new ArrayList<>();
        ArrayList<Integer> al2 = new ArrayList<>();

        //HashMap<Integer, Integer> hm1 = new HashMap<>();
        //HashMap<Integer, Integer> hm2 = new HashMap<>();

        if(N >= 2) {
            for(int i=0; i<N; i++) {
                int sum = A[i];
                al1.add(sum);
                for(int j=i+1; j%N!=(i+N-1)%N; j++) {
                    sum += A[j%N];
                    al1.add(sum);
                }
            }
        }

        {
            int sum = 0;
            for(int i=0; i<N; i++) {
                sum += A[i];
            }
            al1.add(sum);
        }

        if(M >= 2) {
            for(int i=0; i<M; i++) {
                int sum = B[i];
                al2.add(sum);
                for(int j=i+1; j%M!=(i+M-1)%M; j++) {
                    sum += B[j%M];
                    al2.add(sum);
                }
            }
        }

        {
            int sum = 0;
            for(int i=0; i<M; i++) {
                sum += B[i];
            }
            al2.add(sum);
        }

        // for(int i=0; i<N; i++) {
        //     for(int j=0; j<N; j++) {
        //         int target = A[i]+B[j];
        //         if(hm1.containsKey(target)) {
        //             int tmp = hm1.get(target);
        //             hm1.put(target, tmp+1);

        //         }
        //         else {
        //             hm1.put(target, 1);
        //         }
        //     }
        // }

        // for(int i=0; i<N; i++) {
        //     for(int j=0; j<N; j++) {
        //         int target = -(C[i]+D[j]);
        //         if(hm2.containsKey(target)) {
        //             int tmp = hm2.get(target);
        //             hm2.put(target, tmp+1);
        //         }
        //         else {
        //             hm2.put(target, 1);
        //         }
        //     }
        // }

        Collections.sort(al1);
        Collections.sort(al2);

        // for(int i : al1) {
        //     bw.write(i+" ");
        // }
        // bw.newLine();
        // for(int i : al2) {
        //     bw.write(i+" ");
        // }
        // bw.newLine();


        for(int i=0; i<al1.size(); i++) {
            int tmp = upperBound_for_list(al2, 0, al2.size(), S-al1.get(i)) - lowerBound_for_list(al2, 0, al2.size(), S-al1.get(i));
            // if(Collections.binarySearch(al2, al1.get(i)) >= 0) {
            //     cnt++;
            // }
            // int tmp = 0;
            // if(hm2.containsKey(al1.get(i))) {
            //     tmp = hm2.get(al1.get(i));
            // }
            cnt += tmp;
        }

        cnt += upperBound_for_list(al1, 0, al1.size(), S) - lowerBound_for_list(al1, 0, al1.size(), S);
        cnt += upperBound_for_list(al2, 0, al2.size(), S) - lowerBound_for_list(al2, 0, al2.size(), S);

        // for(int i=0; i<N; i++) {
        //     for(int j=0; j<N; j++) {
        //         //al1.add(A[i]+B[j]);
        //         int tmp = 0;
        //         if(hm2.containsKey(A[i]+B[j])) {
        //             tmp = hm2.get(A[i]+B[j]);
        //         }
        //         cnt += tmp;
        //     }
        // }

        bw.write(cnt+"");
        bw.newLine();

        bw.flush();
    }
}