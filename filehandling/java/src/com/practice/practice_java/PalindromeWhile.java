public class PalindromeWhile {

    public static void main(String[] args) {

        String str = "madam";
        boolean isPalindrome = true;

        int i = 0;
        int j = str.length() - 1;

        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) {
                isPalindrome = false;
                break;
            }
            i++;
            j--;
        }

        System.out.println(isPalindrome);
    }
}