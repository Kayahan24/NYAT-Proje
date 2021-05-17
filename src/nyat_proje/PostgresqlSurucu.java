package nyat_proje;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PostgresqlSurucu implements VeriTabani{

	

	@Override
	public void kullaniciDogrula(Kullanici kullanici) throws InterruptedException {
		String jdbcURL="jdbc:postgresql://localhost:5432/postgres";
		String username="postgres";
		String password="123";
		
		try {
			Connection connection=DriverManager.getConnection(jdbcURL,username,password);
			System.out.println("Sunucuya ba�lan�yor...");
			Thread.sleep(1000);
			System.out.println("Sunucuya ba�land�");
			Thread.sleep(1000);
			String sql="SELECT * FROM \"Kullanicilar\"";
			Statement statement=connection.createStatement();
			ResultSet result=statement.executeQuery(sql);
			boolean isTrue=false;
			while(result.next()) {
				String kullaniciAdi=result.getString("kullaniciAdi");
				String parola=result.getString("parola");
				if(kullaniciAdi.equals(kullanici.getKullaniciAdi())  && parola.equals(kullanici.getParola())) {
					isTrue=true;
				}
			}
			if(isTrue) {
				System.out.println("Kullan�c� Giri�i Ba�ar�l�.");
				kullanici.setIsLogin(isTrue);
			}else {
				kullanici.setHak(kullanici.getHak()-1);
				System.out.println("Kullan�c� ad� ya da parola yanl��! Kalan Hakk�n�z "+kullanici.getHak());
				kullanici.setIsLogin(isTrue);
				
				if(kullanici.getHak() == 0) {
					System.out.println("Hesab�n�z Ge�ici Olarak Bloke Edilmi�tir.");
					System.exit(0);
				}
			}
			connection.close();
			
		}catch(SQLException e) {
			System.out.println("Sunucuya ba�lan�rken hata olu�tu.");
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
