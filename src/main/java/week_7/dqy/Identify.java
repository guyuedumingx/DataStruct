package week_7.dqy;

import java.io.*;

public class Identify {
    //该数组存储了所有的c语言关键词
    static String[] keyWords = {"for", "do", "while", "return", "continue", "break",
            "goto", "short", "long", "signed", "unsigned", "struct", "union",
            "enum", "typeof", "sizeof", "void", "char", "int", "float", "double",
            "if", "else", "switch", "case", "default", "auto", "static", "register",
            "extern", "const", "volatile"
    };
    //该数组存储了c语言的所有操作符
    static String[] operator = {"+", "-", "*", "/", "%", "++", "--", "==", "!=", ">",
            "<", ">=", "<=", "&&", "||", "!", "&", "|", "^", "~", "<<", ">>", ")",
            "=", "+=", "-=", "*=", "/=", "%=", "<<=", ">>=", "&=", "^=", "!=", "?", "(", ";"
    };

    //判断当前字符串是否为
    static boolean isKeyWords(String str) {
        for (int i = 0; i < keyWords.length; i++) {
            if (str.equals(keyWords[i])) {
                System.out.println("keyword: " + str);
                return true;
            }
        }
        return false;
    }

    //判断当前字符串是否为操作符
    static boolean isOperator(String str) {
        for (int i = 0; i < operator.length; i++) {
            if (str.equals(operator[i])) {
                System.out.println("operator: " + str);
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        //读入c语言的代码
        File file = new File("G:\\testData\\cpp.txt");
//        System.out.println(file.exists());
        BufferedReader input = new BufferedReader(new FileReader(file));
        String tmp;
        //一行行读入
        while ((tmp = input.readLine()) != null) {
            //分割字符串
            String[] curStr = tmp.split(" ");
            for (int j = 0; j < curStr.length; j++) {
                //判断当前字符串是否为
                if (!(isOperator(curStr[j]) && isKeyWords(curStr[j])) && curStr[j].length() != 0) {
                    //判断当前字符串是否符合命名规范
                    boolean flag = true;
                    char[] tmpArr = curStr[j].toCharArray();
                    if (!((tmpArr[0] >= 'a' && tmpArr[0] <= 'z') || (tmpArr[0] >= 'A' && tmpArr[0] <= 'Z')))
                        flag = false;
                    for (int i = 1; i < tmpArr.length; i++) {
                        if (!((tmpArr[0] >= 'a' && tmpArr[0] <= 'z') || (tmpArr[0] >= 'A' && tmpArr[0] <= 'Z') || (tmpArr[0] >= '0' && tmpArr[0] <= '9')))
                            flag = false;
                    }
                    if (flag)
                        System.out.println("name: " + curStr[j]);
                }
            }
        }
    }
}