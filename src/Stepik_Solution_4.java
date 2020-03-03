import java.util.Scanner;

public class Stepik_Solution_4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int l = scan.nextInt();
        System.out.println( (l / 3600 % 24) + String.format(":%s",(l / 60 % 60) < 10 ? "0" : "") + (l / 60 % 60)
                + String.format(":%s",l % 60 < 10 ? "0" : "") + l % 60);
    }
}
