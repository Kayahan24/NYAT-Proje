package nyat_proje;

public class SicaklikAlgilayici implements Observer{
	private int sicaklik;
	private SicaklikGoruntule sicaklikGoruntule;
	
	public SicaklikAlgilayici() {
		sicaklikGoruntule=new SicaklikGoruntule();
	}
	@Override
	public void update(int sicaklik) {
		this.sicaklik=sicaklik;
		sicaklikGoruntule.islemYap(sicaklik);
	}
	public SicaklikGoruntule getSicaklikGoruntule() {
		return this.sicaklikGoruntule;
	}
}
