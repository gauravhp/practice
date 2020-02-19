package com.gaurav.strings;

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
