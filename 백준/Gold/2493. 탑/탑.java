import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Stack;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<int[]> stack = new Stack<>();
        int n = Integer.parseInt(br.readLine());
        int top;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++){
            top = Integer.parseInt(st.nextToken());

            while(!stack.isEmpty()){
                if(stack.peek()[1] >= top){
                    bw.write(stack.peek()[0]+" ");
                    break;
                }
                stack.pop();
            }

            if(stack.isEmpty()){
                bw.write("0 ");
            }
            stack.push(new int[]{i, top});
        }
        bw.close();
    }
}