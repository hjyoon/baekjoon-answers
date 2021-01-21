import java.io.*;
import java.math.*;
import java.util.*;
import java.util.regex.*;
import java.util.stream.*;

class FastIO {
    private static final int EOF = -1;
    
    private static final byte ASCII_n = 10;
    private static final byte ASCII_space = 32;
    private static final byte ASCII_minus = 45;
    private static final byte ASCII_0 = 48;
    private static final byte ASCII_9 = 57;
    
    private final DataInputStream din;
    private final DataOutputStream dout;
    
    private byte[] inbuffer;
    private int inbufferpointer, bytesread;
    private byte[] outbuffer;
    private int outbufferpointer;
    
    private byte[] bytebuffer;
    
    private FastIO() {
        this.din = new DataInputStream(System.in);
        this.dout = new DataOutputStream(System.out);
        
        this.inbuffer = new byte[65536];
        this.inbufferpointer = 0;
        this.bytesread = 0;
        this.outbuffer = new byte[65536];
        this.outbufferpointer = 0;
        
        this.bytebuffer = new byte[20];
    }
    
    private byte read() {
        if (inbufferpointer == bytesread)
            fillbuffer();
        return bytesread == EOF ? EOF : inbuffer[inbufferpointer++];
    }
    
    private void fillbuffer() {
        try {
            bytesread = din.read(inbuffer, inbufferpointer = 0, inbuffer.length);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    private void write(byte b) {
        if (outbufferpointer == outbuffer.length)
            flushbuffer();
        outbuffer[outbufferpointer++] = b;
    }
    
    private void flushbuffer() {
        if (outbufferpointer != 0) {
            try {
                dout.write(outbuffer, 0, outbufferpointer);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            outbufferpointer = 0;
        }
    }
    
    private int nextInt() {
        byte b;
        while(isSpace(b = read()))
            ;
        boolean negative = false;
        if (b == '-') {
            negative = true;
            b = read();
        }
        int result = b - '0';
        while (isDigit(b = read()))
            result = result * 10 + b - '0';
        return negative ? -result : result;
    }
    
    private void println(int i) {
        if (i == 0) {
            write(ASCII_0);
        } else {
            if (i < 0) {
                write(ASCII_minus);
                i = -i;
            }
            int index = 0;
            while (i > 0) {
                bytebuffer[index++] = (byte) ((i % 10) + ASCII_0);
                i /= 10;
            }
            while (index-- > 0) {
                write(bytebuffer[index]);
            }
        }
        write(ASCII_n);
    }
    
    private boolean isSpace(byte b) {
        return b <= ASCII_space && b >= 0;
    }
    
    private boolean isDigit(byte b) {
        return b >= ASCII_0 && b <= ASCII_9;
    }
}

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

public class Main {
    //static BufferedReader br;
    static BufferedWriter bw;
    //static StringTokenizer st;
    static int[] a = new int[100001];
    static int N;
    static int M;

    public static void main(String args[]) throws Exception {
        //br = new BufferedReader(new FileReader("../input.txt"));
        //br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //Reader s = new Reader("../input.txt");
        //Reader s = new Reader();

        FastIO io = new FastIO();

        N = io.nextInt();
        
        //int[] a = new int[N+1];
        for(int i=1; i<=N; i++) {
            a[i] = a[i-1] + io.nextInt();
        }

        M = io.nextInt();

        for(int i=0; i<M; i++) {
            bw.write(-a[io.nextInt()-1]+a[io.nextInt()]+"\n");
        }
        bw.flush();
    }

    private static class FastIO {
        private static final int EOF = -1;
        
        private static final byte ASCII_n = 10;
        private static final byte ASCII_space = 32;
        private static final byte ASCII_minus = 45;
        private static final byte ASCII_0 = 48;
        private static final byte ASCII_9 = 57;
        
        private final DataInputStream din;
        private final DataOutputStream dout;
        
        private byte[] inbuffer;
        private int inbufferpointer, bytesread;
        private byte[] outbuffer;
        private int outbufferpointer;
        
        private byte[] bytebuffer;
        
        private FastIO() {
            this.din = new DataInputStream(System.in);
            this.dout = new DataOutputStream(System.out);
            
            this.inbuffer = new byte[65536];
            this.inbufferpointer = 0;
            this.bytesread = 0;
            this.outbuffer = new byte[65536];
            this.outbufferpointer = 0;
            
            this.bytebuffer = new byte[20];
        }
        
        private byte read() {
            if (inbufferpointer == bytesread)
                fillbuffer();
            return bytesread == EOF ? EOF : inbuffer[inbufferpointer++];
        }
        
        private void fillbuffer() {
            try {
                bytesread = din.read(inbuffer, inbufferpointer = 0, inbuffer.length);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        
        private void write(byte b) {
            if (outbufferpointer == outbuffer.length)
                flushbuffer();
            outbuffer[outbufferpointer++] = b;
        }
        
        private void flushbuffer() {
            if (outbufferpointer != 0) {
                try {
                    dout.write(outbuffer, 0, outbufferpointer);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                outbufferpointer = 0;
            }
        }
        
        private int nextInt() {
            byte b;
            while(isSpace(b = read()))
                ;
            boolean negative = false;
            if (b == '-') {
                negative = true;
                b = read();
            }
            int result = b - '0';
            while (isDigit(b = read()))
                result = result * 10 + b - '0';
            return negative ? -result : result;
        }
        
        private void println(int i) {
            if (i == 0) {
                write(ASCII_0);
            } else {
                if (i < 0) {
                    write(ASCII_minus);
                    i = -i;
                }
                int index = 0;
                while (i > 0) {
                    bytebuffer[index++] = (byte) ((i % 10) + ASCII_0);
                    i /= 10;
                }
                while (index-- > 0) {
                    write(bytebuffer[index]);
                }
            }
            write(ASCII_n);
        }
        
        private boolean isSpace(byte b) {
            return b <= ASCII_space && b >= 0;
        }
        
        private boolean isDigit(byte b) {
            return b >= ASCII_0 && b <= ASCII_9;
        }
    }
}