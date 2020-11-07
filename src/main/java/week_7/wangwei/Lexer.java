package week_7.wangwei;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 语法分析器
 * @author yohoyes
 */
public class Lexer {

    Scanner in = null;
    List<Token> tokenList = new ArrayList<Token>();

    public Lexer(Scanner in){
        this.in = in;
    }

    public String nextToken() {
        StringBuilder sb = new StringBuilder();
        while (in.hasNext()&&!isPartition(in.next().charAt(0))){
            sb.append(in.next());
        }
        return sb.toString();
    }

    public boolean hasNext(){
        return in.hasNext();
    }

    public boolean isPartition(char ch){
        switch (ch){
            case ' ':
            case '{':
            case '}':
            case '(':
            case ')':
            case ';':
            case ',':
                return true;
            default:
                return false;
        }
    }
}
