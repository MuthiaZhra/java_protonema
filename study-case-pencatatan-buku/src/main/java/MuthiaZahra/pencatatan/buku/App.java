package MuthiaZahra.pencatatan.buku;

import javax.sql.DataSource;

import MuthiaZahra.pencatatan.buku.Repository.BookRepository;
import MuthiaZahra.pencatatan.buku.Repository.Impl.BookRepositoryImpl;
import MuthiaZahra.pencatatan.buku.service.BookService;
import MuthiaZahra.pencatatan.buku.service.Impl.BookServiceImpl;
import MuthiaZahra.pencatatan.buku.util.DatabaseUtil;
import MuthiaZahra.pencatatan.buku.view.BookView;

public class App {
    public static void main(String[] args) {
        // Datasource
        DataSource dataSource = DatabaseUtil.getDataSource();

     // Set Datasource
     BookRepository bookRepository = new BookRepositoryImpl(dataSource);
     BookService bookService = new BookServiceImpl(bookRepository);

        // View
        BookView bookView = new BookView(bookService);

        // Show Menu
        bookView.showMenu();
    }
    
}
