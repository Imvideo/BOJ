import java.util.Scanner;

class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n,x;
        n = scanner.nextInt();
        x = scanner.nextInt();

        int[] arr = new int[n];

        for(int i=0;i<n;i++){
            arr[i] = scanner.nextInt();
            if(arr[i]<x) {
                System.out.print(arr[i]+" ");
            }
        }
    }
}