import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * InnerStriverRandomClass
 */
public class InnerStriverRandomClass {

    public int sumOfFirstAndLast(int[] nums) {
        return nums.length == 0 ? 0 : nums[0] + nums[nums.length-1];
    }

    HashSet<String> cars = new HashSet<String>();
    HashSet<Integer> cars2 = new HashSet<Integer>();
    String abc = "accasa";
    char c = 'c';
    String abc2 = abc+c;
    
    public String longestCommonPrefix(String[] strs) {
        String prefix = "";
        for(int i=0;i<strs[0].length();i++)
        {
            char a=strs[0].charAt(i);
            boolean isMatch = true;

            for(int j=1;j<strs.length;j++)
            {
                if(strs[j].length() <= i || strs[j].charAt(i) != a)
                {
                    isMatch = false;
                    break;
                }
            }
            if(isMatch)
            {
                prefix = prefix+a;
            }
            else
            {
                break;
            }
        }
        return prefix;
    }

    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> charCount = new HashMap<>();
        StoreCountinHashMap(s, charCount);

        for (Character c : t.toCharArray())
        {
            if(!charCount.containsKey(c))
            {
                return false;
            }
            charCount.put(c, charCount.get(c) -1);
            if(charCount.get(c) == 0);
            {
                charCount.remove(c);
            }
        }
        return charCount.isEmpty();
    }

    private void StoreCountinHashMap(String s, HashMap<Character, Integer> charCount) {
        for (Character c : s.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }
    }

    public int[] twoSum(int[] nums, int target) {
        int[] sum = new int[]{0,0};
        for(int i=0;i<nums.length;i++)
        {
            for(int j=0;j<nums.length;j++)
            {
                if( nums[i] + nums[j] == target)
                {
                    sum =new int[] {nums[i], nums[j]};
                    return sum;
                }
            }
        }

        return sum;
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length == 0)
        {
            return new ArrayList<List<String>>();
        }
        List<List<String>> finalAnagramList = new ArrayList<List<String>>();
        HashMap<String, List<String>> keyValueHashMap= new HashMap<>();
        for (String eleString : strs) {
            String sortedString = sortString(eleString);
            List<String> valueArr = keyValueHashMap.get(sortedString);
            if (valueArr == null)
            {
                valueArr = new ArrayList<String>();
                keyValueHashMap.put(sortedString, valueArr);
            }
            valueArr.add(eleString);
            keyValueHashMap.put(sortedString, valueArr);
        }
        for (List<String> anagramArrList : keyValueHashMap.values()) {
            finalAnagramList.add(anagramArrList);
        }

        return finalAnagramList;
    }

    private String sortString(String eleString) {
        char tempArray[] = eleString.toCharArray();
        Arrays.sort(tempArray);
        return new String(tempArray);
    }

    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> numWithFreqMap = new HashMap<>();
        for (int no : nums) {
            numWithFreqMap.put(no, numWithFreqMap.getOrDefault(no, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        for (Map.Entry<Integer,Integer> entry : numWithFreqMap.entrySet()) {
            pq.add(entry);
        }
        int[] finalRes = new int[k];
        for (int i = 0; i < finalRes.length; i++) {
            finalRes[i] = pq.poll().getKey();
        }

        return finalRes;
    }

    public int[] productExceptSelf(int[] nums) {
        int totalProduct = 1;
        int[] ansArr = new int[nums.length];
        for(int num: nums){
            totalProduct*=num;
        }
        for (int i = 0; i < nums.length; i++) {
            ansArr[i]=totalProduct/nums[i];
        }
        return ansArr;
    }

    public int[] productExceptSelfOpt(int[] nums) {
        int[] ans = new int[nums.length];
        ans[0]=1;
        for (int i = 1; i < ans.length; i++) {
            ans[i] = ans[i-1]*nums[i-1];
        }
        int postfix = 1;
        for (int i = nums.length - 1; i > 0; i--) {
            ans[i] = ans[i] * postfix;
            postfix = postfix * nums[i];
        }
        return ans;
    }

    public int secondMostFrequentElement(int[] nums) {
        HashMap<Integer, Integer> numWithFreqMap = new HashMap<>();
        int maxFreqCount = -1;
        int maxFreqNum = -1;
        int secondMaxFreqCount = -1;
        int secondMaxFreqNum = -1;
        for (int no: nums){
            numWithFreqMap.put(no, numWithFreqMap.getOrDefault(no, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry: numWithFreqMap.entrySet()){
            int key = entry.getKey();
            int value = entry.getValue();

            if (value > maxFreqCount){
                secondMaxFreqCount = maxFreqCount;
                secondMaxFreqNum = maxFreqNum;
                maxFreqCount = value;
                maxFreqNum = key;
            }

            else if (value > secondMaxFreqCount){
                secondMaxFreqCount = value;
                secondMaxFreqNum = key;
            }

            if(value == secondMaxFreqCount)
            {
                secondMaxFreqNum = Math.min(key, secondMaxFreqNum);
            }
        }

        return secondMaxFreqNum;
    }

    public boolean isValidSudoku(char[][] board) {
        HashMap<Integer, ArrayList<Character>> rows = new HashMap<Integer, ArrayList<Character>>();
        HashMap<Integer, ArrayList<Character>> cols = new HashMap<Integer, ArrayList<Character>>();
        HashMap<Integer, ArrayList<Character>> squares = new HashMap<Integer, ArrayList<Character>>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                int squareNo = (i/3) + (j/3) * 3;
                if (Character.valueOf(board[i][j]) == '.')
                {
                    continue;
                }
                if (rows.computeIfAbsent(i, f -> new ArrayList<Character>()).contains(Character.valueOf(board[i][j])) ||
                    cols.computeIfAbsent(j, f -> new ArrayList<Character>()).contains(Character.valueOf(board[i][j])) ||
                    squares.computeIfAbsent(squareNo, f -> new ArrayList<Character>()).contains(Character.valueOf(board[i][j])))
                {
                    return false;
                }
                rows.computeIfAbsent(i, f -> new ArrayList<Character>()).add(Character.valueOf(board[i][j]));
                cols.computeIfAbsent(j, f -> new ArrayList<Character>()).add(Character.valueOf(board[i][j]));
                squares.computeIfAbsent(squareNo, f -> new ArrayList<Character>()).add(Character.valueOf(board[i][j]));
            }
        }

        return true;
    }

    public int longestConsecutive(int[] nums) {
        HashSet<Integer> numSet = new HashSet<>();
        for (int num: nums) {
            numSet.add(num);
        }
        int longestSeq = 0;
        for (int num: numSet) {
            int length = 0;
            if (!numSet.contains(num - 1)) {
                length = 1;
                int counter = 1;
                while (numSet.contains(num + counter)) {
                    length++;
                    counter++;
                }
                longestSeq = Math.max(length, longestSeq);
            }
        }
        return longestSeq;
    }

    public int countCollisionsWrong(String directions) {
        char[] dirList = directions.toCharArray();
        int counter = 0;
        boolean right = false;
        boolean left = false;
        boolean stationary = false;

        for(char direction : dirList){
            if (right && direction == 'L'){
                counter += 2;
                right = false;
                stationary = true;
            }
            else if (stationary && direction == 'L'){
                counter++;
            }
            else if (right && direction == 'S'){
                counter++;
                right = false;
                stationary = true;
            }
            else if (direction == 'R'){
                right = true;
            }
            else if (direction == 'L'){
                left = true;
            }
            else if (direction == 'R'){
                stationary = true;
            }
        }

        return counter;
    }

    public int countCollisions(String directions) {
        char[] dirList = directions.toCharArray();

        int start = 0;
        int end = dirList.length - 1;
        for(int i=0;i<dirList.length;i++){
            if (start == end || dirList[start] == 'R' || dirList[end] == 'L'){
                break;
            }
            if (dirList[i] == 'L'){
                start = i;
            }
            if (dirList[dirList.length - i - 1] == 'R'){
                end = dirList.length - i - 1;
            }
        }
        return 1;
    }

    public int countTriples(int n) {
        HashMap<Integer, Integer> sqHashMap = new HashMap<>();
        int counter = 0;

        if (n == 0 || n == 1 || n == 2){
            return 0;
        }
        for (int i = 1; i <= n; i++) {
            sqHashMap.put(i*i, i);
        }
        for (int i = 1; i <= n; i++) {
            int abSqValue = (i*i) + (i+1)*(i+1);
            if (sqHashMap.get(abSqValue) != null){
                counter++;
            }
        }

        return counter;
    }

    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        ArrayList<Integer> indexes = new ArrayList<Integer>();
        for (int i = 0; i< code.length; i++){
            if (code[i].chars().allMatch((ch) -> Character.isLetterOrDigit(ch) || ch == '_') &&
                !code[i].isBlank() &&
                (businessLine[i].equals("electronics") || businessLine[i].equals("grocery") || businessLine[i].equals("pharmacy") || businessLine[i].equals("restaurant")) &&
                isActive[i]){
                indexes.add(i);
            }
        }
        indexes.sort((Integer a,Integer b) -> {
            int comp = businessLine[a].compareTo(businessLine[b]);
            if (comp == 0){
                return code[a].compareTo(code[b]);
            }else{
                return comp;
            }
        });

        ArrayList<String> ans = new ArrayList<String>();
        for (int index : indexes) {
            ans.add(code[index]);
        }

        return ans;
    }

    public int numberOfWays(String corridor) {
        int mod = 1_000_000_007;
        ArrayList<Integer> seatCount = new ArrayList<>();
        for (int i = 0; i < corridor.length(); i++) {
            if (corridor.charAt(i) == 's'){
                seatCount.add(i);
            }
        }
        if (seatCount.size() % 2 != 0){
            return 0;
        }
        long finalAns = 1;
        int prevIndex = 1;
        for (int i = 2; i < seatCount.size(); i=i+2) {
            int diff = seatCount.get(i) - seatCount.get(prevIndex);
            finalAns = (finalAns * diff) % mod;
        }
        return (int)finalAns;
    }

    public boolean isPalindrome(String s) {
        StringBuilder result = new StringBuilder();
        for (char character : s.toCharArray()) {
            if (Character.isLetterOrDigit(character)) {
                result.append(character);
            }
        }
        String s1 = result.toString().toLowerCase();

        for (int i = 0; i < s1.length(); i++) {
            if (i > (s1.length() - i - 1)){
                break;
            }
            if (s1.charAt(i) != s1.charAt(s1.length() - i - 1)){
                return false;
            }
        }
        return true;
    }

    public int[] twoSumN(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (left >= right) {
            if (numbers[left] + numbers[right] > target){
                right--;
            }else if (numbers[left] + numbers[right] < target){
                left++;
            }
            if (numbers[left] + numbers[right] == target){
                return new int[]{left++, right++};
            }
        }
        return new int[]{left++, right++};
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            int left = i+1;
            int right = nums.length - 1;
            while (left < right) {
                if (nums[left] + nums[right] + nums[i] > 0){
                    right--;
                }else if (nums[left] + nums[right] + nums[i] < 0){
                    left++;
                }
                else{
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left += 1;
                    while (left < right && nums[left] == nums[left - 1]){
                        left+=1;
                    }
                }
            }
        }
        return result;
    }

    public int maxArea(int[] height) {
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < height.length; i++) {
            for (int j = i+1; j < height.length; j++) {
                int length = j - i;
                int breadth = Math.max(height[j], height[i]);
                result.add(length * breadth);
            }
        }

        return Collections.max(result);
    }

    public int maxArea2(int[] height) {
        ArrayList<Integer> result = new ArrayList<>();
        int i = 0;
        int j = height.length - 1;
        while (i<j){
            int length = j - i;
            int breadth = Math.min(height[j], height[i]);
            result.add(length * breadth);
            if (breadth == height[j]){
                j--;
            }else{
                i++;
            }
        }
        return Collections.max(result);
    }

    public boolean isValid(String s) {
        Stack<Character> bracStash = new Stack<>();

        for(Character ch: s.toCharArray()){
            if (ch == '(' || ch == '[' || ch == '{'){
                bracStash.add(ch);
            }
            else{
                if (bracStash.empty()){
                    return false;
                }

                Character lastBrac = bracStash.pop();
                if (ch == ')' && lastBrac != '(' ||
                    ch == ']' && lastBrac != '[' ||
                    ch == '}' && lastBrac != '{'){
                    return false;
                }
            }
        }
        return bracStash.empty();
    }
}   