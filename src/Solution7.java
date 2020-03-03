public class Solution7 {
        public static String camelCase(String str) {
            char[] a = str.toCharArray();
            a[0] = Character.toUpperCase(a[0]);
            for(int i = 0; i < a.length; i++)
                if(a[i] == ' ')
                    a[i+1] = Character.toUpperCase(a[i+1]);
            StringBuffer sb = new StringBuffer();
            for(char c: a)
                if(c != ' ')
                    sb.append(c);
            return sb.toString();
        }
}
