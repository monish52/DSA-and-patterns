public class Palindrome {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        // isPalindrome(121) ? System.out.println("This is a palindrome"): System.out.println("This is not a palindrome");
        // int num = -10;
        // if(isPalindrome(num)){
        //     System.out.println("This is a palindrome");
        //         System.out.println(num);
        // }else{
        //     System.out.println("This is not a palindrome");
        //     System.out.println(num);
        // }
        // System.out.println(getGCD(40, 20));
        System.out.println(isArmStrong(1634));
    }

    public static boolean isPalindrome(int x){
        if (x == 0){
            return false;
        }
        int dupNumber = x;
        int palindromeString = 0;
        // for (int i = 0; i < Integer.toString(x).length(); i++) {
        //     int lastDigit = dupNumber%10;
        //     dupNumber = dupNumber / 10;
        //     palindromeString = palindromeString * 10 + lastDigit;
        // }
        while (dupNumber > 0){
            int lastDigit = dupNumber % 10;
            palindromeString = palindromeString * 10 + lastDigit;
            dupNumber = dupNumber / 10;
        }
        return palindromeString == x;
    }

    public static int getGCD(int num1, int num2){
        int gcd = 1;
        for (int i = 1; i <= Math.min(num1, num2); i++) {
            gcd = (num1 % i == 0 && num2 % i == 0) ? Math.max(gcd, i): gcd;
        }

        return gcd;
    }

    public static boolean isArmStrong(int n){
        int dupNumber = n;
        int palindromeCheck = 0;
        while (dupNumber > 0) {
            int lastDigit = dupNumber % 10;
            palindromeCheck = palindromeCheck + lastDigit * lastDigit * lastDigit;
            dupNumber = dupNumber / 10;
        }
        return palindromeCheck == n;
    }
}
