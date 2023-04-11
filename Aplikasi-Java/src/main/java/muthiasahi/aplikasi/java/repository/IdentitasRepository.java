package muthiasahi.aplikasi.java.repository;

import muthiasahi.aplikasi.java.entity.Identitas;

public interface IdentitasRepository {
    
     // add
     public void add(Identitas identitas);

     //getAll
     public Identitas[] getAll();
 
     //get By id
     public Identitas getByid(Integer id);
     
     //getUpdate
     public boolean update(Identitas identitas);
 
 
     //getdelete
     public boolean delete(Integer id);

}
