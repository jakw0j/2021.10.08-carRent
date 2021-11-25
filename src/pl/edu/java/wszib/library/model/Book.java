package pl.edu.java.wszib.library.model;

public class Book {
    private String genre;
    private String author;
    private String title;
    private int year;
    private boolean rent;

    public Book(String genre, String author, String title, int year) {
        this.genre = genre;
        this.author = author;
        this.title = title;
        this.year = year;
        this.rent = false;
    }

    public String getGenre() {
        return genre;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public boolean isRent() {
        return rent;
    }

    public void setRent(boolean rent) {
        this.rent = rent;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder
                .append("Book{")
                .append("genre = ")
                .append(this.genre)
                .append(", author = ")
                .append(this.author)
                .append(", year = ")
                .append(this.year)
                .append(", title = ")
                .append(this.title);

        if(this.rent) {
            stringBuilder.append("Not available}");
        } else {
            stringBuilder.append(" Free}");
        }

        return stringBuilder.toString();
    }
}
