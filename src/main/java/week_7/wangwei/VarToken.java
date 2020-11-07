package week_7.wangwei;

/**
 * 变量
 */
public class VarToken extends Token {

    private String value;

    protected VarToken(int line, String v) {
        super(line);
        value = v;
    }

    @Override
    public boolean isNumber() {
        return true;
    }

    @Override
    public String getText() {
        return value;
    }
}
