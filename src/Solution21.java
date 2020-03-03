import java.util.Arrays;

public class Solution21 {


    public static void main(String[] args) {
        String[] g = {"Hello","I","am","Rayan,","to,","be","may","be"};
        String[] j = new String[g.length];
        int i = 0;
        for(String h: g)
        {
            j[i] = h.toLowerCase();
            j[i] = j[i].replaceAll(",","");
            i++;
        }
        Arrays.sort(j);
        for(String h: j)
            System.out.println(h.toLowerCase());
    }
}
