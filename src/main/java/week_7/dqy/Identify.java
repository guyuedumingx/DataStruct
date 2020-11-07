package week_7.dqy;

import java.io.*;

public class Identify {
    static String[] keyWords = {"for", "do", "while", "return", "continue", "break",
            "goto", "short", "long", "signed", "unsigned", "struct", "union",
            "enum", "typeof", "sizeof", "void", "char", "int", "float", "double",
            "if", "else", "switch", "case", "default", "auto", "static", "register",
            "extern", "const", "volatile"
    };

    static String[] operator = {"+", "-", "*", "/", "%", "++", "--", "==", "!=", ">",
            "<", ">=", "<=", "&&", "||", "!", "&", "|", "^", "~", "<<", ">>", ")",
            "=", "+=", "-=", "*=", "/=", "%=", "<<=", ">>=", "&=", "^=", "!=", "?", "(", ";"
    };

    static boolean isIdentify(String str) {
        for (int i = 0; i < keyWords.length; i++) {
            if (str.equals(keyWords[i])) {
                System.out.println("keyword: " + str);
                return true;
            }
        }
        return false;
    }

    static boolean isOperator(String str) {
        for (int i = 0; i < operator.length; i++) {
            if (str.equals(operator[i])) {
                System.out.println("operator: " + str);
                return true;
            }
        }
        return false;
    }

    void check(String str) {
        String[] row = str.split("\n");
        String[][] curStr = new String[100][100];
        for (int i = 0; i < row.length; i++) {
            curStr[i] = row[i].split(" ");
        }
        for (int i = 0; i < curStr.length; i++) {
            for (int j = 0; j < curStr[i].length; j++) {
                if (!(isOperator(curStr[i][j]) && isIdentify(curStr[i][j]))) {
                    System.out.println("name: " + curStr[i][j]);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        File file = new File("G:\\testData\\cpp.txt");
//        System.out.println(file.exists());
        BufferedReader input = new BufferedReader(new FileReader(file));
        String tmp;
        while ((tmp = input.readLine()) != null) {
            String[] curStr = tmp.split(" ");
            for (int j = 0; j < curStr.length; j++) {
                if (!(isOperator(curStr[j]) && isIdentify(curStr[j])) && curStr[j].length() != 0) {
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