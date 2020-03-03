import java.util.Stack;

public class Solution13 {
        public static String[] dirReduc(String[] arr) {
            Stack<String> s = new Stack<>();
            for (String value : arr)
                switch (value) {
                    case "WEST":
                        if (s.empty() || !s.peek().equals("EAST")) s.push(value);
                        else s.pop();
                        break;
                    case "EAST":
                        if (s.empty() || !s.peek().equals("WEST")) s.push(value);
                        else s.pop();
                        break;
                    case "SOUTH":
                        if (s.empty() || !s.peek().equals("NORTH")) s.push(value);
                        else s.pop();
                        break;
                    case "NORTH":
                        if (s.empty() || !s.peek().equals("SOUTH")) s.push(value);
                        else s.pop();
                        break;
                }
            String[] a = new String[s.size()];
            int i = 0;
            for(String g: s) {
                a[i] = g;
                i++;
            }
            return a;
        }

    public static void main(String[] args) {
        String[] s = (dirReduc(new String[]{"NORTH","SOUTH","SOUTH","EAST","WEST","NORTH"}));
        for(String c: s)
            System.out.println(c);
    }
}
