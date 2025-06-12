public class Book extends Media implements MediaFunctions{
    private String author;
    private int pageCount;

    public Book(String name, String author, int pageCount) {
        this.name = name;
        this.author = author;
        this.pageCount = pageCount;
    }

    // Getter / Setters
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    @Override
    public void play() {
        System.out.printf("Opening book '%s' using e-reader software.%n", name);
    }

    @Override
    public String getDescription() {
        return String.format("Name: %s | Type: %s | Author: %s | Num Pages: %s", name, "Book", author, pageCount);
    }
}
