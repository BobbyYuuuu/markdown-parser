import java.util.ArrayList;

import org.commonmark.node.*;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;
class WordCountVisitor extends AbstractVisitor {
    int wordCount = 0;

    @Override
    public void visit(Text text) {
        // This is called for all Text nodes. Override other visit methods for other node types.

        // Count words (this is just an example, don't actually do it this way for various reasons).
        wordCount += text.getLiteral().split("\\W+").length;

        // Descend into children (could be omitted in this case because Text nodes don't have children).
        visitChildren(text);
    }
}
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

class TryCommonMark {
    public static void main(String[] args) {    
        Parser parser = Parser.builder().build();
        Node document = parser.parse("This is *Sparta*");
        HtmlRenderer renderer = HtmlRenderer.builder().build();
        renderer.render(document);  // "<p>This is <em>Sparta</em></p>\n"
        Node node = parser.parse("[a](google.com)\n=======\n\nSome more text");
        LinkVisitor visitor = new LinkVisitor();
        node.accept(visitor);
        System.out.println(visitor.LinkCount);  // 4

    }
}
