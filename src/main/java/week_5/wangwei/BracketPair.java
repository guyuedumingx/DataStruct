package week_5.wangwei;

import util.wangwei.MyStack;

import java.util.HashMap;
import java.util.Map;

/**
 * 括号匹配
 * @author yohoyes
 */
public class BracketPair {
    static Map<Character,Character> map = new HashMap<Character, Character>();

    static {
        map.put('{','}');
        map.put('[',']');
        map.put('(',')');
    }

    public static boolean isLeft(Character ch){
        return map.containsKey(ch);
    }

    public static boolean match(Character[] matches){
        MyStack<Character> stack = new MyStack<Character>();
        for(Character match : matches){
            if(isLeft(match)){
                stack.push(match);
            }else {
                char character = map.get(stack.pop());
                if(character!=match){
                    return false;
                }
            }
        }
        if(stack.isEmpty()){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Character[] matches1 = new Character[]{'{','}','[',']'};
        Character[] matches2 = new Character[]{'(','{','}',')','[',']'};
        System.out.println(match(matches2));
    }
}
