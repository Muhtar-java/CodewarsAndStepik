import java.util.ArrayList;

public class Solution10 {
        public static String expandedForm(int num)
        {
            ArrayList<Integer> d = new ArrayList<>();
            while(num > 0){
                d.add(num % 10);
                num /= 10;
            }
            StringBuffer str = new StringBuffer();
            for(int i = d.size() - 1; i > 0; i--){
                if(d.get(i) != 0)
                    str.append((int)(d.get(i) * Math.pow(10,i)) + " + ");
            }
            if(d.get(0) != 0)
                str.append(d.get(0));
            else {
                str.delete(str.length() - 3, str.length());
                System.out.println(str.length());
            }
            return str.toString();
        }

    public static void main(String[] args) {
        System.out.println(expandedForm(70000));
    }
}
