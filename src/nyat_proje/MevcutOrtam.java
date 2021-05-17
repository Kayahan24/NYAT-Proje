package nyat_proje;

import java.util.ArrayList;
import java.util.Random;

public class MevcutOrtam implements Subject{
	private ArrayList<Observer> observers;
	private int sicaklik;
	
	public MevcutOrtam() {
		observers=new ArrayList<Observer>();
		
	}
	@Override
	public void addObserver(Observer observer) {
		observers.add(observer);
	}

	@Override
	public void removeObserver(Observer observer) {
		int i=observers.indexOf(observer);
		if(i>0) {
			observers.remove(i);
		}
	}

	@Override
	public void notifyObservers() {
		Random r=new Random();
		//Random sýcaklýk 10-30 arasý oluþturur
		sicaklik=10+r.nextInt(21);
		for(Observer observer : observers) {
			observer.update(sicaklik);
		}
		
	}

}
