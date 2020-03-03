public class Solution2 {
        public static int bouncingBall(double h, double bounce, double window) {
            if(h > 0 && bounce > 0 && bounce < 1 && window == 1.5 && h > window){
                double hw = h * bounce;
                int sum = 1;
                while(window < hw){
                    sum += 2;
                    hw = hw * bounce;
                }
                return sum;
            }
            else
                return -1;
        }

    public static void main(String[] args) {
        double h = 10, bounce = 0.66, window = 1.5;
        System.out.println(bouncingBall(h,bounce,window));
    }
}
