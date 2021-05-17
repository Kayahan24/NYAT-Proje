package nyat_proje;

public class Eyleyici {
	private boolean isAcik;
	private SogutucuAc sogutucuAc;
	private SogutucuKapat sogutucuKapat;
	
	public Eyleyici() {
		this.isAcik=false;
		this.sogutucuAc=new SogutucuAc();
		this.sogutucuKapat=new SogutucuKapat();
	}
	public boolean sogutucuyuKontrolEt() {
		return this.isAcik;
	}
	public SogutucuAc getSogutucuAc() {
		return this.sogutucuAc;
	}
	public SogutucuKapat getSogutucuKapat() {
		return this.sogutucuKapat;
	}
	public void setIsAcik() {
		this.isAcik=!this.isAcik;
	}
}
