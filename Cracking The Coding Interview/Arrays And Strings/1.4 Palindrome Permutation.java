/**
 * Palindrome Permutation: Given a string, write a function to check if it is a permutation of a palindrome.
 * A palindrome is a word or phrase that is the same forwards and backwards. A permutation is a rearrangement of letters.
 * The palindrome does not need to be limited to just dictionary words.
 */
class PalindromePermutation{
    public static void main(String[] args){
        String s= "TactCoa".toLowerCase();
        //todo Remove all whitespaces from the string
        System.out.println(isPalindromePermutation(s));
    }

    static boolean isPalindromePermutation(String s){

        int bitVector =0;
        for(char c : s.toCharArray()){
           bitVector =  flipBit(bitVector, c);
        }

        if(bitVector==0) return true;
        /**
         * To check max 1 odd character is there, bitVector & (bitVector-1) should be 0
         * 001000 & 000111 = 0
         */
        if((bitVector & (bitVector-1))==0) return true;
        return false;
    }

    static int flipBit(int x, int index){
        int mask = 1<<index;
        if((x & mask)==0){ //bit is 0, simply or with mask to flip it
            x |=mask;
        }
        else{
            //bit is 1, and it with ~mask to flip it
            x &=~mask;
        }
        return x;
    }
}