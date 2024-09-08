import java.io.*;
import java.util.*;

public class Main{
    static Long a;
    static Long b;
    static Long c;

    static public Long func(Long a, Long b, Long c){
        if(b == 1) return a % c;
        Long val = func(a,b/2,c);
        val = val * val % c;
        if(b % 2 == 0) return val;
        return val * a % c;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Long.parseLong(st.nextToken());
        b = Long.parseLong(st.nextToken());
        c = Long.parseLong(st.nextToken());

        bw.write(func(a,b,c)+"");
        bw.flush();
        bw.close();
    }
}