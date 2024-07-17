import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Main {
    static String findMatchInString(String l, String match) {
        char c;
        int matchLength = match.length();
        int needToFind = matchLength;
        for (int i = 0; i <= l.length() - matchLength; i++) {
            c = l.charAt(i);
            while ((c == match.charAt(matchLength - needToFind))) {
                needToFind--;
                if (needToFind == 0) {
                    return l;
                }
                i++;
                c = l.charAt(i);
            }
            needToFind = matchLength;
        }
        return null;
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