/**
 * 1.6 String Compression: Implement a method to perform basic string compression using the counts of repeated
 * characters. For example, the string aabcccccaaa would become a2blc5a3. If the "compressed" string would not become
 * smaller than the original string, your method should return the original string. You can assume the string has only
 * uppercase and lowercase letters (a - z).
 */

class StringCompression {

    public static void main(String[] args) {
        String s = "abbbbb";
        System.out.println(compressString(s));
    }

    static String compressString(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        char prev = s.charAt(0);
        int count=1;
        StringBuilder sb = new StringBuilder(2);

        for (int i = 1; i < s.length(); i++) {
            if(prev==s.charAt(i)) count++;
            else {
                sb.append(prev).append(count);
                prev = s.charAt(i);
                count=1;
            }
        }
        sb.append(prev).append(count);
        return sb.toString().length() < s.length() ? sb.toString() : s;
    }
}