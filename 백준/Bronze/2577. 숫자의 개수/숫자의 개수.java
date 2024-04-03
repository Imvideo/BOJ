import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    static int a,b,c,result,tmp;
    static int[] arr = new int[10];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        a = Integer.parseInt(br.readLine());
        b = Integer.parseInt(br.readLine());
        c = Integer.parseInt(br.readLine());

        result = a * b * c;
        while(true){
            if(result/10 == 0 && result % 10 == 0) break;
            else {
                tmp = result % 10;
                arr[tmp]++;
                result /= 10;
            }
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < arr.length; i++){
            bw.write(arr[i]+"\n");
        }
        bw.close();
}
}