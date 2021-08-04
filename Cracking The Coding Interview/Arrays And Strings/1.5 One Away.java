class OneAway{
    public static void main(String[] args){
        String s1="pale";
        String s2="bakes";
        System.out.println(isOneEditAway(s1, s2));
    }

    static boolean isOneEditAway(String s1, String s2){
        if(s1==null || s2==null) return false;
        if(s1.equals(s2)) return true;
        if(Math.abs(s1.length()-s2.length())>1) return false;

        if(s1.length()==s2.length()) return checkReplace(s1, s2, 1);
        if(s1.length() > s2.length())
            return checkRemoval(s1, s2, 1);
        else
            return checkRemoval(s2, s1, 1);

    }

    private static boolean checkReplace(String s1, String s2, int remainingEdits){
        int index = 0;
        while(index < s1.length()){
            if(s1.charAt(index)!=s2.charAt(index)){
                if(remainingEdits>0){
                    remainingEdits--;
                }
                else return false;
            }
            index++;
        }
        return true;
    }

    private static boolean checkRemoval(String s1, String s2, int remainingEdits){
        int index1=0,index2=0;

        while(index1 < s2.length()){
            if(s1.charAt(index1) != s2.charAt(index2)){
                if(remainingEdits>0){
                    remainingEdits--;
                    index1++;
                }
                else return false;
            }
            else{
                index1++; index2++;
            }
        }

        return true;
    }
}