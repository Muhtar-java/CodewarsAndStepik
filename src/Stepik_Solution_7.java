import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Stepik_Solution_7 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,3,45,2,21,12,1);
        long val = numbers.stream().collect(Collectors.reducing(1L, x -> Long.valueOf(x),(x, y) -> x * (long)Math.pow(y,2)));
        System.out.println(val);
    }
}
