package com.gaurav.strings;
/*
The count-and-say sequence is the sequence of integers with the first five terms as following:

1.     1
2.     11
3.     21
4.     1211
5.     111221
1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.

Given an integer n where 1 ≤ n ≤ 30, generate the nth term of the count-and-say sequence. You can do so recursively, in other words from the previous member read off the digits, counting the number of digits in groups of the same digit.

Note: Each term of the sequence of integers will be represented as a string.
https://www.careercup.com/question?id=4425679
 */
public class CountAndSay {
    public String countAndSay(int n) {
        if(n==1){
            return "1";
        }

        String prevNumber = new CountAndSay().countAndSay(n-1);

        String returnString = "";

        int index = 0;
        while(index < prevNumber.length()){
            char currentChar = prevNumber.charAt(index);
            int count = 1;
            int cursor = index+1;
            if(cursor == prevNumber.length()){
                returnString = returnString + String.valueOf(count) + String.valueOf(currentChar);
                break;
            }
            while(cursor < prevNumber.length() && prevNumber.charAt(cursor) == currentChar){
                count++;
                cursor++;
            }
            returnString = returnString + String.valueOf(count) + String.valueOf(currentChar);
            index = index + count;
        }

        return returnString;
    }
}
