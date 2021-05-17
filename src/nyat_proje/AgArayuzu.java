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
			System.out.println("A��k");
		}else {
			System.out.println("Kapal�");
		}
		System.out.println("\n1. S�cakl�k G�r�nt�le");
		System.out.println("2. So�utucu A�");
		System.out.println("3. So�utucu Kapat");
		System.out.println("4. ��k�� \n");
		System.out.print("Se�im: ");
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
