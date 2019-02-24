public class StringThreeMethodsToCheck {
    /*task1 count YZ substring http://codingbat.com/prob/p199171
    Given a string, count the number of words ending in 'y' or 'z' -- so the 'y' in "heavy" and the 'z' in "fez" count, but not the 'y' in "yellow" (not case sensitive). We'll say that a y or z is at the end of a word if there is not an alphabetic letter immediately following it. (Note: Character.isLetter(char) tests if a char is an alphabetic letter.)

    countYZ("fez day") → 2
    countYZ("day fez") → 2
    countYZ("day fyyyz") → 2

    Decision*/

    public int countYZ(String str) {
        String findStr1 = "z";
        String findStr3 = "Z";
        String findStr2 = "y";
        String findStr4 = "Y";
        int lastIndex = 0;
        int lastIndex2 = 0;
        int countFinal = 0;

        int count1=checkSymbol(str,findStr1);
        int count2=checkSymbol(str,findStr2);
        int count3=checkSymbol(str,findStr3);
        int count4=checkSymbol(str,findStr4);
        countFinal=count1 + count2 + count3 + count4;

        return countFinal;
    }

    public int checkSymbol (String str, String findStr){
        int count =0;

        for (int i=0; i<str.length(); i++) {
            if (str.substring(i, i+1).equals(findStr)){


                if (i+1 < str.length()){

                    boolean checkNextChar = Character.isLetter(str.charAt(i+1));
                    if (!checkNextChar) count++;
                }

                if ( i == str.length()-1)    count++;                                  }

        }

        return count;
    }


    public String withoutString(String base, String remove) {

/*        39) String-30 withoutString
        https://codingbat.com/prob/p192570

        Given two strings, base and remove, return a version of the base string where all instances of the remove string have been removed (not case sensitive). You may assume that the remove string is length 1 or more. Remove only non-overlapping instances, so with "xxx" removing "xx" leaves "x".

                withoutString("Hello there", "llo") → "He there"
        withoutString("Hello there", "e") → "Hllo thr"
        withoutString("Hello there", "x") → "Hello there"*/

        String resultString="";
        boolean changeHappend=false;
        int startIndex=0;
        // String strNew = base.replace(remove, "");

        for (int i=0; i<= base.length()-remove.length(); i++)

        {

            if(base.substring(i,i+remove.length()).equalsIgnoreCase(remove))
            {
                resultString=resultString+ base.substring(startIndex,i);
                i=i+remove.length();
                startIndex=i;
                changeHappend=true;
            }
        }
        if (changeHappend){
            resultString=resultString+ base.substring(startIndex,base.length());
        }

        if (!changeHappend){
            resultString=base.substring(startIndex,base.length());
        }
        return resultString;    }

}