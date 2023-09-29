/*
 * An app which has 7 functions regarding Strings
 * @author Mark Wani
 * 
 */
import java.util.Scanner;
import java.util.Arrays;
import java.lang.StringBuilder;
import java.util.*;
public class App {
  /**
   * Big-O Complexity: O(n)
   * returns if string is a palindrome recursively
   * @param a string s
   * @result a boolean on if the string is a palindrome
   */
  public static boolean palindromeRecursive(String s){
    if(s.length() == 0 || s.length() == 1)
      return true; 
    if(s.charAt(0) == s.charAt(s.length()-1))
      return palindromeRecursive(s.substring(1, s.length()-1));
    return false;
  }
  
  /**
   * Big-O Complexity: O(n)
   * returns if string is a palindrome through iteration
   * @param a string s
   * @result a boolean on if the string is a palindrome
   */
  public static boolean palindromeIterative(String s) {
    int left = 0;
    int right = s.length() - 1;
    
    while (left <= right) {
      if (s.charAt(left) != s.charAt(right)) {
        return false;
      } else {
        left++;
        right--;
      }
    }
    return true;
  }
  
  /**
   * Big-O Complexity: O(n log n)
   * returns if two separate strings are anagrams of each other
   * @param two separate strings x, and y
   * @result a boolean on if the two strings are anagrams
   */
  public static boolean isAnagram(String x, String y) {
    if (x.length() != y.length())
      return false;
    else {
      x = x.toLowerCase();
      y = y.toLowerCase();
      char[] xCharArray = x.toCharArray();
      char[] yCharArray = y.toCharArray();
      Arrays.sort(xCharArray);
      Arrays.sort(yCharArray);
      
      for (int i = 0; i < xCharArray.length; i++) {
        if (xCharArray[i] != yCharArray[i])
          return false;
      }
    }
    return true;
  }
  
  /**
   * Big-O Complexity: O(n + m)
   * returns a new string that has a substring inserted at a specific index
   * @param a String input, String substring, and an int index
   * @result a new constructed string
   */
  public static String addSubstring(String input, String substring, int index){
    StringBuilder builder = new StringBuilder();
    builder.append(input);
    builder.insert(index, substring);
    return builder.toString();
  }
  
  /**
   * Big-O Complexity: O(1)
   * returns the length of a string
   * @param a String input
   * @result an int which tells you how long the string is
   */
  public int getLength(String input){
    return input.length();
  }
  
  /**
   * Big-O Complexity: O (( n - m + 1) * m)
   * returns the number of times a substring occurs within a string
   * @param a String input, and String substring
   * @result a int of how many times the substring occurs within the string
   */
  public int occuranceCounter(String input, String substring) {
    input = input.toLowerCase();
    substring = substring.toLowerCase();
    if (substring.isEmpty()) {
      return 0;
    }  
    int count = 0;
    int index = input.indexOf(substring);
    while (index != -1) {
      count++;
      index = input.indexOf(substring, index + 1);
    }
    return count;
  }
  
  /**
   * Big-O Complexity: O(n + m)
   * returns a string that is reversed
   * @param a String input
   * @result a String which is reversed
   */
  public String sentenceReversal(String input){
    StringBuilder builder = new StringBuilder();
    String[] splitStr = input.trim().split("\\s+"); 
    for(int i = splitStr.length; i > 0; i--)
      builder.append(splitStr[i - 1]).append(" ");
    return builder.toString();
  }
  
  public static void main(String[]args){ 
    App palindromeApp = new App();
    System.out.println("Welcome to the App");
    Scanner sc = new Scanner(System.in);
    System.out.println("1. Palindrome Check\n2. Anagram Check\n3. Add Substring\n4. Get Length\n5. Count Occurrences\n6. Reverse Sentence\n7. Quit\nChoose an option: ");
    int option = sc.nextInt();
    sc.nextLine();
    System.out.println("Enter string:");
    String input = sc.nextLine();
    
    switch(option){
      case 1:
        boolean result = palindromeRecursive(input);
        System.out.println(input + " is a palindrome: " + result);
        break;
      case 2:
        System.out.println("Enter another string to check if anagram:");
        String substring = sc.nextLine();
        boolean result2 = isAnagram(input, substring);
        System.out.println(result2);
        break;
      case 3:
        System.out.println("Substring to be inserted:");
        String substring2 = sc.nextLine();
        System.out.println("Index Placement:");
        int index = sc.nextInt();
        System.out.println(palindromeApp.addSubstring(input, substring2, index));
        break;
      case 4:
        System.out.println("The length of your string is: " + palindromeApp.getLength(input)); 
        break;
      case 5:
        System.out.println("Enter Substring: ");
        String substring3 = sc.nextLine();
        System.out.println("The substring occurs " + palindromeApp.occuranceCounter(input, substring3) + " times in the string");
      case 6:
        System.out.println("The sentence reversed is: " + palindromeApp.sentenceReversal(input));   
        break;
      case 7:
        break;
      default:
        System.out.println("Enter Valid Number 1-7");
        break;
    }
     System.out.println("Have a nice day :)");
  }
}
