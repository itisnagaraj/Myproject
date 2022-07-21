import java.util.ArrayList;
class Book{
    private int isbnno;
    private String bookName;
    private String author;
    public int getIsbnno() {
        return isbnno;
    }

    public void setIsbnno(int isbnno) {
        this.isbnno = isbnno;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
class Library{
    private ArrayList<Book> bookList = new  ArrayList<Book>();
    public ArrayList<Book> getBookList() {
        return bookList;
    }

    public void setBookList(ArrayList<Book> bookList) {
        this.bookList = bookList;
    }
    public void addBook(Book bobj){
        bookList.add(bobj);
    }
    public boolean isEmpty(){
        if(bookList.size()==0)
            return true;
        return false;
    }
    public ArrayList<Book> viewAllBooks(){
        return bookList;
    }
    public ArrayList<Book> viewBooksByAuthor(String author){
        ArrayList<Book> result=new ArrayList<>();
        for(Book book:bookList){
            if(book.getAuthor().compareTo(author)==0)
                result.add(book);
        }
        return result;
    }
    public int countnoofbook(String bname){
        int count=0;
        for(Book book:bookList){
            if(book.getBookName().compareTo(bname)==0)
                count++;
        }
        return count;
    }
    
}
