package reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import business.Volkshochschulkurs;

public class ConcreteCsvReaderProduct extends ReaderProduct {
	
	

	@Override
	public Volkshochschulkurs[] leseAusdatei() throws IOException {
		
		BufferedReader ein=new BufferedReader(new FileReader ("VolkshochschulkurseAusgabe.csv"));
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
		    /*System.out.println("Gelesener Kurs:");
		    System.out.println("Name: " + daten[0]);
		    System.out.println("Beitrag: " + daten[1]);
		    System.out.println("Wochentag: " + daten[2]);
		    System.out.println("Startuhrzeit: " + daten[3]);
		    System.out.println("Vorkenntnisse: " + daten[4]);*/
		    anzahl++;
		}

		ein.close();
		Volkshochschulkurs[] ergebnis = new Volkshochschulkurs[anzahl];
		System.arraycopy(kurse, 0, ergebnis, 0, anzahl);
		return ergebnis;
	}
	
	

}
