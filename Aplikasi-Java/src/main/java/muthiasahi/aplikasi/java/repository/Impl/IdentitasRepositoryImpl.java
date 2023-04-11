package muthiasahi.aplikasi.java.repository.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import muthiasahi.aplikasi.java.entity.Identitas;
import muthiasahi.aplikasi.java.repository.IdentitasRepository;

public class IdentitasRepositoryImpl implements IdentitasRepository {

    private DataSource dataSource;

    public IdentitasRepositoryImpl(DataSource dataSource){
        this.dataSource=dataSource;
    }

    @Override
    public void add(Identitas identitas) {
        //Query
        String sql = "INSERT INTO identitas(nama , umur, jeniskelamin) VALUES (?,?,?)";
        
        //Execute/ Handle Write to database
        try (Connection connection = dataSource.getConnection(); 
        PreparedStatement statement = connection.prepareStatement(sql)){

            //Set Value
            //Set String(index,value)

            statement.setString(1,identitas.getNama());
            statement.setString(2,identitas.getUmur());
            statement.setString(3, identitas.getJeniskelamin());

            //Execute Update
            statement.executeUpdate(); 
        } 
        catch (SQLException e){

       throw new RuntimeException(e);
        } 
    }

    @Override
    public Identitas[] getAll() {
        //Query
        String query= "SELECT id, nama, umur , jeniskelamin FROM Identitas";

        //Execute Handle SELECT fROM DATABASE
        try(Connection connection = dataSource.getConnection();
         Statement statement = connection.createStatement(); 
         ResultSet resultSet = statement.executeQuery(query)) {
  
        
          //initialize
          List<Identitas> list = new ArrayList<Identitas>();
  
          while (resultSet.next()) {
              //initialize
              Identitas identitas = new Identitas();
              
              //Set value
              identitas.setId(resultSet.getInt("id"));
              identitas.setNama(resultSet.getString("nama"));
              identitas.setUmur(resultSet.getString("umur"));
              identitas.setJeniskelamin(resultSet.getString("jeniskelamin"));
          
              //add book to list of book
              list.add(identitas);
  
  
          }
  
          //return list
          return list.toArray(new Identitas[] {});
          
        } catch (SQLException e) {
          throw new RuntimeException(e);
          
        }
    }

    @Override
    public Identitas getByid(Integer id) {
         //Query
         String query = "SELECT id, nama, umur, jeniskelamin FROM Identitas WHERE id = ?";
       
 
         //Execute // Handle  Select from database
         try(Connection connection = dataSource.getConnection(); 
            PreparedStatement statement= connection.prepareStatement(query)) {
   
           //Set value
           statement.setInt(1, id);
          //Execute
   
          try(ResultSet resultSet = statement.executeQuery();
          ){
           
          //Initialize 
          Identitas identitas = new Identitas();
   
          while (resultSet.next()) {
  
            //Set Value FROM DATABASE
           identitas.setId(resultSet.getInt("id"));
           identitas.setNama(resultSet.getString("nama"));
           identitas.setUmur(resultSet.getString("umur"));
           identitas.setJeniskelamin(resultSet.getString("jeniskelamin"));
   
          }
           //return Book
           return identitas;
           
          }
   
         
         } catch (SQLException e ) {
           throw new RuntimeException(e);
   
         }
      }
    

    @Override
    public boolean update(Identitas identitas) {

      // Check if id is not null
      if (identitas.getId() == null) {
        throw new IllegalArgumentException("Cannot update karyawan with null id");
    }

    //query
    String query = "UPDATE identitas SET nama = ?, umur = ?, jeniskelamin = ? WHERE id = ?";

    //execute
    try (Connection connection = dataSource.getConnection(); PreparedStatement statement = connection.prepareStatement(query)){

        //set value
        statement.setString(1, identitas.getNama());
        statement.setString(2, identitas.getUmur());
        statement.setString(3, identitas.getJeniskelamin());
        statement.setInt(4, identitas.getId());

        //execute
        int rowsUpdated = statement.executeUpdate();

        return rowsUpdated > 0;

    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
}
        // String query = "UPDATE Identitas SET nama = ?, umur = ?, jeniskelamin = ? WHERE id = ?";

        // //Execute Handle For database
        // try(Connection connection = dataSource.getConnection(); 
        //   PreparedStatement statement = connection.prepareStatement(query)){


            // //Set Value
            // statement.setString(1, identitas.getNama());
            // statement.setString(2, identitas.getUmur());
            // statement.setString(3, identitas.getJeniskelamin());
            // statement.setInt(4, identitas.getId());

            // int rowsUpdated = statement.executeUpdate();
            // return rowsUpdated > 0;

            // // //Executie

            // // try(ResultSet resultSet = statement.executeQuery()){

        //     //   //return
        //     //    if(resultSet.next()){
        //     //     return true;
        //     //    }
        //     //     return false;

        //     //   }        
        // } catch (SQLException e) {
        //     throw new  RuntimeException(e);
        // }
    

    @Override
    public boolean delete(Integer id) {
        String query = "DELETE FROM identitas WHERE id = ?";
      
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

    

