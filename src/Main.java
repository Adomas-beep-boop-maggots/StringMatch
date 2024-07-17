import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Main {
    static String FindMatchInString_1(String l, String Match) {
        char c;
        int MatchLength = Match.length();
        int NeedToFind = MatchLength;
        for (int i = 0; i <= l.length() - MatchLength; i++) {
            c = l.charAt(i);
            while ((c == Match.charAt(MatchLength - NeedToFind))) {
                NeedToFind--;
                if (NeedToFind == 0) {
                    return l;
                }
                i++;
                c = l.charAt(i);
            }
            NeedToFind = MatchLength;
        }
        return null;
    }

    static String FindMatchInString_2(String l, String Match) {
        if (l.contains(Match)) {
            return l;
        } else {
            return null;
        }
    }

    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            System.err.println("Provide at 1 argument.");
            System.err.println("Usage: StringMatch [String]");
            System.exit(1);
        }
        String FindThis = args[0];
        BufferedReader inputStream = new BufferedReader(new FileReader("dataset"));
        String l;
        String f;
        try {
            while ((l = inputStream.readLine()) != null) {

                // FindMatchInString implementations:
                // FindMatchInString_1
                // FindMatchInString_2
                if ((f = FindMatchInString_1(l, FindThis)) != null) {
                    System.out.println("Found it here " + f);
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