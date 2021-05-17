package nyat_proje;

public class SicaklikGoruntule implements Islem {
	private int sicaklik;
	@Override
	public void islemYap(Eyleyici eyleyici) {
		
		
	}

	@Override
	public void islemYap(int sicaklik) {
		this.sicaklik=sicaklik;
	}
	public int getSicaklik() {
		return sicaklik;
	}

}
