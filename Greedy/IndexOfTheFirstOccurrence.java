public class IndexOfTheFirstOccurrence {
    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    public static void main(String[] args) {
        IndexOfTheFirstOccurrence solution = new IndexOfTheFirstOccurrence();

        String haystack1 = "sadbutsad", needle1 = "sad";
        System.out.println("Test 1: Output: " + solution.strStr(haystack1, needle1) + " | Expected: 0");

        String haystack2 = "leetcode", needle2 = "leeto";
        System.out.println("Test 2: Output: " + solution.strStr(haystack2, needle2) + " | Expected: -1");

        String haystack3 = "hello", needle3 = "ll";
        System.out.println("Test 3: Output: " + solution.strStr(haystack3, needle3) + " | Expected: 2");

        String haystack4 = "a", needle4 = "a";
        System.out.println("Test 4: Output: " + solution.strStr(haystack4, needle4) + " | Expected: 0");
    }
}