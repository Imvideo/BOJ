import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n;
        int arr[] = new int[1002];
        n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++){
            int num = Integer.parseInt(br.readLine());
            arr[i] = num;
        }
        Arrays.sort(arr, 0, n);
        for(int i=0; i<n; i++){
            bw.write(arr[i]+"\n");
        }
        bw.flush();
        bw.close();
    }
}