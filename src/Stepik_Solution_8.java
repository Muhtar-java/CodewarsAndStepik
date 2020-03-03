import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/*
The set of strings is given.

Set<String> nameSet = new TreeSet<>(Arrays.asList("Mr.Green", "Mr.Yellow", "Mr.Red"));

Output each its element in the loop with a new line.
 */
public class Stepik_Solution_8 {

    public static void main(String[] args) {
        Set<String> nameSet = new TreeSet<>(Arrays.asList("Mr.Green", "Mr.Yellow", "Mr.Red"));
        Iterator<String> it = nameSet.iterator();
        while(it.hasNext())
            System.out.println(it.next());
        for(String a: nameSet)
            System.out.println(a);
    }
}
