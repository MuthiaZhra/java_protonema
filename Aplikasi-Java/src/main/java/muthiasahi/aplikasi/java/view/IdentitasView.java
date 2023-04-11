package muthiasahi.aplikasi.java.view;

import java.util.Scanner;


import muthiasahi.aplikasi.java.entity.Identitas;
import muthiasahi.aplikasi.java.service.IdentitasService;

public class IdentitasView {
     // Book Service
     private IdentitasService identitasService;
    

     public IdentitasView(IdentitasService identitasService){
        this.identitasService=identitasService;
     }
 
     // Show Menu
     public void showMenu() {
         while (true) {
             System.out.println("========== MENU UTAMA==========");
             System.out.println("1. Tambah Data Karyawan");
             System.out.println("2. Pemperbaharui Data Karyawan");
             System.out.println("3. Menampilkan Data Karyawan");
             System.out.println("4. Menampilkan Data Dari Id Karyawan");
             System.out.println("5. Menghapus Data Karyawan");
             System.out.println("<= Exit");
             System.out.println("===============================");
 
             String input = InputUtil.input("Pilih >");
 
             if (input.equals("1")) {
                 insertData();
             } else if (input.equals("2")) {
                updateData();
             } else if (input.equals("3")) {
                 showData();
             } else if (input.equals("4")) {
                 showById();
             } else if (input.equals("5")) {
                 deleteData();
             } else if (input.equals("X")) {
                 break;
             } else {
                 System.out.println("Opsi yang anda pilih tidak ada");
             }
         }
     }
 
     // Insert Data
     public void insertData() {
         // Menu
        System.out.println("========= MENAMBAH DATA =========");

        // Get Data Input
        String nama = InputUtil.input("Nama");
        String umur = InputUtil.input("Umur");
        String jeniskelamin= InputUtil.input("Jenis Kelamin");

        // Add Data
        identitasService.add(nama, umur, jeniskelamin);
       
     }
 
     // Update Data
     public void updateData() {
         // Menu
         System.out.println("========== MEMPERBAHARUI DATA ==========");

         Scanner scanner = new Scanner(System.in);
    
        System.out.print("Masukan ID Karyawan: ");
    
        Integer id = scanner.nextInt();

        Identitas identitas= identitasService.getByid(id);
    
        scanner.nextLine(); // Consume newline left-over
    
        System.out.print("Masukan Nama Baru: ");
    
        String nama = scanner.nextLine();
    
        System.out.print("Masukkan Umur baru: ");
    
        String umur = scanner.nextLine();
    
        System.out.print("Masukkan jenis kelamin: ");
    
        String jeniskelamin= scanner.nextLine();
    
      identitasService.Update(id, nama, umur, jeniskelamin);
    
        System.out.println("Data Berhail di update");
 
        //  // Get Data Input
        //  String nama = InputUtil.input("Nama");
        //  String umur = InputUtil.input("Umur");
        //  String jeniskelamin = InputUtil.input("Jenis kelamin");
 
        //  // Add Data
        // identitasService.Update(null, nama, umur, jeniskelamin);

       
        }
         
     
 
     // Show Data
     public void showData() {
         // Menu
         System.out.println("========== MENAMPILKAN DATA ==========");
 
         // Get Data
         identitasService.getAll();
     }
 
     // Show Data By Id
     public void showById() {
         // Menu
         System.out.println("========= MENAMPILKAN DATA DARI ID =========");
 
        //  // Get Data Input
        //  String id = InputUtil.input("Id Karyawan");
 
        //  // Get Data
        // identitasService.getByid(Integer.valueOf(id));

     

        String id = InputUtil.input("Id");

        //show
        identitasService.getByid(Integer.valueOf(id));
    }

    public void tambah() {
        System.out.println("anda tidak memiliki akses");
    }
    
 
     // Delete Data
     public void deleteData() {
         // Menu
         System.out.println("========== MENGHAPUS DATA KARYAWAN ==========");
 
         // Get Data Input
       String id = InputUtil.input("Id");
 
         // Delete Data
        identitasService.Delete(Integer.valueOf(id));
     }

     //show menu user
    public void showMenuUser(){
        while (true) {
            System.out.println("============ MENU UTAMA ===========");
            System.out.println("1.Menampilkan Data Karyawan");
            System.out.println("2.Menampilkan Data Dari ID");
            System.out.println("X<=.Exit");
            System.out.println("==================================");
            String input = InputUtil.input("Pilih >");

            if(input.equals("1")) {
                showData();
            }else if (input.equals("2")) {
                showById();
            }else if(input.equals("X")) {
                break;
            }else {
                System.out.println("Anda Tidak Memilih");
           }
        }

    }
    
}
