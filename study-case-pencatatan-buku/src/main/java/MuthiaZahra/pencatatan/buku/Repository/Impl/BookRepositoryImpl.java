package MuthiaZahra.pencatatan.buku.Repository.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import MuthiaZahra.pencatatan.buku.Repository.BookRepository;
import MuthiaZahra.pencatatan.buku.entity.Book;

public class BookRepositoryImpl implements BookRepository {

    private DataSource dataSource;

    public BookRepositoryImpl(DataSource dataSource){
        this.dataSource=dataSource;
    }

    @Override
    public void add(Book book) {
         //Query
         String sql = "INSERT INTO book(title , author, year) VALUES (?,?,?)";
        
         //Execute/ Handle Write to database
         try (Connection connection = dataSource.getConnection(); 
         PreparedStatement statement = connection.prepareStatement(sql)){
 
             //Set Value
             //Set String(index,value)
 
             statement.setString(1,book.getTitle());
             statement.setString(2,book.geAuthor());
             statement.setInt(3, book.getYear());
 
             //Execute Update
             statement.executeUpdate(); 
         } 
         catch (SQLException e){
 
        throw new RuntimeException(e);
         } 
    }

    @Override
    public Book[] getAll() {
        //Query
       String query= "SELECT id, title, author, year FROM book";

       //Execute Handle SELECT fROM DATABASE
       try(Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement(); 
        ResultSet resultSet = statement.executeQuery(query)) {
 
       
         //initialize
         List<Book> list = new ArrayList<Book>();
 
         while (resultSet.next()) {
             //initialize
             Book book = new Book();
             
             //Set value
 
             book.setId(resultSet.getInt("id"));
             book.setTitle(resultSet.getString("title"));
             book.setAuthor(resultSet.getString("author"));
             book.setyear(resultSet.getInt("year"));
 
             //add book to list of book
             list.add(book);
 
 
         }
 
         //return list
         return list.toArray(new Book[] {});
         
       } catch (SQLException e) {
         throw new RuntimeException(e);
         
       }

    }

    @Override
    public Book getByid(Integer id) {
           //Query
           String query = "SELECT id, title, author, year FROM book WHERE id = ?";
       
 
           //Execute // Handle  Select from database
           try(Connection connection = dataSource.getConnection(); 
              PreparedStatement statement= connection.prepareStatement(query)) {
     
             //Set value
             statement.setInt(1, id);
            //Execute
     
            try(ResultSet resultSet = statement.executeQuery();
            ){
             
            //Initialize 
            Book book = new Book();
     
            while (resultSet.next()) {
    
              //Set Value FROM DATABASE
             book.setId(resultSet.getInt("id"));
             book.setTitle(resultSet.getString("title"));
             book.setAuthor(resultSet.getString("author"));
             book.setyear(resultSet.getInt("year"));
     
            }
             //return Book
             return book;
             
            }
     
           
           } catch (SQLException e ) {
             throw new RuntimeException(e);
     
           }
        }
    

    @Override
    public boolean update(Book book) {
       
        String query = "UPDATE book SET title = ?, author = ?, year = ? WHERE id = ?";

        //Execute Handle For database
        try(Connection connection = dataSource.getConnection(); 
          PreparedStatement statement = connection.prepareStatement(query)) {

            //Set Value
            statement.setString(1, book.getTitle());
            statement.setString(2, book.geAuthor());
            statement.setInt(3, book.getYear());
            statement.setInt(4, book.getId());

            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;

            // //Executie

            // try(ResultSet resultSet = statement.executeQuery()){

            //   //return
            //    if(resultSet.next()){
            //     return true;
            //    }
            //     return false;

            //   }      
            
            
        } catch (SQLException e) {
            throw new  RuntimeException(e);
        }
       
    }

    @Override
    public boolean delete(Integer id) {
        String query = "DELETE FROM book WHERE id = ?";
      
        try(Connection connection  = dataSource.getConnection();
         PreparedStatement statement = connection.prepareStatement(query)) {
          
  
          //set Value
          statement.setInt(1, id);
          int rowsDeleted = statement.executeUpdate();

        return rowsDeleted > 0;

        
  
          //Execute
        //   try(ResultSet resultSet = statement.executeQuery()){
        //       //Return
        //       if(resultSet.next()){
        //           return true;
        //       } 

        //       return false;
        //   }
          
        } catch (SQLException e) {
          throw new RuntimeException();
  
        
        }
    }

  
}
