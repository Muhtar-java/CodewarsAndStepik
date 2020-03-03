import java.util.ArrayList;
import java.util.Arrays;

public class Solution4 {
        public static boolean isValid(String braces) {
            ArrayList<Character> c =  new ArrayList<Character>();
            for(char a: braces.toCharArray())
                c.add(a);
            int i = 0;
            while(i < c.size()) {
                if(c.get(i) == ']' && c.get(i-1) == '['){
                        c.remove(i);
                        c.remove(i-1);
                        i--;
                        continue;
                    }
                if(c.get(i) == ')' && c.get(i-1) == '('){
                        c.remove(i);
                        c.remove(i-1);
                        i--;
                        continue;
                    }
                if(c.get(i) == '}' && c.get(i-1) == '{'){
                        c.remove(i);
                        c.remove(i-1);
                        i--;
                        continue;
                    }
                i++;
            }
            if (c.size() == 0)
                return true;
            return false;
        }

    public static void main(String[] args) {
        String s = "{}[]({})";
        System.out.println(isValid(s));
    }
}
