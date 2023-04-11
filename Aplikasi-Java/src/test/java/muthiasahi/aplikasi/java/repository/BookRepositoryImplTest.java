package muthiasahi.aplikasi.java.repository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.zaxxer.hikari.HikariDataSource;

import muthiasahi.aplikasi.java.entity.Identitas;
import muthiasahi.aplikasi.java.repository.Impl.IdentitasRepositoryImpl;
import muthiasahi.aplikasi.java.util.DatabaseUtil;

public class BookRepositoryImplTest {
     //Data Source

   private static HikariDataSource dataSource;

   //Book Repository 
   private IdentitasRepository identitasRepository;

   @BeforeEach
   void setup(){
    dataSource = DatabaseUtil.getDataSource();
    identitasRepository= new IdentitasRepositoryImpl(dataSource);  

   }

   @Test
    void testAddIdentitas(){
    //initialize
    Identitas identitas = new Identitas();

    //set Value
    identitas.setNama("Muthia Zahra");
    identitas.setUmur("17 tahun");
    identitas.setJeniskelamin("Perempuan");

    //AddIdentitas
    identitasRepository.add(identitas);
}

@Test
void testGetAllBook(){
    Identitas [] list = identitasRepository.getAll();

}

@AfterEach
void tearDown(){
    dataSource.close();

}
    
}
