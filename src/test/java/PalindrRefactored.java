public class PalindrRefactored {
    public static void main(String[] args) {
        String palindrome = "Dot saw I was Tod";
        int len = palindrome.length();
        char[] tempCharArray = new char[len];
        char[] charArray = new char[len];

        tempCharArray = strIntoCharArray(palindrome, len);

        charArray = reverseCharArray(tempCharArray);

        String reversePalindrome = charToStr(charArray);

        boolean isPalindrome = ifPalindrome(palindrome, reversePalindrome);

        System.out.println(palindrome);
        System.out.println(reversePalindrome);
        System.out.println("Is the string a palindrome? - "+ isPalindrome);

    }

    private static boolean ifPalindrome(String palindrome, String reversePalindrome) {
        String palindrome2 = palindrome.toLowerCase();
        String reversePalindrome2 = reversePalindrome.toLowerCase();
        boolean isPalindrome = palindrome2.equals(reversePalindrome2);
        return isPalindrome;
    }

    private static String charToStr(char[] charArray) {
        String str = new String(charArray);
        return str;
    }


    private static char[] reverseCharArray (char[] tempCharArray){
            char[] arr = new char[tempCharArray.length];
            for (int j = 0; j < tempCharArray.length; j++) {
                arr[j] = tempCharArray[tempCharArray.length - 1 - j];
            }
            return arr;
        }

        private static char[] strIntoCharArray (String palindrome,int len){
            char[] arr = new char[len];
            for (int i = 0; i < len; i++) {
                arr[i] = palindrome.charAt(i);
            }
            return arr;
        }
}
