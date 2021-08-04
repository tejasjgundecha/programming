/**
 * Check Permutation: Given two strings,write a method to decide if one is a permutation of the
 * other.
 */
class CheckPermutation{
    public static void main(String[] args){
        String s1= "";
        String s2= "";
        System.out.println(isPermutation(s1,s2));
    }

    static boolean isPermutation(String s1, String s2){
        if(s1==null || s2==null) return false;
        if(s1.length() != s2.length()) return false;
        int[] charCount=new int[128]; //ASCII charset
        for(char c : s1.toCharArray()){
            charCount[c]++;
        }

        for(char c : s2.toCharArray()){
            if(charCount[c]<1) return false;
            charCount[c]--;
        }
        for(int i: charCount){
            if(i!=0) return false;
        }
        return true;
    }
}