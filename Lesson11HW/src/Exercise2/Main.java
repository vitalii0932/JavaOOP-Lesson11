package Exercise2;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\User\\IdeaProjects\\Lesson11HW\\src\\Exercise2\\url.txt");
        try {
            String checkResult = NetworkService.checkSiteAvailability(file);
            System.out.println(checkResult);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}