import java.util.Scanner;

public class Stepik_Solution_6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String type = sc.nextLine();
        long a, b, c;
        switch (type){
            case "rectangle": a = sc.nextLong(); b = sc.nextLong();
                System.out.println(a * b); break;
            case "circle": a = sc.nextLong();
                System.out.println(a * a * 3.14); break;
            case "triangle": a = sc.nextLong(); b = sc.nextLong(); c = sc.nextLong();
                System.out.println(Math.sqrt(((a + b + c) / 2.0) * ((a + b + c) / 2.0 - a) * ((a + b + c) / 2.0 - b) *((a + b + c) / 2.0 - c)));
        }
    }
}
