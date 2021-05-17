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
			System.out.println("Kullan�c� Ad�n�z� Giriniz: ");
			String kullaniciAdi=scanner.nextLine();
			System.out.println("Parolan�z� Girin: ");
			String parola=scanner.nextLine();
			kullanici=new Kullanici.KullaniciBuilder().kullaniciAdi(kullaniciAdi).parola(parola).build();
			this.veriTabani.kullaniciDogrula(kullanici);
			isTrue=kullanici.getIsLogin();
		}
		while(true) {
			agArayuzu.menu(kullanici.getKullaniciAdi(),eyleyici.sogutucuyuKontrolEt());
			if(agArayuzu.getSecim()==1) {
				mevcutOrtam.notifyObservers();
				agArayuzu.mesajYaz("Mevcut S�cakl�k "+sicaklikAlgilayici.getSicaklikGoruntule().getSicaklik()+" Derece"); ;
			}else if(agArayuzu.getSecim()==2) {
				if(!eyleyici.sogutucuyuKontrolEt()) {
					eyleyici.getSogutucuAc().islemYap(eyleyici);
					agArayuzu.mesajYaz("So�utucu A��ld�.");
				}else {
					agArayuzu.mesajYaz("So�utucu Zaten A��k.");
				}
			}else if(agArayuzu.getSecim()==3) {
				if(eyleyici.sogutucuyuKontrolEt()) {
					eyleyici.getSogutucuKapat().islemYap(eyleyici);
					agArayuzu.mesajYaz("So�utucu Kapat�ld�.");
				}else {
					agArayuzu.mesajYaz("So�utucu Zaten Kapal�.");
				}
			}else if(agArayuzu.getSecim()==4) {
				agArayuzu.mesajYaz("Sistemden ��k�� yap�ld�. �yi g�nler "+kullanici.getKullaniciAdi());
				scanner.close();
				System.exit(0);
			}else {
				agArayuzu.mesajYaz("L�tfen ge�erli bir se�im giriniz.");
			}
		}
	}
}
