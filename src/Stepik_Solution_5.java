import java.util.Scanner;

public class Stepik_Solution_5 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int h = scan.nextInt(), a = scan.nextInt(), b = scan.nextInt(), max = 0, day = 1;
        max += a;
        while(max < h){
            max -= b;
            max += a;
            day++;
        }
        System.out.println(day);
    }
}
