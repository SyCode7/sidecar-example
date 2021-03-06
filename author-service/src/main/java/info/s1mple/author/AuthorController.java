package info.s1mple.author;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class AuthorController {

    @Value("${eureka.instance.hostname}")
    private String hostname;

    @Resource
    private BookServiceClient bookServiceClient;

    @GetMapping("/book/{bookId}/author")
    public Author getAuthor(@PathVariable String bookId) {
        Book book = bookServiceClient.getBook(bookId);
        return new Author(book.getAuthorId(), "Jack");
    }

    @GetMapping("/author/{authorId}")
    public String getAuthorDescription(@PathVariable String authorId) {
        return "This is an author description of " + authorId;
    }

    @GetMapping("/name")
    public String getHostname() {
        return hostname;
    }

}
