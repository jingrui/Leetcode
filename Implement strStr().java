public class Solution {
    public String strStr(String haystack, String needle) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int i = haystack.indexOf(needle);
        return (i == -1)?null:haystack.substring(i);
    }
}
