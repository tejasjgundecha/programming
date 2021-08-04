/**
 * 1.9 StringRotation:Assumeyouhaveamethodi5Sub5tringwhichchecksifonewordisasubstring of another.
 * Given two strings, 51 and 52, write code to check if 52 is a rotation of 51 using only one call to i5Sub5tring
 * (e.g., "waterbottle" is a rotation of" erbottlewat").
 */

class StringRotation{
    public static void main(String[] args){

        String s1 = "waterbottle";
        String s2 = "erbottlewat";
        System.out.println(isARotation(s1, s2));
    }

    public static boolean isARotation(String s1, String s2){
        if(s1 == null || s2 == null) return false;
        if(s1.length() != s2.length()) return false;
        String str = s1 + s1;

        return str.contains(s2);
    }
}