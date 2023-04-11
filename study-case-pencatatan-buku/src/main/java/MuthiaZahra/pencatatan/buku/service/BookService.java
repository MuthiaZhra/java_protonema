package MuthiaZahra.pencatatan.buku.service;

import MuthiaZahra.pencatatan.buku.entity.Book;

public interface BookService {
     //add
     public void add(String title, String author, Integer year);

     //getAll
     public void getAll();
 
     //get By id
     public Book getByid(Integer id);
 
     //Update
     public void Update(Integer id, String title, String author, Integer year);
 
     //Delete
 
     public void Delete(Integer id);
    
}
