import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Main {
    static String findMatchInString1(String l, String match) {
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

    static String findMatchInString2(String l, String Match) {
        if (l.contains(Match)) {
            return l;
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
        String l;
        String findLine;
        try {
            while ((l = inputStream.readLine()) != null) {

                // FindMatchInString implementations:
                // findMatchInString1
                // findMatchInString2
                if ((findLine = findMatchInString1(l, findThis)) != null) {
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