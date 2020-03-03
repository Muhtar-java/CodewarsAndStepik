import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution26_2 {
    public Map<String, Double> m = new HashMap<>();

    public Double input(String input) {
        Deque<String> tokens = tokenize(input);
        ArrayList<String> s = new ArrayList<>();
        double d = 1;
        Pattern pat = Pattern.compile("[A-Za-z_]");
        Pattern pat2= Pattern.compile("[0-9]");
        while (!tokens.isEmpty())
            s.add(tokens.pop());
        if(s.size() == 0)
            return null;
        if (pat.matcher(s.get(0)).find() && s.size() == 1){
            if(m.containsKey(s.get(0))) {
                return m.get(s.get(0));
            } else{
                throw new NullPointerException("input: '" + s.get(0) + "'");
            }
        }
        while(s.contains("(")){
            for(int i = s.lastIndexOf("("); i < s.lastIndexOf(")"); i++)
                switch(s.get(i)){
                    case "*": s = remov(s, i, false, Operator.MULTIPLICATION); i--; break;
                    case "/": s = remov(s, i, false, Operator.DIVISION); i--; break;
                    case "%": s = remov(s, i, false, Operator.PERCENTATION); i--; break;
                }
            for(int i = s.lastIndexOf("("); i < s.lastIndexOf(")"); i++)
                switch(s.get(i)){
                    case "+": s = remov(s, i, true, Operator.ADDITION); i--; break;
                    case "-": s = remov(s, i, true, Operator.SUBTRACTION); i--; break;
                }
            s.remove(s.lastIndexOf("("));
            s.remove(s.lastIndexOf(")"));
            System.out.println(s);
        }
        for(int i = 1; i < s.size(); i++)
            switch(s.get(i)){
                case "*": s = remov(s, s.indexOf("*"), false, Operator.MULTIPLICATION); i--; break;
                case "/": s = remov(s, s.indexOf("/"), false, Operator.DIVISION); i--; break;
                case "%": s = remov(s, s.indexOf("%"), false, Operator.PERCENTATION); i--; break;
            }
        for(int i = 1; i < s.size(); i++)
            switch(s.get(i)){
                case "+": s = remov(s, s.indexOf("+"), true, Operator.ADDITION); i--; break;
                case "-": s = remov(s, s.indexOf("-"), true, Operator.SUBTRACTION); i--; break;
            }
        if (s.contains("=")) {
            m.put(s.get(s.indexOf("=") - 1), Double.parseDouble(s.get(s.indexOf("=") + 1)));
            s.remove(s.indexOf("=") - 1);
            s.remove(s.indexOf("="));
        }
        if(s.size() == 1)
            return Double.parseDouble(s.get(0));
        return null;
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

    public ArrayList<String> remov(ArrayList<String> s, int i, boolean t, Operator op){
        Pattern pat = Pattern.compile("[A-Za-z_]");
        double d = 1;
        if(t && i > 2)
            d = s.get(i - 2).equals("-") ? -1 : 1;
        try {
            if (pat.matcher(s.get(i - 1)).find())
                s.set(i - 1,String.valueOf(op.apply(d * m.get(s.get(i - 1)), Double.parseDouble(s.get(i + 1)))));
            else if (pat.matcher(s.get(i + 1)).find())
                s.set(i - 1,String.valueOf(op.apply(d * Double.parseDouble(s.get(i - 1)), m.get(s.get(i + 1)))));
            else if (!pat.matcher(s.get(i + 1)).find() && !pat.matcher(s.get(i - 1)).find())
                s.set(i - 1,String.valueOf(op.apply(d * Double.parseDouble(s.get(i - 1)), Double.parseDouble(s.get(i + 1)))));
            else
                s.set(i - 1,String.valueOf(op.apply(d * m.get(s.get(i - 1)), m.get(s.get(i + 1)))));
            s.set(i - 1, String.valueOf(Double.parseDouble(s.get(i - 1)) * d));
            d = 1;
            s.remove(i + 1);
            s.remove(i);
        } catch (NullPointerException e) {
            throw new NullPointerException("ERROR: Invalid identifier. No variable was found.");
        }
        return s;
    }
    public enum Operator
    {
        ADDITION("+") {
            @Override public double apply(double x1, double x2) {
                return x1 + x2;
            }
        },
        SUBTRACTION("-") {
            @Override public double apply(double x1, double x2) {
                return x1 - x2;
            }
        },
        DIVISION("/"){
            @Override public  double apply(double x1, double x2){
                return x1 / x2;
            }
        },
        MULTIPLICATION("*"){
            @Override public  double apply(double x1, double x2){
                return x1 * x2;
            }
        },
        PERCENTATION("%"){
            @Override public double apply(double x1, double x2){
                return  x1 % x2;
            }
        };

        private final String text;

        private Operator(String text) {
            this.text = text;
        }

        public abstract double apply(double x1, double x2);

        @Override public String toString() {
            return text;
        }
    }
    public String calculate(Operator op, double x1, double x2)
    {
        return String.valueOf(op.apply(x1, x2));
    }

    public static void main(String[] args) {
        Solution26_2 k = new Solution26_2();
        System.out.println(k.input("1 2"));
        System.out.println(k.input("1"));
        //System.out.println(k.input("y = x * 3 + 1"));
        //System.out.println(k.input("x = 4"));
        //System.out.println(k.input("y = x * 7"));
        //System.out.println(k.input("y * 2"));
        //System.out.println(k.input("z"));
        //System.out.println(k.calculate(Operator.ADDITION,2,3));
    }
}
