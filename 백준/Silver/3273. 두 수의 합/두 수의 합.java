import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    static int n,x,num,count=0;
    static int sumarr[] = new int[2000001];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int arr[] = new int[100001];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        x = Integer.parseInt(br.readLine());

        for(int i=0;i<n;i++){
            if(arr[i]>=x) {
                continue;
            }
            if(sumarr[x-arr[i]]==1) {
                count++;
            }
            sumarr[arr[i]]++;
        }
        
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(count));
        bw.close();
}
}