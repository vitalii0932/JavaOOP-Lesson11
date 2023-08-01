package Exercise1;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String spec = "https://dou.ua/";
        try {
            String result = NetworkService.getLinks(spec, "UTF-8");
            System.out.println(result);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}