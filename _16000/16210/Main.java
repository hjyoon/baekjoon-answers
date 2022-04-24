import java.text.*;
import java.util.*;
import java.io.*;
public class Main_16210{
    static int F = 500;
    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int k=1; k<=F; k++) {
            String input_file_name = "C:\\Users\\hjyoon\\Desktop\\testcase\\input_data\\input-made" + k + ".txt";
            //File file = new File(input_file_name);
            FileReader fr = new FileReader(new File(input_file_name));
            BufferedReader br = new BufferedReader(fr);

            String output_file_name = "C:\\Users\\hjyoon\\Desktop\\testcase\\output_data\\output_answer" + ".txt";
            //File file = new File(output_file_name);
            FileWriter writer = new FileWriter(new File(output_file_name), true);


            int n = Integer.parseInt(br.readLine());
            Point[] points = new Point[n+1];
            int[] x = new int[n+1];
            int[] y = new int[n+1];
            long min = Long.MAX_VALUE;
            int ans = 1;
            for(int i=1;i<=n;i++){
                StringTokenizer stk = new StringTokenizer(br.readLine());
                points[i] = new Point(Integer.parseInt(stk.nextToken()),Integer.parseInt(stk.nextToken()));
                x[i] = (int)points[i].x;
                y[i] = (int)points[i].y;
            }
            Arrays.sort(x,1,n+1);
            Arrays.sort(y,1,n+1);
            long[] px = new long[n+1];
            long[] py = new long[n+1];
            for(int i=1;i<=n;i++){
                px[i] = px[i-1] + x[i];
                py[i] = py[i-1] + y[i];
            }
            // for(int i=0; i<=n; i++) {
            //     System.out.println(px[i]);
            // }
            for(int i=1; i<=n; i++){
                Point p = points[i];
                int idxX = Arrays.binarySearch(x,1,n+1,(int)p.x);
                int idxY = Arrays.binarySearch(y,1,n+1,(int)p.y);
                long sum = py[n] - py[idxY] -py[idxY-1] - (n-idxY)*p.y + (idxY-1)*p.y;
                sum += px[n] - px[idxX] - px[idxX-1] - (n-idxX)*p.x + (idxX-1)*p.x;
                if(sum < min){
                    min = sum;
                    ans = i;
                    //System.out.println("" + '(' + p.x + ',' + p.y +  ')' + ' ' + i + ' ' + min);
                }
            }
            //System.out.println(ans);
            writer.write("" + ans + "\n");
            writer.flush();
        }
    }
 
    public static class Point{
        long x,y;
        public Point(int x,int y){
            this.x = x; this.y = y;
        }
    }
}
