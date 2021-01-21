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

        String s = st.nextToken();
        //String s = br.readLine();

        if(s.equals("��.��.��")) {
            bw.write("�� ����Ұ�, �� ������, �� ����.");
        }
        else if(s.equals("��.��.��")) {
            bw.write("����� ������ ������");
        }
        else if(s.equals("��.ȭ.��")) {
            bw.write("���ݺ��� ȭ������");
        }
        else if(s.equals("��.��.��")) {
            bw.write("����ְ� �ǰ��ϰ�, �ູ�ϸ� ����");
        }
        else if(s.equals("��.¡.��")) {
            bw.write("�������� ¡�׷��� ��︮��");
        }
        else if(s.equals("��.��.ȭ")) {
            bw.write("�ذ� ������ ����ϰ� ȭ���ϰ�");
        }
        else if(s.equals("��.��.��")) {
            bw.write("����ϰ� �Ƹ��ٿ� �̷��� ���Ͽ�");
        }
        else if(s.equals("��.��.��")) {
            bw.write("����ְ� �����ְ� ���������� ����");
        }
        else if(s.equals("��.��.��")) {
            bw.write("������� �� ���� �� ����");
        }
        else if(s.equals("��.��.��")) {
            bw.write("�����ǽ��� ���� �������� ���߰� �ڽ��ְ� ����");
        }
        else if(s.equals("��.��.��")) {
            bw.write("����, ����, �ڽ��� ������ ���Ͽ�");
        }
        else if(s.equals("��.��.��")) {
            bw.write("�̷� ��ȸ�� ���� ������");
        }
        else if(s.equals("û.��.��")) {
            bw.write("û���� �ٷ� ���ݺ���");
        }
        //bw.newLine();
        
        bw.flush();
    }
}