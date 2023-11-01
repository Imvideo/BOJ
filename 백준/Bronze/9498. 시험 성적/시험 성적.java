import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Main{
    public static void main(String[] args){
        int a=0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            a = Integer.parseInt(br.readLine());
        } catch(IOException e){
            System.out.println("입력 오류");
        }
        if (a >= 90) System.out.print("A");
        else if (a >= 80) System.out.print("B");
        else if (a >= 70) System.out.print("C");
        else if (a >= 60) System.out.print("D");
        else System.out.print("F");
    }
}