//https://howtodoinjava.com/java/io/java-read-file-to-string-examples/

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

import javax.swing.text.html.HTMLEditorKit.Parser;
import java.util.ArrayList;

import org.commonmark.node.*;
import org.commonmark.renderer.html.HtmlRenderer;
import org.commonmark.node.AbstractVisitor;
import org.commonmark.node.Link;
import org.commonmark.node.Node;
import org.commonmark.renderer.html.HtmlRenderer;

class LinkVisitor extends AbstractVisitor{
    int LinkCount = 0;
    ArrayList<String> LinkList = new ArrayList<>();

    @Override
    public void visit(Link link) {
        // This is called for all Text nodes. Override other visit methods for other node types.

        // Count words (this is just an example, don't actually do it this way for various reasons).
        LinkList.add(link.getDestination());

        // Descend into children (could be omitted in this case because Text nodes don't have children).
        visitChildren(link);
    }
}
public class MarkdownParse {
    
    public static ArrayList<String> getLinks(String markdown) {
        Parser parser = Parser.builder().build();
        Node document = parser.parse("This is *Sparta*");
        HtmlRenderer renderer = HtmlRenderer.builder().build();
        renderer.render(document);  // "<p>This is <em>Sparta</em></p>\n"
        Node node = parser.parse("[a](google.com)\n=======\n\nSome more text");
        LinkVisitor visitor = new LinkVisitor();
        node.accept(visitor);
        System.out.println(visitor.LinkCount);  // 4

        // ArrayList<String> toReturn = new ArrayList<>();
        // // find the next [, then find the ], then find the (, then read link upto next )
        // int currentIndex = 0;
        // while (currentIndex < markdown.length()) {
        //     int openBracket = markdown.indexOf("[", currentIndex);
        //     int closeBracket = markdown.indexOf("]", openBracket);
        //     int openParen = markdown.indexOf("(", closeBracket);
        //     int closeParen = markdown.indexOf(")", openParen);
        //     if (openBracket == -1 || closeBracket == -1 || openParen == -1 || closeParen == -1) {
        //         break;
        //     }
        //     if ((openBracket - 1) > -1 && markdown.substring(openBracket - 1, openBracket).equals("!")) {
        //         currentIndex = closeParen + 1;
        //         continue;
        //     }

        //     if (markdown.substring(openParen + 1, closeParen).contains("(")){
        //         if (closeParen + 1 < markdown.length() - 1){
        //             closeParen = markdown.indexOf(")", closeParen + 1);
        //         }
        //     }
            
        //     if (!markdown.substring(closeBracket + 1, closeBracket + 2).equals("(")) {
        //         currentIndex = closeParen + 1;
        //         continue;
        //     }
        //     if (closeParen < markdown.length() - 1 && markdown.substring(closeParen +
        //             1).equals(")")) {
        //         closeParen++;
        //     }

        //     toReturn.add(markdown.substring(openParen + 1, closeParen));
        //     currentIndex = closeParen + 1;
        // }

        // return toReturn;
    }

    public static void main(String[] args) throws IOException {
        Path fileName = Path.of(args[0]);
        String content = Files.readString(fileName);
        ArrayList<String> links = getLinks(content);
        System.out.println(links);
    }
}
