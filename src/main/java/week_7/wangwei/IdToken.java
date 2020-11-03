package week_7.wangwei;

/**
 * 标识符
 * @author yohoyes
 */
public class IdToken extends Token {

    private String text;

    protected IdToken(int line, String id) {
        super(line);
        text = id;
    }

    @Override
    public boolean isIdentifier() {
        return true;
    }

    @Override
    public String getText() {
        return text;
    }
}
