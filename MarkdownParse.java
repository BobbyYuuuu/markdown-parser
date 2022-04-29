//https://howtodoinjava.com/java/io/java-read-file-to-string-examples/

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MarkdownParse {

    public static ArrayList<String> getLinks(String markdown) {
        ArrayList<String> toReturn = new ArrayList<>();
        // find the next [, then find the ], then find the (, then read link upto next )
        int currentIndex = 0;
        while (currentIndex < markdown.length()) {
            int openBracket = markdown.indexOf("[", currentIndex);
            int closeBracket = markdown.indexOf("]", openBracket);
            int openParen = markdown.indexOf("(", closeBracket);
            int closeParen = markdown.indexOf(")", openParen);
            if (openBracket == -1 || closeBracket == -1 || openParen == -1 || closeParen == -1) {
                break;
            }
<<<<<<< HEAD
            if ((openBracket - 1) > -1 && markdown.substring(openBracket - 1, openBracket).equals("!")) {
                currentIndex = closeParen + 1;
                continue;
            }
            if (!markdown.substring(closeBracket + 1, closeBracket + 2).equals("(")) {
                currentIndex = closeParen + 1;
                continue;
            }
            if (closeParen < markdown.length() - 1 && markdown.substring(closeParen +
                    1).equals(")")) {
                closeParen++;
            }

=======
            if (closeParen < markdown.length() - 1 && markdown.substring(closeParen + 1).equals(")")) {
                closeParen++;
            }
            if ((openBracket - 1) > -1 && markdown.substring(openBracket - 1, openBracket).equals("!")){
                currentIndex = closeParen + 1;
                continue;
            }
            if (!markdown.substring(closeBracket + 1, closeBracket + 2).equals("(")){
                currentIndex = closeParen + 1;
                continue;
            }
            
>>>>>>> 3b07614aee0f4954931f380df499d3e589a86361
            toReturn.add(markdown.substring(openParen + 1, closeParen));
            currentIndex = closeParen + 1;
        }

        return toReturn;
    }

    public static void main(String[] args) throws IOException {
        Path fileName = Path.of(args[0]);
        String content = Files.readString(fileName);
        ArrayList<String> links = getLinks(content);
        System.out.println(links);
    }
}
