import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main{
    public static void main(String[] args){
        int[] arr = new int[1];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < arr.length; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
        } catch(IOException e){
            System.out.println("입력 오류");
        }
        if ((arr[0] %4==0 && arr[0] % 100 !=0)||arr[0] %400==0){
            System.out.print(1);
        } else {
            System.out.print(0);
        }
    }
}