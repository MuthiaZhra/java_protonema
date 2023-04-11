package muthiasahi.aplikasi.java.entity;

public class Identitas {

    
    //ATRIBUT

    private Integer id;
    private  String nama;
    private  String umur;
    private String jeniskelamin;

    public Identitas(){

    }

    public Identitas (Integer id,String nama,String umur, String jeniskelamin){
        this.nama=nama;
        this.umur=umur;
        this.jeniskelamin=jeniskelamin;


    }

    public Identitas (String nama, String umur, String jeniskelamin){
        this.nama=nama;
        this.umur=umur;
        this.jeniskelamin=jeniskelamin;
    
    
    }
    
    //getter
    
    public Integer getId(){
        return id;
    
    }
    public String getNama(){
        return nama;
    
    }
    public String getUmur(){
        return umur;
    
    }
    public String getJeniskelamin(){
        return jeniskelamin;
    
    }
    
    //setter
    
    public void setId(Integer id){
        this.id=id;
    }
    public void setNama(String nama){
        this.nama=nama;
    }
    public void setUmur(String umur){
        this.umur=umur;
    }
    public void setJeniskelamin(String jeniskelamin){
        this.jeniskelamin=jeniskelamin;
    }
    
}
