import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Util {

    private Util() {

    }

    private static final String ENCODING = "UTF-8"; //you can change it to UTF-8

    public static String readFile(String path) {

        String res = null;

        try {

            byte[] bytes = Files.readAllBytes(Paths.get(path));

            res = new String(bytes, ENCODING);

        } catch (IOException ex) {

            //Logger imitation
        }

        return res;

    }
}