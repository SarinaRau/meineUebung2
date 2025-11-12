package writer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import business.Volkshochschulkurs;

public class ConcreteProduct extends Product {
	
	private BufferedWriter aus;
	
	

	public ConcreteProduct() throws IOException  {
		aus= new BufferedWriter(new FileWriter("VolkshochschulkurseAusgabe.csv", true));
	}

	@Override
	public void fuegeDateiHinzu(Volkshochschulkurs kurs)throws IOException {
		
		aus.write(kurs.gibVolkshochschuleZurueck(';'));
		
		
	}

	@Override
	public void schliesseDatei()throws IOException {
		aus.close();
		
	}

	
}
