public class StringTwoMethods {

    /*http://codingbat.com/prob/p165312 10m
    Given a string, return a string where for every char in the original, there are two chars.

            doubleChar("The") → "TThhee"
    doubleChar("AAbb") → "AAAAbbbb"
    doubleChar("Hi-There") → "HHii--TThheerree"

    Decision*/
    public String doubleChar(String str) {
        String strNew = "";
        for (int i=0; i<str.length(); i++)
        {strNew = strNew + str.charAt(i) + str.charAt(i);}
        return strNew;
    }

    /*countcode
    http://codingbat.com/prob/p123614
    Return the number of times that the string "code" appears anywhere in the given string, except we'll accept any letter for the 'd', so "cope" and "cooe" count.

    countCode("aaacodebbb") → 1
    countCode("codexxcode") → 2
    countCode("cozexxcope") → 2*/

    public int countCode(String str) {
        String findStr1 = "coc";
        String findStr2 = "e";
        String findStr3="code";
        int lastIndex = 0;
        int lastIndex2 = 0;
        int count = 0;

        while (lastIndex != -1 && lastIndex2 != -1 ) {

            lastIndex = str.indexOf(findStr1, lastIndex);
            lastIndex2 = str.indexOf(findStr2, lastIndex2);

            if (lastIndex != -1 && lastIndex2 != -1) {
                count++;
                lastIndex += findStr3.length();
                lastIndex2 += findStr3.length();

            }

            //    if (lastIndex >= str.length() ||lastIndex2 >= str.length()) break;
        }
        return count;
    }

    public String conCat(String a, String b) {

        /*https://codingbat.com/prob/p132118
        Given two strings, append them together (known as "concatenation") and return the result. However, if the concatenation creates a double-char, then omit one of the chars, so "abc" and "cat" yields "abcat".


                conCat("abc", "cat") → "abcat"
        conCat("dog", "cat") → "dogcat"
        conCat("abc", "") → "abc"*/

        String resultString="";
        String lastA ="";
        String firstB ="";
        if (!a.equals("")) {
             lastA = a.substring(a.length() - 1);
        }

        if (!b.equals("")) {
            firstB=b.substring(0,1);
        }
        resultString = a.concat(b);
        if (lastA.equals(firstB)){

            String AA=a.substring(0,a.length() - 1);
            resultString=AA.concat(b);
            //resultString="xxx";
        }
        return resultString;

    }


    public int countHi(String str) {
      /*  https://codingbat.com/prob/p147448

        Return the number of times that the string "hi" appears anywhere in the given string.


        countHi("abc hi ho") → 1
        countHi("ABChi hi") → 2
        countHi("hihi") → 2*/
        int calculated=0;

        for (int x=0; x<str.length()-1;x++){

            if(str.substring(x,x+2).equals("hi")){
                calculated++;
            }

        }
        return calculated;
    }
}
