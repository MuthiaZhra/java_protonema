package muthiasahi.aplikasi.java;



import java.util.Scanner;

import javax.sql.DataSource;


import muthiasahi.aplikasi.java.repository.IdentitasRepository;
import muthiasahi.aplikasi.java.repository.Impl.IdentitasRepositoryImpl;
import muthiasahi.aplikasi.java.service.IdentitasService;
import muthiasahi.aplikasi.java.service.Impl.IdentitasServiceImpl;
import muthiasahi.aplikasi.java.util.DatabaseUtil;
import muthiasahi.aplikasi.java.view.IdentitasView;



public class App {

    public static void main( String[] args )
    {
       Scanner scanner = new Scanner(System.in);
        String username, password, role;
        boolean isLoggedIn = false;

        // Database users
        String[][] users = {
            //credential login / role login
                //username, passwd, role
                {"admin", "admin", "admin"},
                {"muthia", "asahi", "user"},

        };

        do {
            System.out.print("Enter username: ");
            username = scanner.nextLine();
            System.out.print("Enter password: ");
            password = scanner.nextLine();

            // Loop through users
            for (int i = 0; i < users.length; i++) {
                if (username.equals(users[i][0]) && password.equals(users[i][1])) {
                    role = users[i][2];
                    System.out.println("=========================================================================");
                    System.out.println("SELAMAT DATANG DI YG ENTERTAIMENT, " + username + " anda login sebagai, " + role + "");
                    System.out.println("=========================================================================");
                    System.out.println("*************************");
                    System.out.println("                                                                         ");
                    isLoggedIn = true;

               
            if (role.equals("admin")) {
            // datasource
            DataSource dataSource = DatabaseUtil.getDataSource();

            //set data
            IdentitasRepository identitasRepository = new IdentitasRepositoryImpl(dataSource);
            IdentitasService identitasService = new IdentitasServiceImpl(identitasRepository);

            //view
            IdentitasView identitasView = new IdentitasView(identitasService);

            //show view
            identitasView.showMenu();

                } else if (role.equals("user")) { // Rolenya dalah User
                    //fitur user
                  //fitur user
                   // datasource
                   DataSource dataSource = DatabaseUtil.getDataSource();

                   //set data
                   IdentitasRepository identitasRepository = new IdentitasRepositoryImpl(dataSource);
                   IdentitasService identitasService = new IdentitasServiceImpl(identitasRepository);

                   //view
                   IdentitasView identitasView = new IdentitasView(identitasService);

                   //show view
                   identitasView.showMenuUser();
                   // DataSource dataSource = DatabaseUtil.getDataSource();
                   // KaryawanRepo karyawanRepo = new KaryawanRepoImpl(dataSource);
                   // KaryawanService karyawanService = new KaryawanServiceImpl(karyawanRepo);
                   // KaryawanView karyawanView = new KaryawanView(karyawanService);

                   // // Menambahkan filter agar user hanya bisa melihat data saja, tidak bisa CRUD
                   // karyawanView.setCanCreate(false);
                   // karyawanView.setCanUpdate(false);
                   // karyawanView.setCanDelete(false);

                   //show view
                   // karyawanView.showMenu();
               } else {
                   System.out.println("Invalid role. Please try again.");
                   isLoggedIn = false;
               }

               break;
               }
           }
           if (!isLoggedIn) {
               System.out.println("Username dan Password tidak di temukan");
           }
       } while (!isLoggedIn);
   }

}




    // private static final Logger LOGGER = LoggerFactory.getLogger(MyClass.class);
    // private static identitasservice identitaservice;
    // public static void main(String[] args) {
    //     // Datasource
    //     DataSource dataSource = DatabaseUtil.getDataSource();

    //  // Set Datasource
    //  IdentitasRepository bookRepository = new IdentitasRepositoryImpl(dataSource);
    //  IdentitasService bookService = new IdentitasServiceImpl(identitasepository);

    //     // View
    //     IdentitasView bookView = new IdentitasView(bookService);

    //     // Show Menu
    //     identitasView.showMenu();
    // }




    


    


    //    Scanner scanner = new Scanner(System.in);
    //     String username, password, role;
    //     boolean isLoggedIn = false;

    //     // Database users
    //     String[][] users = {
    //         //credential login / role login
    //             //username, passwd, role
    //             {"admin", "admin", "admin"},
    //             {"muthia", "asahi", "user"},

    //     };

    //     do {
    //         System.out.print("Enter username: ");
    //         username = scanner.nextLine();
    //         System.out.print("Enter password: ");
    //         password = scanner.nextLine();

    //         // Loop through users
    //         for (int i = 0; i < users.length; i++) {
    //             if (username.equals(users[i][0]) && password.equals(users[i][1])) {
    //                 role = users[i][2];
    //                 System.out.println("=========================================================================");
    //                 System.out.println("SELAMAT DATANG DI YG ENTERTAIMENT, " + username + " anda login sebagai, " + role + "");
    //                 System.out.println("=========================================================================");
    //                 System.out.println("*************************");
    //                 System.out.println("                                                                         ");
    //                 isLoggedIn = true;

               
    //         if (role.equals("admin")) {
    //         // datasource
    //         DataSource dataSource = DatabaseUtil.getDataSource();

    //         //set data
    //         IdentitasRepository identitasRepository = new IdentitasRepositoryImpl(dataSource);
    //         IdentitasService identitasService = new IdentitasServiceImpl(identitasRepository);

    //         //view
    //         IdentitasView identitasView = new IdentitasView(identitasService);

    //         //show view
    //         identitasView.showMenu();

    //             } else if (role.equals("user")) { // Rolenya dalah User
    //                 //fitur user
    //               //fitur user
    //                // datasource
    //                DataSource dataSource = DatabaseUtil.getDataSource();

    //                //set data
    //                IdentitasRepository identitasRepository = new IdentitasRepositoryImpl(dataSource);
    //                IdentitasService identitasService = new IdentitasServiceImpl(identitasRepository);

    //                //view
    //                IdentitasView identitasView = new IdentitasView(identitasService);

    //                //show view
    //                identitasView.showMenuUser();
    //                // DataSource dataSource = DatabaseUtil.getDataSource();
    //                // KaryawanRepo karyawanRepo = new KaryawanRepoImpl(dataSource);
    //                // KaryawanService karyawanService = new KaryawanServiceImpl(karyawanRepo);
    //                // KaryawanView karyawanView = new KaryawanView(karyawanService);

    //                // // Menambahkan filter agar user hanya bisa melihat data saja, tidak bisa CRUD
    //                // karyawanView.setCanCreate(false);
    //                // karyawanView.setCanUpdate(false);
    //                // karyawanView.setCanDelete(false);

    //                //show view
    //                // karyawanView.showMenu();
    //            } else {
    //                System.out.println("Invalid role. Please try again.");
    //                isLoggedIn = false;
    //            }

    //            break;
    //            }
    //        }
    //        if (!isLoggedIn) {
    //            System.out.println("Username dan Password tidak di temukan");
    //        }
    //    } while (!isLoggedIn);
   




  
    
        
      

    




    

