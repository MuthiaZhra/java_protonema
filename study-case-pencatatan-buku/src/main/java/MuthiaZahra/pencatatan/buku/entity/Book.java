package MuthiaZahra.pencatatan.buku.entity;

public class Book {

    private Integer id;
   private String title;
   private String author;
   private Integer year;

   public Book(){

   }

   public Book (Integer id,String title, String author, Integer year){
    this.title=title;
    this.author=author;
    this.year=year;


}
   public Book (String title, String author, Integer year){
    this.title=title;
    this.author=author;
    this.year=year;


}

//getter

public Integer getId(){
    return id;

}
public String getTitle(){
    return title;

}
public String geAuthor(){
    return author;

}
public Integer getYear(){
    return year;

}

//setter

public void setId(Integer id){
    this.id=id;
}
public void setTitle(String title){
    this.title=title;
}
public void setAuthor(String author){
    this.author=author;
}
public void setyear(Integer year){
    this.year=year;
}

    
}
