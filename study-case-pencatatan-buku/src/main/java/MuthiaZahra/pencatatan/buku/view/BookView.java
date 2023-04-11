package MuthiaZahra.pencatatan.buku.view;

import java.util.Scanner;

import com.mysql.cj.x.protobuf.MysqlxCrud.Update;

import MuthiaZahra.pencatatan.buku.entity.Book;
import MuthiaZahra.pencatatan.buku.service.BookService;
import MuthiaZahra.pencatatan.buku.util.InputUtil;

public class BookView {
    // Book Service
    private BookService bookService;
    private Object s;
    private BookService identitasService;

    public BookView(BookService bookService) {
        this.bookService = bookService;
    }

    // Show Menu
    public void showMenu() {
        while (true) {
            System.out.println("========== MAIN MENU ==========");
            System.out.println("1. Insert Data");
            System.out.println("2. Update Data");
            System.out.println("3. Show Data");
            System.out.println("4. Show Data By Id");
            System.out.println("5. Delete Data");
            System.out.println("X. Exit");
            System.out.println("===============================");

            String input = InputUtil.input("Choose >");

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
                System.out.println("Option doesn't recognized");
            }
        }
    }

    // Insert Data
    public void insertData() {
        // Menu
        System.out.println("========= INSERT DATA =========");

        // Get Data Input
        String title = InputUtil.input("Title");
        String author = InputUtil.input("Author");
        String year = InputUtil.input("Year");

        // Add Data
        bookService.add(title, author, Integer.valueOf(year));
    }

    // Update Data
    public void updateData() {
        // Menu
        System.out.println("========== UPDATE DATA ==========");

       

        Scanner scanner = new Scanner(System.in);
   
       System.out.print("Masukan ID Karyawan: ");
   
       Integer id = scanner.nextInt();

       Book book = bookService.getByid(id);
   
       scanner.nextLine(); // Consume newline left-over
   
       System.out.print("Masukan Title Baru : ");
   
       String title = scanner.nextLine();
   
       System.out.print("Masukkan Author: ");
   
       String author = scanner.nextLine();
   
       System.out.print("Masukkan Year: ");
   
       String year= scanner.nextLine();
   
     bookService.Update(id, title, author, id);
   
       System.out.println("Updated Data Succesfully");

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
        System.out.println("========== SHOW DATA ==========");

        // Get Data
        bookService.getAll();
    }

    // Show Data By Id
    public void showById() {
        // Menu
        System.out.println("========= SHOW DATA BY ID =========");

        // Get Data Input
        String id = InputUtil.input("Id Book");

        // Get Data
        bookService.getByid(Integer.valueOf(id));
    }

    // Delete Data
    public void deleteData() {
        // Menu
        System.out.println("========== DELETE BOOK ==========");

        // Get Data Input
      String id = InputUtil.input("Id");

        // Delete Data
       bookService.Delete(Integer.valueOf(id));
    }
}
