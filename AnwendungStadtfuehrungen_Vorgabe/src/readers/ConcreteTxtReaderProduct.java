package readers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import business.Volkshochschulkurs;

public class ConcreteTxtReaderProduct extends ReaderProduct {

	@Override
	public Volkshochschulkurs[] leseAusDatei() throws IOException {
		
		BufferedReader ein=new BufferedReader(new FileReader ("VolkshochschulkurseAusgabe.txt"));
		Volkshochschulkurs[] kurse=new Volkshochschulkurs[100];
		String zeile;
		int anzahl=0;
		
		while ((zeile = ein.readLine()) != null) {
		    String[] daten = zeile.split(";");
		    kurse[anzahl] = new Volkshochschulkurs(
		        daten[0],
		        Integer.parseInt(daten[1]),
		        daten[2],
		        Float.parseFloat(daten[3]),
		        daten[4].split(",")
		    );
		    anzahl++;
		}

		ein.close();
		Volkshochschulkurs[] ergebnis = new Volkshochschulkurs[anzahl];
		System.arraycopy(kurse, 0, ergebnis, 0, anzahl);
		return ergebnis;
	}
	
	

}
