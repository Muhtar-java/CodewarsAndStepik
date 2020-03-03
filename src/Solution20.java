public class Solution20 {
    public static String interpreter(String code, int iterations, int width, int height) {
        char[] a = code.toCharArray();
        int[][] data = new int[height][width];
        int w = 0, h = 0, count = 0;
        for(int i = 0; i < iterations && count < a.length; i++)
            switch(a[count]){
                case 'e': h++; if(h == width) h = 0; count++; break;
                case 'w': h--; if(h == -1) h = width - 1; count++; break;
                case 's': w++; if(w == height) w = 0; count++; break;
                case 'n': w--; if(w == -1) w = height - 1; count++; break;
                case '[': if(data[w][h] == 0) while(a[count] != ']') {
                    count++; if(count == a.length) count = 0; } count++; break;
                case ']': if(data[w][h] == 1) while(a[count] != '[') {
                    count++; if(count == a.length) count = 0; } count++; break;
                case '*': if(data[w][h] == 1) data[w][h] = 0; else data[w][h] = 1; count++; break;
                default: count++; i--;
            }
        StringBuilder result = new StringBuilder();
        for(int[] i : data) {
            for (int d : i)
                result.append(d);
            result.append("\r\n");
        }
        result.deleteCharAt(result.length() - 1);
        result.deleteCharAt(result.length() - 1);
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(interpreter("*[es*]",37,5,6));
    }
}
