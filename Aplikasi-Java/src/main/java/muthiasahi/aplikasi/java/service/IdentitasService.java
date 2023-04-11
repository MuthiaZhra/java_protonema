package muthiasahi.aplikasi.java.service;

import muthiasahi.aplikasi.java.entity.Identitas;

public interface IdentitasService {

     //add
     public void add(String nama, String umur, String jeniskelamin);

     //getAll
     public void getAll();
 
     //get By id
     public Identitas getByid(Integer id);
 
     //Update
     public void Update(Integer id, String nama, String umur, String jeniskelamin);
 
     //Delete
 
     public void Delete(Integer id);
    
}
