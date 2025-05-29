public class Book {
    private String title;
    private String author;
    boolean isAvailable;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }

    public void borrowBook() {
        this.isAvailable = false;
    }

    public void displayStatus() {
        System.out.printf("Book: %s by %s (Available: %b)%n", title, author, isAvailable);
    }
}

