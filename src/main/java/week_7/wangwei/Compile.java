package week_7.wangwei;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * 编译c语言代码
 */
public class Compile {

    public static void main(String[] args) throws FileNotFoundException {
        String file = Compile.class.getClassLoader().getResource("example.c").getFile();
        Scanner in = new Scanner(new FileInputStream(new File(file)));
//        while (in.hasNextLine()) {
//            System.out.println(in.nextLine());
//        }
        Lexer lexer = new Lexer(in);
        while (lexer.hasNext()){
            System.out.println(lexer.nextToken());
        }
    }
}
