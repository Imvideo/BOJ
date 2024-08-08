import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int count = 0;
        String input;
        String[] word;
        Stack<String> stack = new Stack<String>();
        boolean tag = true;

        for(int i=0; i<n; i++){
            input = br.readLine();
            stack = new Stack<String>();
            word = input.split("");
            for(String c : word){
                if(!stack.isEmpty() && stack.peek().equals(c)){
                    stack.pop();
                }
                else {
                    stack.add(c);
                }
            }
            if(stack.isEmpty()) count++;
        }
        bw.write(count+"\n");
        bw.flush();
        bw.close();
    }
}