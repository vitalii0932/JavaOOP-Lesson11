package Exercise2;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

public class NetworkService {
    public static String checkSiteAvailability(File file) throws IOException{
        String result = "";
        try(BufferedReader br = new BufferedReader(new FileReader(file))) {
            String temp = "";
            for (;;) {
                temp = br.readLine();
                if(temp == null) {
                    break;
                }
                URL url = new URL(temp);
                URLConnection connection = url.openConnection();
                System.out.println(connection.getHeaderFields());
                if(connection.getHeaderFields().size() > 0) {
                    result += temp + " -> " + "available\n";
                } else {
                    result += temp + " -> " + "!available\n";
                }
            }
        }
        return result;
    }
}
