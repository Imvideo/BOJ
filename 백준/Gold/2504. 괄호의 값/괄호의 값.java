import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int sum = 0;
        int mul = 1;
        String input;
        String[] word;
        boolean tag = true;
        Stack<String> stack = new Stack<String>();

        input = br.readLine();
        word = input.split("");
        for (int i=0; i<word.length; i++) {
            if(word[i].equals("(")){
                mul*=2;
                stack.push(word[i]);
            }
            else if(word[i].equals("[")){
                mul*=3;
                stack.push(word[i]);
            }
            else if(word[i].equals(")")){
                if(stack.isEmpty() || !stack.peek().equals("(")){
                    tag = false;
                    break;
                }
                if(word[i-1].equals("(")) sum += mul;
                stack.pop();
                mul /= 2;
            }
            else{
                if(stack.isEmpty() || !stack.peek().equals("[")){
                    tag = false;
                    break;
                }
                if(word[i-1].equals("[")) sum += mul;
                stack.pop();
                mul /= 3;
            }
        }
        if(stack.empty() && tag) bw.write(sum+"");
        else bw.write("0");
        
        bw.flush();
        bw.close();
    }
}