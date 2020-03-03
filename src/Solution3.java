public class Solution3 {
        public static String makeComplement(String dna) {
            char[] c = dna.toCharArray();
            for(int i = 0; i < c.length; i++){
                if(c[i] == 'A')
                    c[i] = 'T';
                else if(c[i] == 'T')
                        c[i] = 'A';
                    else if(c[i] == 'C')
                            c[i] = 'G';
                        else if (c[i] == 'G')
                                c[i] = 'C';
            }
            String s = new String(c);
            return s;
        }

    public static void main(String[] args) {
        String name = "ATTAGCCG[G]";
        System.out.println(makeComplement(name));
    }
}
