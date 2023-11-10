import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main{
    public static void main(String[] args){
        int[] arr = new int[3];
        int reward;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < arr.length; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
        } catch(IOException e){
            System.out.println("입력 오류");
        }
        if(arr[0] == arr[1] && arr[0] == arr[2] && arr[1] == arr[2]) {
            reward = 10000 + arr[0] * 1000;
        }
        else if (arr[0] != arr[1] && arr[0] != arr[2] && arr[1] != arr[2]){
            Arrays.sort(arr);
            reward = arr[2] * 100;
        }
        else {
            if (arr[0] == arr[1]){
                reward = 1000 + arr[0] * 100;
            }
            else {
                reward = 1000 + arr[2] * 100;
            }
        }
        System.out.print(reward);
    }
}