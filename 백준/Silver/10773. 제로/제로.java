import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.Stack;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Integer> stack = new Stack<>();
        int k = Integer.parseInt(br.readLine());
        int sum = 0;

        for(int i=0; i<k; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            
            if(num == 0) stack.pop();
            else{
                stack.push(num);
            }
        }
        for (int n : stack){
            sum += n;
        }
        bw.write(sum+"");
        bw.close();
    }
}