import java.util.Scanner;

public class Stepik_Solution_3 {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        int max = 0, n = read.nextInt(), a;
        for(int i = 0; i < n; i++){
            a = read.nextInt();
            if(a % 4 == 0 && max < a)
                max = a;
        }
        System.out.println(max);
    }
}
