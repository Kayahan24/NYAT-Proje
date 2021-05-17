package nyat_proje;

public class Kullanici {
	//fields
	private final int id;
	private final String kullaniciAdi;
	private final String parola;
	private final String ad; 
    private final String soyad; 
    private final String telefon; 
    private final String adres;
    private  boolean isLogin=false;
    private static int hak=3;
    //injection builder to constructor
    private Kullanici(KullaniciBuilder builder) {
        this.id=builder.id;
        this.kullaniciAdi=builder.kullaniciAdi;
        this.parola=builder.parola;
        this.ad=builder.ad;
        this.soyad=builder.soyad;
        this.telefon=builder.telefon;
        this.adres=builder.adres;
    }
    //getter methods
    public int getId() {
    	return this.id;
    }
    public String getKullaniciAdi() {
    	return this.kullaniciAdi;
    }
    public String getParola() {
    	return this.parola;
    }
    public String getAd() {
    	return this.ad;
    }
    public String getSoyad() {
    	return this.soyad;
    }
    public String getTelefon() {
    	return this.telefon;
    }
    public String getAdres() {
    	return this.adres;
    }
    public boolean getIsLogin() {
    	return this.isLogin;
    }
    public int getHak() {
    	return this.hak;
    }
    public void setHak(int hak) {
    	this.hak=hak;
    }
    public void setIsLogin(boolean isLogin) {
    	this.isLogin=isLogin;
    }
    @Override
    public String toString() {
    	return "Kullanici Adý: "+this.kullaniciAdi+"\nKullanýcý Parolasý: "+this.parola+"\n";
    }
    //Builder inner class
    public static class KullaniciBuilder 
    {
    	private int id;
    	private String kullaniciAdi;
    	private String parola;
    	private String ad; 
        private String soyad;
        private String telefon; 
        private String adres; 
 
       
        public KullaniciBuilder id(int id) {
            this.id = id;
            return this;
        }
        public KullaniciBuilder kullaniciAdi(String kullaniciAdi) {
            this.kullaniciAdi = kullaniciAdi;
            return this;
        }
        public KullaniciBuilder parola(String parola) {
        	this.parola=parola;
        	return this;
        }
        public KullaniciBuilder ad(String ad) {
        	this.ad=ad;
        	return this;
        }
        public KullaniciBuilder soyad(String soyad) {
        	this.soyad=soyad;
        	return this;
        }
        public KullaniciBuilder telefon(String telefon) {
        	this.telefon=telefon;
        	return this;
        }
        public KullaniciBuilder adres(String adres) {
        	this.adres=adres;
        	return this;
        }
        
        
        //Return the finally constructed User object
        public Kullanici build() {
            Kullanici kullanici =  new Kullanici(this);
            return kullanici;
        }
    }
}
