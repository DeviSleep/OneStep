import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

/**
 * Created by des on 2017/11/26.
 */
public class Test_jsoup {

    static String url="http://www.runoob.com/eclipse/eclipse-tutorial.html";

    public static void main(String [] args) throws IOException {

        blogBody();
    }

    private static void blogBody() throws IOException {
        // 直接从字符串中输入HTML文档
        String html="<html><head><title>开源中国</tilte></head>" +
                "<body><p>这里是jsoup</p></body></html>";
        Document doc= Jsoup.parse(html);
        System.out.println(doc.body());

        Document doc2= Jsoup.connect(url).get();
        String title= doc2.body().toString();
        System.out.println(title);

    }




}
