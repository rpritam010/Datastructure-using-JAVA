package leetCode;

public class ReverseOfInteger {

    public static void main(String[] args) {
        ReverseOfInteger reverseOfInteger = new ReverseOfInteger();
        int result = reverseOfInteger.reverse(123);
        System.out.println(result); // Output: 321

        result = reverseOfInteger.reverse(-123);
        System.out.println(result); // Output: -321

        result = reverseOfInteger.reverse(120);
        System.out.println(result); // Output: 21
    }

    public int reverse(int x){

        int reverse =0;
        while(x !=0){

            int pop = x%10;

            x= x/10;

            if(reverse >Integer.MAX_VALUE /10 || (reverse == Integer.MAX_VALUE /10 && pop >7)) return 0;
            if(reverse <Integer.MIN_VALUE /10 || (reverse == Integer.MIN_VALUE /10 && pop <-8)) return 0;

            reverse = (reverse * 10) + pop;

        }
        return reverse;

    }
}
