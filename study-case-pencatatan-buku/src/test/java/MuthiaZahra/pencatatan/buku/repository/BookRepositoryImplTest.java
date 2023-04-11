package MuthiaZahra.pencatatan.buku.repository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.zaxxer.hikari.HikariDataSource;

import MuthiaZahra.pencatatan.buku.Repository.BookRepository;
import MuthiaZahra.pencatatan.buku.Repository.Impl.BookRepositoryImpl;
import MuthiaZahra.pencatatan.buku.entity.Book;
import MuthiaZahra.pencatatan.buku.util.DatabaseUtil;

public class BookRepositoryImplTest {
     //Data Source

   private static HikariDataSource dataSource;

   //Book Repository 
   private BookRepository bookRepository;


   

@BeforeEach
   void setup(){
    dataSource = DatabaseUtil.getDataSource();
    bookRepository = new BookRepositoryImpl(dataSource);  

   }

@Test
void testAddBook(){
    //initialize
    Book book = new Book();

    //set Value
    book.setTitle("Kamu dan September");
    book.setAuthor("Muthia");
    book.setyear(2022);

    //AddBook
    bookRepository.add(book);
}

@Test
void testGetAllBook(){
    Book [] list = bookRepository.getAll();

}



@AfterEach
void tearDown(){
    dataSource.close();

}
    
}

