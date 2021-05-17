package nyat_proje;
import java.util.*;

public class AnaIslemPlatformu {
	private MevcutOrtam mevcutOrtam;
	private AgArayuzu agArayuzu;
	private Eyleyici eyleyici;
	private VeriTabani veriTabani;
	private SicaklikAlgilayici sicaklikAlgilayici;
	
	public AnaIslemPlatformu() {
		this.agArayuzu=new AgArayuzu();
		this.eyleyici=new Eyleyici();
		this.veriTabani=new PostgresqlSurucu();
		this.mevcutOrtam=new MevcutOrtam();
		this.sicaklikAlgilayici=new SicaklikAlgilayici();
		mevcutOrtam.addObserver(sicaklikAlgilayici);
	}
	
	
	void basla() throws InterruptedException {
		Scanner scanner=new Scanner(System.in);
		//VeriTabani vt=new PostgresqlSurucu();
		Kullanici kullanici = null;
		boolean isTrue=false;
		while(!isTrue) {
			System.out.println("Kullanýcý Adýnýzý Giriniz: ");
			String kullaniciAdi=scanner.nextLine();
			System.out.println("Parolanýzý Girin: ");
			String parola=scanner.nextLine();
			kullanici=new Kullanici.KullaniciBuilder().kullaniciAdi(kullaniciAdi).parola(parola).build();
			this.veriTabani.kullaniciDogrula(kullanici);
			isTrue=kullanici.getIsLogin();
		}
		while(true) {
			agArayuzu.menu(kullanici.getKullaniciAdi(),eyleyici.sogutucuyuKontrolEt());
			if(agArayuzu.getSecim()==1) {
				mevcutOrtam.notifyObservers();
				agArayuzu.mesajYaz("Mevcut Sýcaklýk "+sicaklikAlgilayici.getSicaklikGoruntule().getSicaklik()+" Derece"); ;
			}else if(agArayuzu.getSecim()==2) {
				if(!eyleyici.sogutucuyuKontrolEt()) {
					eyleyici.getSogutucuAc().islemYap(eyleyici);
					agArayuzu.mesajYaz("Soðutucu Açýldý.");
				}else {
					agArayuzu.mesajYaz("Soðutucu Zaten Açýk.");
				}
			}else if(agArayuzu.getSecim()==3) {
				if(eyleyici.sogutucuyuKontrolEt()) {
					eyleyici.getSogutucuKapat().islemYap(eyleyici);
					agArayuzu.mesajYaz("Soðutucu Kapatýldý.");
				}else {
					agArayuzu.mesajYaz("Soðutucu Zaten Kapalý.");
				}
			}else if(agArayuzu.getSecim()==4) {
				agArayuzu.mesajYaz("Sistemden çýkýþ yapýldý. Ýyi günler "+kullanici.getKullaniciAdi());
				scanner.close();
				System.exit(0);
			}else {
				agArayuzu.mesajYaz("Lütfen geçerli bir seçim giriniz.");
			}
		}
	}
}
