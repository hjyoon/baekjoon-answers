import java.io.*;
import java.math.*;
import java.util.*;
import java.util.regex.*;
import java.util.stream.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;

    public static void main(String args[]) throws Exception {
        br = new BufferedReader(new FileReader("../input.txt"));
        //br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        ArrayList<Boolean> primeList = new ArrayList<>();
        primeList.add(false);
        primeList.add(false);
        for(int i=2; i<=N; i++ ) {
            primeList.add(true);
        }
        for(int i=2; (i*i)<=N; i++){
            if(primeList.get(i)){
                for(int j = i*2; j<=N; j+=i) {
                    primeList.set(j, false);
                }
            }
        }

        ArrayList<Integer> al = new ArrayList<>();
        for(int i=0; i<primeList.size(); i++) {
            if(primeList.get(i)) {
                al.add(i);
            }
        }

        // for(int i : al) {
        //     bw.write(i+" ");
        // }

        int cnt = 0;
        int l = 0;
        int r = 0;
        int size = al.size();
        int sum = 0;
        if(size != 0) {
            sum = al.get(0);
        }
        while(r < size) {
            if(sum < N) {
                r++;
                if(r == size) break;
                sum += al.get(r);
            }
            else if(sum > N) {
                sum -= al.get(l);
                l++;
                if(l == size) break;
                if(l > r) {
                    r = l;
                }
            }
            else {
                cnt++;
                sum -= al.get(l);
                l++;
                r++;
                if(l == size || r == size) break;
                sum += al.get(r);
            }
        }


        // for(int i=0; i<N; i++) {
        //     for(int j=i; j<N; j++) {
        //         sum += A[j];
        //         if(sum > M) {
        //             length = j-i+1;
        //             if(length < min) {
        //                 min = length;
        //                 break;
        //             }
        //         }
        //     }
        //     sum = 0;
        // }

        bw.write(cnt+"");
        bw.newLine();

        bw.flush();
    }
}