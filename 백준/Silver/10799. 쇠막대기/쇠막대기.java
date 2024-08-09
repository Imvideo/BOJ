import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int count = 0;
        int line=0;
        String input;
        String[] word;
        String top;
        Stack<String> stack = new Stack<String>();

        input = br.readLine();
        word = input.split("");
        for (String c : word) {
            stack.add(c);
        }
        while(!stack.isEmpty()) {
            top = stack.pop();
            if(!stack.isEmpty()) {
                if(top.equals(")") && stack.peek().equals(")")){
                    line++;
                }
                else if(top.equals(")") && stack.peek().equals("(")){
                    count+=line;
                    stack.pop();
                }
                else{
                    count++;
                    line--;
                }
            }
            else{
                count++;
                line--;
            }
        }
        
        bw.write(count+"\n");
        bw.flush();
        bw.close();
    }
}