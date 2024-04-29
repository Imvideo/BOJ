import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    static String n;
    static int arr[] = new int[10];
    public static void main(String[] args) throws IOException{
        int max=0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = br.readLine();

        for(int i=0;i<n.length();i++){
            if(n.charAt(i)=='6'||n.charAt(i)=='9'){
                arr[6]++;
            }
            else{
                arr[n.charAt(i)-'0']++;
            }
        }
        arr[6]= (arr[6]+1)/2;
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < arr.length; i++){
            if(max<arr[i]) max=arr[i];
        }
        bw.write(String.valueOf(max));
        bw.close();
}
}