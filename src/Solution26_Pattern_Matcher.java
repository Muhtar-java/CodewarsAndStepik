import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution26_Pattern_Matcher {
    public Map<String, Double> m = new HashMap<>();

    public Double input(String input) {
            Deque<String> tokens = tokenize(input);
            String[] token = new String[tokens.size()];
            int i = 0;
            while(tokens.size() > 0){
                token[i] = tokens.pop();
                i++;
            }
            Pattern pat = Pattern.compile("[0-9]");
            Pattern pat2 = Pattern.compile("[A-Za-z_]");
            for(int n = 0; n < token.length; n++){
                switch(token[n]){
                    case "=": m.put(token[n-1],Double.parseDouble(token[n+1])); return m.get(token[n-1]);
                    case "+": if(pat.matcher(token[n-1]).find()&&pat.matcher(token[n+1]).find())
                        return Double.parseDouble(token[n-1])+Double.parseDouble(token[n+1]);
                        else if(pat2.matcher(token[n-1]).find()){
                            try{
                                m.replace(token[n-1],m.get(token[n-1]) + Double.parseDouble(token[n+1]));
                                return m.get(token[n-1]);
                            }
                            catch (NullPointerException e){
                                System.out.println( "ERROR: Invalid identifier. No variable with name " + token[n-1] +" was found.");
                                break;
                            }
                        }
                    case "-": if(pat.matcher(token[n-1]).find()&&pat.matcher(token[n+1]).find())
                        return Double.parseDouble(token[n-1])-Double.parseDouble(token[n+1]);
                        else if(pat2.matcher(token[n-1]).find()){
                        try{
                            m.replace(token[n-1],m.get(token[n-1]) - Double.parseDouble(token[n+1]));
                            return m.get(token[n-1]);
                        }
                        catch (NullPointerException e){
                            System.out.println( "ERROR: Invalid identifier. No variable with name " + token[n-1] +" was found.");
                            break;
                        }
                    }
                    case "*": if(pat.matcher(token[n-1]).find()&&pat.matcher(token[n+1]).find())
                        return Double.parseDouble(token[n+1])*Double.parseDouble(token[n-1]);
                        else if(pat2.matcher(token[n-1]).find()){
                        try{
                            m.replace(token[n-1],m.get(token[n-1]) * Double.parseDouble(token[n+1]));
                            return m.get(token[n-1]);
                        }
                        catch (NullPointerException e){
                            System.out.println( "ERROR: Invalid identifier. No variable with name " + token[n-1] +" was found.");
                            break;
                        }
                    }
                    case "/": if(pat.matcher(token[n-1]).find()&&pat.matcher(token[n+1]).find())
                        return Double.parseDouble(token[n-1])/Double.parseDouble(token[n+1]);
                        else if(pat2.matcher(token[n-1]).find()){
                        try{
                            m.replace(token[n-1],m.get(token[n-1]) / Double.parseDouble(token[n+1]));
                            return m.get(token[n-1]);
                        }
                        catch (NullPointerException e){
                            System.out.println( "ERROR: Invalid identifier. No variable with name " + token[n-1] +" was found.");
                            break;
                        }
                    }
                    case "%": if(pat.matcher(token[n-1]).find()&&pat.matcher(token[n+1]).find())
                        return Double.parseDouble(token[n-1])%Double.parseDouble(token[n+1]);
                        else if(pat2.matcher(token[n-1]).find()) {
                        try {
                            m.replace(token[n - 1], m.get(token[n - 1]) % Double.parseDouble(token[n + 1]));
                            return m.get(token[n - 1]);
                        } catch (NullPointerException e) {
                            System.out.println("ERROR: Invalid identifier. No variable with name " + token[n - 1] + " was found.");
                            break;
                        }
                    }
                    default: if(pat2.matcher(token[n]).find() && token.length == 1) {
                            if(m.containsKey(token[n]))
                                return m.get(token[n]);
                            else
                                throw new NullPointerException("input: '" + token[n] + "'");
                    }
                }
            }
            return 0d;
        }

        private static Deque<String> tokenize(String input) {
            Deque<String> tokens = new LinkedList<>();
            Pattern pattern = Pattern.compile("=>|[-+*/%=\\(\\)]|[A-Za-z_][A-Za-z0-9_]*|[0-9]*(\\.?[0-9]+)");
            Matcher m = pattern.matcher(input);
            while (m.find()) {
                tokens.add(m.group());
            }
            return tokens;
        }

    public static void main(String[] args) {
        Solution26_Pattern_Matcher a = new Solution26_Pattern_Matcher();
        //System.out.println(a.input("1 + 1"));
        //System.out.println(a.input("2 - 1"));
        //System.out.println(a.input("2 * 3"));
        //System.out.println(a.input("8 / 4"));
        //System.out.println(a.input("7 % 4"));
        System.out.println(a.input("x = 1"));
        System.out.println(a.input("x"));
        System.out.println(a.input("x + 3"));
        System.out.println(a.input("y"));
    }
}
