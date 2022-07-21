import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main
{
	public static void main(String[] args)throws IOException {
		int choice=0;
		Library library=new Library();
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		while(true){
		    System.out.println("Enter choice\n 1.Add Book \n 2.Display all book details \n 3.Search Book by author \n 4.Count number of books - by book name \n5.Exit");
		    choice = Integer.parseInt(br.readLine());
		    switch(choice){
		        case 1: Book book=new Book();
		                  System.out.println("Enter the isbnno");
		                  int isbnno=Integer.parseInt(br.readLine());
		                  System.out.println("Enter the book name");
		                  String bookName=br.readLine();
		                  System.out.println("Enter the author name");
		                  String authorName=br.readLine();
		                  book.setIsbnno(isbnno);
		                  book.setBookName(bookName);
		                  book.setAuthor(authorName);
		                  library.addBook(book);
		                  break;
		        case 2:
		        	ArrayList<Book> books=library.viewAllBooks();
		               for(Book booky:books){
		                   System.out.println("Isbn is: "+booky.getIsbnno()+" authorName is: "+booky.getAuthor()+" bookName is: "+booky.getBookName());
		               }
		               break;
		        case 3:System.out.println("Enter the author Name:");
		               String Author=br.readLine();
		               ArrayList<Book> books1=library.viewBooksByAuthor(Author);
		               for(Book booky:books1){
		                   System.out.println("Isbn is: "+booky.getIsbnno()+" authorName is: "+booky.getAuthor()+" bookName is: "+booky.getBookName());
		               }
		               break;
		        case 4:System.out.println("Enter the book Name:");
		               String bookname=br.readLine();
		               int count =library.countnoofbook(bookname);
		               System.out.println("The number of books are "+count);
		               break;
		        case 5:System.exit(0);
		    }
		    
		}
		
	}
}