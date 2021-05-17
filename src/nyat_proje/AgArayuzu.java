package nyat_proje;

import java.util.*;

public class AgArayuzu {
	private int secim;
	
	public AgArayuzu() {
		this.secim=0;
	}
	public void setSecim(int secim) {
		this.secim=secim;
	}
	public int getSecim() {
		return this.secim;
	}
	
	public void menu(String kullaniciAdi,boolean cihazDurumu) throws InterruptedException {
		Scanner scanner=new Scanner(System.in);
		System.out.print("\n\nCihaz Durumu: ");
		if(cihazDurumu) {
			System.out.println("Açýk");
		}else {
			System.out.println("Kapalý");
		}
		System.out.println("\n1. Sýcaklýk Görüntüle");
		System.out.println("2. Soðutucu Aç");
		System.out.println("3. Soðutucu Kapat");
		System.out.println("4. Çýkýþ \n");
		System.out.print("Seçim: ");
		int secim;
		String secimLine=scanner.nextLine();
		try {
			secim=Integer.parseInt(secimLine);
		}catch(NumberFormatException e) {
			secim=0;
		}
		setSecim(secim);
		//scanner.close();
	}
	public void mesajYaz(String mesaj) throws InterruptedException {
		
		for(int i=0;i<50;i++) {
			System.out.print("-");
			Thread.sleep(5);
		}
		System.out.print("\n");
		System.out.println("Mesaj: "+mesaj);
		for(int i=0;i<50;i++) {
			System.out.print("-");
			Thread.sleep(5);
		}
		System.out.println("\n");
	}
}
