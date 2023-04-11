package MuthiaZahra.pencatatan.buku.Repository;

import MuthiaZahra.pencatatan.buku.entity.Book;

public interface BookRepository {
     // add
     public void add(Book book);

     //getAll
     public Book[] getAll();
 
     //get By id
     public Book getByid(Integer id);
     
     //getUpdate
     public boolean update(Book book);
 
 
     //getdelete
     public boolean delete(Integer id);

  
    
    
}
