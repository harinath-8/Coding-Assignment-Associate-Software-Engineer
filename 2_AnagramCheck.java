import java.util.Arrays;
import java.util.Scanner;

public class AnagramChecker {
    
    /**
     * Checks if two strings are anagrams of each other.
     * Two strings are anagrams if they contain the same characters in different order.
     * 
     * @param str1 The first string
     * @param str2 The second string
     * @return true if the strings are anagrams, false otherwise
     */
    public static boolean areAnagrams(String str1, String str2) {
        // Quick check for edge cases
        if (str1 == null || str2 == null) {
            return false;
        }
        
        // Remove spaces and convert to lowercase for case-insensitive comparison
        String s1 = str1.replaceAll("\\s", "").toLowerCase();
        String s2 = str2.replaceAll("\\s", "").toLowerCase();
        
        // If lengths are different, they can't be anagrams
        if (s1.length() != s2.length()) {
            return false;
        }
        
        // Sort both strings and compare
        char[] charArray1 = s1.toCharArray();
        char[] charArray2 = s2.toCharArray();
        
        Arrays.sort(charArray1);
        Arrays.sort(charArray2);
        
        // Check if sorted arrays are identical
        return Arrays.equals(charArray1, charArray2);
    }
    
    /**
     * Alternative implementation using character frequency counting.
     * This approach avoids sorting and may be more efficient for longer strings.
     */
    public static boolean areAnagramsUsingCount(String str1, String str2) {
        // Quick check for edge cases
        if (str1 == null || str2 == null) {
            return false;
        }
        
        // Remove spaces and convert to lowercase
        String s1 = str1.replaceAll("\\s", "").toLowerCase();
        String s2 = str2.replaceAll("\\s", "").toLowerCase();
        
        // If lengths are different, they can't be anagrams
        if (s1.length() != s2.length()) {
            return false;
        }
        
        // Use array to count character frequencies (assuming ASCII)
        int[] counts = new int[256];
        
        // Count characters in first string
        for (int i = 0; i < s1.length(); i++) {
            counts[s1.charAt(i)]++;
        }
        
        // Decrement counts for second string
        for (int i = 0; i < s2.length(); i++) {
            counts[s2.charAt(i)]--;
            
            // If a character count goes negative, not an anagram
            if (counts[s2.charAt(i)] < 0) {
                return false;
            }
        }
        
        // If all counts are zero, strings are anagrams
        return true;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Anagram Checker");
        System.out.println("--------------");
        
        System.out.print("Enter first string: ");
        String str1 = scanner.nextLine();
        
        System.out.print("Enter second string: ");
        String str2 = scanner.nextLine();
        
        boolean result = areAnagrams(str1, str2);
        
        System.out.println("\nResult: " + result);
        
        // Test with examples from assignment
        System.out.println("\nTesting examples from assignment:");
        System.out.println("'listen' and 'silent': " + areAnagrams("listen", "silent"));
        System.out.println("'hello' and 'world': " + areAnagrams("hello", "world"));
        
        scanner.close();
    }
}