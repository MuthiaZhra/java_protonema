package MuthiaZahra.pencatatan.buku.service.Impl;

import MuthiaZahra.pencatatan.buku.Repository.BookRepository;
import MuthiaZahra.pencatatan.buku.entity.Book;
import MuthiaZahra.pencatatan.buku.service.BookService;

public class BookServiceImpl  implements BookService{

     private BookRepository bookRepository;
    private BookRepository bookRepositoryy;

     public BookServiceImpl(BookRepository bookRepository) {
         this.bookRepository = bookRepository;
     }
 
     @Override
     public void add(String title, String author, Integer year) {
         // Initialize
         Book book = new Book(title, author, year);
 
         // Add Book
         bookRepository.add(book);
 
         // Return
         System.out.println("Book Added Successfully : " + book.getTitle());
     }
 
     @Override
     public void getAll() {
         // Initialize
         Book[] list = bookRepository.getAll();
 
         // Return
         for (Book book : list) {
             System.out.println(String.format("%d. %s -- (%s - %d)", book.getId(), book.getTitle(), book.geAuthor(),
                     book.getYear()));
         }
     }
 
    
 
     @Override
     public void Update(Integer id, String title, String author, Integer year) {
         // Initialize
        //  Book book = new Book(id, title, author, year);
 
        //  // Update Book
        // bookRepository.update(book);
 
        //  // Return
        //  System.out.println("Book Updated Successfully : " + book.getTitle());


         Book book= bookRepository.getByid(id);
         // Identitas identitas = IdentitasRepository.getById(id);
         if (book!= null) {
             book.setTitle(title);
             book.setAuthor(author);
             book.setyear(year);
             bookRepository.update(book);
         } else {
             System.out.println("Karyawan Dengan ID " + id + " not found.");
         }
 
     }
 
     @Override
     public void Delete(Integer id) {
         // Delete Data
         boolean success = bookRepository.delete(id); // true or false
 
         if (success == true) {
             // Return
             System.out.println(" Book Deleted Successfully : " + id);
         } else {
             // Return
             System.out.println(" Failed to Deleted Book : " + id);
         }
     }

    @Override
    public Book getByid(Integer id) {
         // Get Data
         Book book = bookRepository.getByid(id);
 
         // Return
         System.out.println(
                 String.format("%d. %s -- (%s - %d)", book.getId(), book.getTitle(), book.geAuthor(), book.getYear()));
        return book;
        
    }

    
}
