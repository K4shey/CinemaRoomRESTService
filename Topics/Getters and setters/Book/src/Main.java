import java.util.Arrays;

class Book {

    private String title;
    private int yearOfPublishing;
    private String[] authors;

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYearOfPublishing() {
        return this.yearOfPublishing;
    }

    public void setYearOfPublishing(int yearOfPublishing) {
        this.yearOfPublishing = yearOfPublishing;
    }

    public String[] getAuthors() {
        return Arrays.copyOf(authors, authors.length);
    }

    public void setAuthors(String[] authors) {

        if (authors == null) {
            this.authors = new String[0];
        } else {
            this.authors = Arrays.copyOf(authors, authors.length);
        }

    }

}