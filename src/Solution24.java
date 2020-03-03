public class Solution24 {
    public static int parseInt(String numStr) {
        String[] nums = numStr.split("[\\s-]");
        int[] sum = new int[nums.length];
        int c = 0, k = 0, j = 0;
        for(int i = 0; i < nums.length; i++){
            switch (nums[i].toLowerCase()){
                case "zero" : sum[c] = 0; c++; break;
                case "one" : sum[c] = 1; c++; break;
                case "two" : sum[c] = 2; c++; break;
                case "three" : sum[c] = 3; c++; break;
                case "four" : sum[c] = 4; c++; break;
                case "five" : sum[c] = 5; c++; break;
                case "six" : sum[c] = 6; c++; break;
                case "seven" : sum[c] = 7; c++; break;
                case "eight" : sum[c] = 8; c++; break;
                case "nine" : sum[c] = 9; c++; break;
                case "ten" : sum[c] = 10; c++; break;
                case "eleven" : sum[c] = 11; c++; break;
                case "twelve" : sum[c] = 12; c++; break;
                case "thirteen" : sum[c] = 13; c++; break;
                case "fourteen" : sum[c] = 14; c++; break;
                case "fifteen" : sum[c] = 15; c++; break;
                case "sixteen" : sum[c] = 16; c++; break;
                case "seventeen" : sum[c] = 17; c++; break;
                case "eighteen" : sum[c] = 18; c++; break;
                case "nineteen" : sum[c] = 19; c++; break;
                case "twenty" : sum[c] = 20; c++; break;
                case "thirty" : sum[c] = 30; c++; break;
                case "forty" : sum[c] = 40; c++; break;
                case "fifty" : sum[c] = 50; c++; break;
                case "sixty" : sum[c] = 60; c++; break;
                case "seventy" : sum[c] = 70; c++; break;
                case "eighty" : sum[c] = 80; c++; break;
                case "ninety" : sum[c] = 90; c++; break;
                case "hundred" : sum[c-1] *= 100; break;
                case "thousand" :k = j; while(k < c) {sum[k] *= 1000; k++;} j = c; break;
                case "million" : sum[c-1] *= 1000000; break;
            }
        }
        int fuh = 0;
        for(int i = 0; i < c; i++)
            fuh += sum[i];
        return fuh;
    }

    public static void main(String[] args) {
        System.out.println(parseInt("one hundred twenty six thousand three hundred fifty nine"));
    }
}
