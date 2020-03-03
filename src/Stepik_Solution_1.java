import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Stepik_Solution_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] sets = reader.readLine().split(";");

        Set<Integer> set1 = new HashSet<>();
        String[] a1 = sets[0].split(" ");
        for(String b: a1)
            set1.add(Integer.valueOf(b));

        Set<Integer> set2 = new HashSet<>();
        String[] a2 = sets[1].split(" ");
        for(String b: a2)
            set2.add(Integer.valueOf(b));

        Set<Integer> set3 = new HashSet<>();
        String[] a3 = sets[2].split(" ");
        for(String b: a3)
            set3.add(Integer.valueOf(b));

        Set<Integer> resultTreeSet = unionTreeLargeNumber(set1,set2,set3);

        for(Integer k: resultTreeSet)
            System.out.println(k);

    }

    public static TreeSet<Integer> unionTreeLargeNumber(Set<Integer> set1, Set<Integer> set2, Set<Integer> set3){
        TreeSet<Integer> resultSet = new TreeSet<>();
        NavigableSet<Integer> resSet;
        int max = 0;
        for(Integer a: set1)
            if(max < a)
                max = a;
        resultSet.add(max);
        max = 0;
        for(Integer a: set2)
            if(max < a)
                max = a;
        resultSet.add(max);
        max = 0;
        for(Integer a: set3)
            if(max < a)
                max = a;
        resultSet.add(max);
        resultSet = (TreeSet<Integer>) resultSet.descendingSet();
        return resultSet;
    }
}
