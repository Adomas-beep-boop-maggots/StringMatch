import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Main {
    static String findMatchInString(String line, String match) {
        if (line.contains(match)) {
            return line;
        } else {
            return null;
        }
    }

    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            System.err.println("Provide 1 argument.");
            System.err.println("Usage: StringMatch [String]");
            System.exit(1);
        }
        String findThis = args[0];
        BufferedReader inputStream = new BufferedReader(new FileReader("dataset"));
        String line;
        String findLine;
        try {
            while ((line = inputStream.readLine()) != null) {
                if ((findLine = findMatchInString(line, findThis)) != null) {
                    System.out.println("Found it here " + findLine);
                    System.exit(0);
                }
            }
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
        System.err.println("NOT found");
        System.exit(1);
    }
}