import java.io.*;
import java.math.*;
import java.util.*;
import java.util.regex.*;
import java.util.stream.*;

class Reader { 
    final private int BUFFER_SIZE = 1 << 16; 
    private DataInputStream din; 
    private byte[] buffer; 
    private int bufferPointer, bytesRead; 

    public Reader() { 
        din = new DataInputStream(System.in); 
        buffer = new byte[BUFFER_SIZE]; 
        bufferPointer = bytesRead = 0; 
    } 

    public Reader(String file_name) throws IOException { 
        din = new DataInputStream(new FileInputStream(file_name)); 
        buffer = new byte[BUFFER_SIZE]; 
        bufferPointer = bytesRead = 0; 
    } 

    public String readLine() throws IOException { 
        byte[] buf = new byte[64]; // line length 
        int cnt = 0, c; 
        while ((c = read()) != -1) { 
            if (c == '\n') 
                break; 
            buf[cnt++] = (byte) c; 
        } 
        return new String(buf, 0, cnt); 
    } 

    public int nextInt() throws IOException { 
        int ret = 0; 
        byte c = read(); 
        while (c <= ' ') 
            c = read(); 
        boolean neg = (c == '-'); 
        if (neg) 
            c = read(); 
        do { 
            ret = ret * 10 + c - '0'; 
        } while ((c = read()) >= '0' && c <= '9'); 

        if (neg) 
            return -ret; 
        return ret; 
    } 

    public long nextLong() throws IOException { 
        long ret = 0; 
        byte c = read(); 
        while (c <= ' ') 
            c = read(); 
        boolean neg = (c == '-'); 
        if (neg) 
            c = read(); 
        do { 
            ret = ret * 10 + c - '0'; 
        } 
        while ((c = read()) >= '0' && c <= '9'); 
        if (neg) 
            return -ret; 
        return ret; 
    } 

    public double nextDouble() throws IOException { 
        double ret = 0, div = 1; 
        byte c = read(); 
        while (c <= ' ') 
            c = read(); 
        boolean neg = (c == '-'); 
        if (neg) 
            c = read(); 

        do { 
            ret = ret * 10 + c - '0'; 
        } 
        while ((c = read()) >= '0' && c <= '9'); 

        if (c == '.') { 
            while ((c = read()) >= '0' && c <= '9') { 
                ret += (c - '0') / (div *= 10); 
            } 
        } 

        if (neg) 
            return -ret; 
        return ret; 
    } 

    private void fillBuffer() throws IOException { 
        bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE); 
        if (bytesRead == -1) 
            buffer[0] = -1; 
    } 

    private byte read() throws IOException { 
        if (bufferPointer == bytesRead) 
            fillBuffer(); 
        return buffer[bufferPointer++]; 
    } 

    public void close() throws IOException { 
        if (din == null) 
            return; 
        din.close(); 
    } 
}

class Point {
    int y;
    int x;
    Point(int y, int x) {
        this.y = y;
        this.x = x;
    }
}

public class Main {
    //static BufferedReader br;
    static BufferedWriter bw;
    //static StringTokenizer st;

    public static void init_flag(int[] flag) {
        for(int i=0; i<flag.length; i++) {
            flag[i] = i;
        }
    }

    public static boolean next_comb_non_recursive(int[] flag, int n, int r) {
        /* this check is not strictly necessary, but if r is not close to n,
        it makes the whole thing quite a bit faster */
        // if(flag[r-1] < n-1) {
        //     flag[r-1]++;
        //     return true;
        // }
        int i = r-1;
        while(flag[i] >= n-(r-i)) {
            i--;
            if(i < 0) {
                return false;
            }
        }
        flag[i]++;
        while(i < r-1) {
            flag[i+1] = flag[i] + 1;
            i++;
        }
        return true;
    }

    public static int distance(Point p1, Point p2) {
        return Math.abs(p1.y-p2.y) + Math.abs(p1.x-p2.x);
    }

    public static void main(String args[]) throws Exception {
        //br = new BufferedReader(new FileReader("../input.txt"));
        //br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Reader s = new Reader("../input.txt");
        //Reader s = new Reader();

        //st = new StringTokenizer(br.readLine());
        //int N = Integer.parseInt(st.nextToken());
        //int M = Integer.parseInt(st.nextToken());
        int N = s.nextInt();
        int M = s.nextInt();

        ArrayList<Point> home_list = new ArrayList<>();
        ArrayList<Point> chicken_list = new ArrayList<>();

        // input data
        for(int i=0; i<N; i++) {
            //st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                //int tmp = Integer.parseInt(st.nextToken());
                int tmp = s.nextInt();
                if(tmp == 1) {
                    home_list.add(new Point(i, j));
                }
                else if(tmp == 2) {
                    chicken_list.add(new Point(i, j));
                }
            }
        }

        int[] flag = new int[M];
        init_flag(flag);

        int min_sum = Integer.MAX_VALUE;
        do {
            int sum = 0;
            for(Point i : home_list) {
                int min = Integer.MAX_VALUE;
                for(int k=0; k<M; k++) {
                    Point j = chicken_list.get(flag[k]);
                    int tmp = distance(i, j);
                    min = Math.min(min, tmp);
                }
                sum += min;
            }
            min_sum = Math.min(min_sum, sum);
        } while(next_comb_non_recursive(flag, chicken_list.size(), M));

        bw.write(min_sum+"");
        bw.flush();
    }
}