import java.util.Arrays;

/**
 * URLify: Write a method to replace all spaces in a string with '%20'. You may assume that the string has sufficient
 * space at the end to hold the additional characters, and that you are given the "true" length of the string. (Note: If
 * implementing in Java,please use a character array so that you can perform this operation in place.)
 */
class URLify {

    public static void main(String[] agrs) {
        String s = "hello world!";
        char[] cArr = Arrays.copyOf(s.toCharArray(), s.length() + 2);
        System.out.println(cArr);
        System.out.println(URLify(cArr, s.length()));
    }

    public static char[] URLify(char[] s, int len) {
        int last = s.length - 1, move = len - 1;

        while (move >= 0) {
            if (Character.isSpaceChar(s[move])) {
                s[last--] = '0';
                s[last--] = '2';
                s[last--] = '%';
                move--;
            } else {
                s[last--] = s[move--];
            }
        }
        return s;
    }
}
