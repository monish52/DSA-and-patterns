import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StriverRandomClass {
    public static void main(String[] args) {
        // Scanner sc = new Scanner(System.in);
        // int n = sc.nextInt();
        ArrayList<String> abc = new ArrayList<>();
        abc.add("anb");
        abc.add("anb");
        abc.add("anb");
        abc.add("anb");
        int[]nums = {1,2,3,4,5};
        int b = nums.length;

        InnerStriverRandomClass sClass = new InnerStriverRandomClass();
        b = sClass.sumOfFirstAndLast(nums);
        // for (int i : nums) {
        //     System.out.print(i + " ");
        // }
        System.out.println(b);
        String abv = "abcd";
        abv.charAt(abv.length()-1);

        sClass.isAnagram("anagram", "nagaram");

        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> anagramList = sClass.groupAnagrams(strs);

        int[] ans = sClass.productExceptSelf(new int[]{1,2,3,4});
        for (int i : ans) {
            System.out.print(i + " ");
        }

    }
}
