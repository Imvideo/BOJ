import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ArrayList<Integer> queue = new ArrayList<Integer>();
        int n = Integer.parseInt(br.readLine());
        int head = 0;
        int tail = n;

        for (int i=1;i<=n;i++) {
            queue.add(i);
        }

        while(tail-head != 1){
            head++;
            if(tail-head == 1) break;
            else{
                queue.add(queue.get(head++));
                tail++;
            }
        }
        bw.write(queue.get(head)+"");
        bw.close();
    }
}