package Exercise1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class NetworkService {
    public static String getLinks(String spec, String charset) throws IOException {
        URL url = new URL(spec);
        URLConnection connection = url.openConnection();
        String result = "";
        try(BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), charset))) {
            String temp = "";
            for (;;) {
                temp = br.readLine();
                if(temp == null) {
                    break;
                }
                if(temp.contains("<a href=\"")) {
                    System.out.println(temp);
                    result += getLinkByStr(temp);
                }
            }
        }
        return result;
    }

    private static String getLinkByStr(String str) {
        String result = "";
        int startIndex = str.indexOf("<a href=\"") + 9;
        int endIndex = str.indexOf("\"", startIndex);
        result = str.substring(startIndex, endIndex) + "\n";
        return result;
    }

}
