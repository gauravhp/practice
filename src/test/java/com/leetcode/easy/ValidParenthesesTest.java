package com.leetcode.easy;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class ValidParenthesesTest {

    @Test
    public void testValidParentheses(){
        assertThat(isValid(""),is(true));
        assertThat(isValid("("),is(false));
        assertThat(isValid("{}"),is(true));
        assertThat(isValid("()"),is(true));
        assertThat(isValid("(}"),is(false));
        assertThat(isValid("()[]{}"),is(true));
        assertThat(isValid("(]"),is(false));
        assertThat(isValid("([)]"),is(false));
        assertThat(isValid("{[]}"),is(true));
        assertThat(isValid("]"),is(false));
    }

    public boolean isValid(String s) {
        Stack<Character> parenthesisStack = new Stack<Character>();
        Map<Character,Character> parenthesesMap = getParenthesesMap();
        int index = 0 ;
        while(index < s.length()){
            if(parenthesesMap.keySet().contains(s.charAt(index))){
                if(parenthesisStack.isEmpty())
                    return false;

                Character character = parenthesisStack.pop();
                if(character != parenthesesMap.get(s.charAt(index))){
                    return false;
                }
                index++;
                continue;
            }
            parenthesisStack.push(s.charAt(index));
            index++;
        }
        if(!parenthesisStack.isEmpty()){
            return false;
        }

        return true;
    }

    private Map<Character,Character> getParenthesesMap(){
        Map<Character,Character> parenthesesMap = new HashMap<Character,Character>();
        parenthesesMap.put(')','(');
        parenthesesMap.put('}','{');
        parenthesesMap.put(']','[');
        return parenthesesMap;
    }

}
