package com.suku.array;

public class ReverseInteger {
    public static int reverse(int x) {
        //int length = (int) (Math.log10(x)+1);
       // if(length<2) return x;
        int rev =0;
        while(x != 0) {
            int pop = x%10;
            //max and min integer check
            if(rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE/10 && pop > 7))
                return 0;
            if(rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE/10 && pop < -8))
                return 0;
            x = x/10;
            rev = rev*10 + pop;
            System.out.println(pop);
        }
        return rev;
    }
    public static void main(String[] args) {
        System.out.println(reverse(Integer.MIN_VALUE));
    }
}
