/**
 * Implement an algorithm to determine if a string has all unique characters. What if you cannot use additional data structures?
 */

class IsUnique {
    public static void main(String[] args){
        String test = "@a#c#";
        System.out.println(isUnique(test));
    }

    static boolean isUnique(String s){

        if(s.length()>128) return false; //considering ASCII charset
        int checker = 0;
        for(char c : s.toCharArray()){
            if((checker & 1<<c)>0){
                return false;
            }
            checker |= 1<<c;
        }
        return true;
    }
}