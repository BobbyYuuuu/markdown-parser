import static org.junit.Assert.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import org.junit.*;
public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }
    @Test
    public void test2() throws IOException{
        List<String> x = List.of("https://something.com", "some-thing.html");
        Path fileName = Path.of("test-file.md");
        String content = Files.readString(fileName);
        assertEquals(x, MarkdownParse.getLinks(content));
    }
    @Test
    public void test3() throws IOException{
        List<String> x = List.of();
        Path fileName = Path.of("test-2.md");
        String content = Files.readString(fileName);
        assertEquals(x, MarkdownParse.getLinks(content));    
    }
    @Test
    public void test4() throws IOException{
        List<String> x = List.of("https://en.wikipedia.org/wiki/Day_One_(app)");
        Path fileName = Path.of("test-4.md");
        String content = Files.readString(fileName);
        assertEquals(x, MarkdownParse.getLinks(content));   
    }
    @Test
    public void test5() throws IOException{
        List<String> x = List.of("https://something.com", "some-page.html");
        Path fileName = Path.of("test-file2.md");
        String content = Files.readString(fileName);
        assertEquals(x, MarkdownParse.getLinks(content));   
    }
    @Test
    public void test6() throws IOException{
        List<String> x = List.of();
        Path fileName = Path.of("test-file3.md");
        String content = Files.readString(fileName);
        assertEquals(x, MarkdownParse.getLinks(content));   
    }
    @Test
    public void test7() throws IOException{
        List<String> x = List.of();
        Path fileName = Path.of("test-file4.md");
        String content = Files.readString(fileName);
        assertEquals(x, MarkdownParse.getLinks(content));   
    }
    @Test
    public void test8() throws IOException{
        List<String> x = List.of();
        Path fileName = Path.of("test-file5.md");
        String content = Files.readString(fileName);
        assertEquals(x, MarkdownParse.getLinks(content));   
    }
    @Test
    public void test9() throws IOException{
        List<String> x = List.of();
        Path fileName = Path.of("test-file6.md");
        String content = Files.readString(fileName);
        assertEquals(x, MarkdownParse.getLinks(content));   
    }
    @Test
    public void test10() throws IOException{
        List<String> x = List.of();
        Path fileName = Path.of("test-file7.md");
        String content = Files.readString(fileName);
        assertEquals(x, MarkdownParse.getLinks(content));   
    }
    @Test
    public void test11() throws IOException{
        List<String> x = List.of("a link on the first line");
        Path fileName = Path.of("test-file8.md");
        String content = Files.readString(fileName);
        assertEquals(x, MarkdownParse.getLinks(content));   
    }
}