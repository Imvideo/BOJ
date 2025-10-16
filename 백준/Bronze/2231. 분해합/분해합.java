import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n,num=1;
        n = Integer.parseInt(br.readLine());
        while(true){
            int tmpNum=num, sum=num;
            while(tmpNum != 0){
                sum += tmpNum%10;
                tmpNum/=10;
            }
            if(sum == n){
                bw.write(num+"");
                break;
            }
            if(num > n){
                bw.write(0+"");
                break;
            }
            num++;
        }
        bw.flush();
        bw.close();
    }
}