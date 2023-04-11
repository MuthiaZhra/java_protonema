package muthiasahi.aplikasi.java.service.Impl;

import muthiasahi.aplikasi.java.entity.Identitas;
import muthiasahi.aplikasi.java.repository.IdentitasRepository;
import muthiasahi.aplikasi.java.service.IdentitasService;

public class IdentitasServiceImpl  implements IdentitasService{
    private IdentitasRepository identitasRepository;

    public IdentitasServiceImpl (IdentitasRepository identitasRepository) {
        this.identitasRepository= identitasRepository;
    }

    @Override
    public void add(String nama, String umur, String jeniskelamin) {
          // Initialize
          Identitas identitas = new Identitas(nama, umur, jeniskelamin);
 
          // Add Book
          identitasRepository.add(identitas);
  
          // Return
          System.out.println("Identitas Berhasil Ditambah : " + identitas.getNama());
    }

    @Override
    public void getAll() {
        // Initialize
        Identitas[] list = identitasRepository.getAll();
 
        // Return
        for (Identitas identitas : list) {
            System.out.println(String.format("%d. %s -- (%s - %s)", identitas.getId(), identitas.getNama(), identitas.getUmur(),
                    identitas.getJeniskelamin()));
        }
    }

    @Override
    public Identitas getByid(Integer id) {
          // Get Data
          Identitas identitas= identitasRepository.getByid(id);
          
 
          // Return
          System.out.println(
                  String.format("%d. %s -- (%s - %s)", identitas.getId(),identitas.getNama(), identitas.getUmur(),identitas.getJeniskelamin()));
        return identitas;
    }

    @Override
    public void Update(Integer id, String nama, String umur , String jeniskelamin) {

        Identitas identitas= identitasRepository.getByid(id);
        // Identitas identitas = IdentitasRepository.getById(id);
        if (identitas!= null) {
            identitas.setNama(nama);
            identitas.setUmur(umur);
            identitas.setJeniskelamin(jeniskelamin);
            identitasRepository.update(identitas);
        } else {
            System.out.println("Karyawan Dengan ID " + id + " not found.");
        }

        //  //Initialize
        //  Identitas identitas = new Identitas(id, nama, umur, jeniskelamin);
 
        //  // Updateidentitas
        // identitasRepository.update(identitas);
 
        //  // Return
        //  System.out.println("Identitas Berhasil Diperbaharui: " + identitas.getNama());

    }

         



    //      try {  
    //         // ambil input dari user
    //         System.out.print("ID yang mau diedit: ");
    //         int idBuku = Integer.parseInt(input.readLine());
    //         System.out.print("Judul: ");
    //         String judul = input.readLine().trim();
    //         System.out.print("Pengarang: ");
    //         String pengarang = input.readLine().trim();
    
    //         // query update
    //         String sql = "UPDATE buku SET judul='%s', pengarang='%s' WHERE id_buku=%d";
    //         sql = String.format(sql, judul, pengarang, idBuku);
    
    //         // update data buku
    //         stmt.execute(sql);
            
    //     } catch (Exception e) {
    //         e.printStackTrace();
    //     }
    // }

    @Override
    public void Delete(Integer id) {
          // Delete Data
          boolean success = identitasRepository.delete(id); // true or false
 
          if (success == true) {
              // Return
              System.out.println(" Identitas Berhasil Di Hapus : " + id);
          } else {
              // Return
              System.out.println(" Identitas Gagal Hapus : " + id);
          }
    }
    
}
