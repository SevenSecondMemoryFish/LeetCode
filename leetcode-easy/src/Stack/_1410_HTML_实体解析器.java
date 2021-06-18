package Stack;

public class _1410_HTML_实体解析器 {
    public static void main(String[] args) {
        entityParser("&amp;gt;");
    }
    public static String entityParser(String text) {
        if (text.indexOf("&quot;") != -1) {
            text = text.replace("&quot;","\"");
        }
        if (text.indexOf("&apos;") != -1) {
            text = text.replace("&apos;","\'");
        }
        if (text.indexOf("&gt;") != -1) {
            text = text.replace("&gt;",">");
        }
        if (text.indexOf("&lt;") != -1) {
            text = text.replace("&lt;","<");
        }
        if (text.indexOf("&frasl;") != -1) {
            text = text.replace("&frasl;","/");
        }
        if (text.indexOf("&amp;") != -1) {
            text = text.replace("&amp;","&");
        }
        return text;
    }
}
