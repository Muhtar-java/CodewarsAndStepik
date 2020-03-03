import java.util.ArrayList;

public class Solution17 {

        static String encode(String word) {
            char[] a = word.toCharArray();
            ArrayList<Integer> l = new ArrayList<>();
            for (int i = 0; i < a.length; i++)
                for (int p = 0; p < a.length; p++)
                    if (Character.toLowerCase(a[i]) == Character.toLowerCase(a[p]) && i != p)
                        l.add(i);
            for (int i = 0; i < a.length; i++)
                if (l.contains(i))
                    a[i] = ')';
                else
                    a[i] = '(';
            StringBuffer sf = new StringBuffer();
            for (char s : a)
                sf.append(s);
            return sf.toString();
        }

    public static void main(String[] args) {
        System.out.println(encode("Prespecialized"));
    }
}
