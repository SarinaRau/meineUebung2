package business;


import java.io.IOException;

import fabrik.ConcreteCreator;
import fabrik.Creator;
import fabrik.Product;
import fabrik.ReaderCreator;
import fabrik.ReaderProduct;
import fabrik.ConcreteReaderCreator;

public class VolkshochschuleModel {

	Volkshochschulkurs volkshochschulkurs;
	private Volkshochschulkurs[] kurse= new Volkshochschulkurs[100];
	//private int anzahlKurse;
	
	public Volkshochschulkurs getVolkshochschulkurs() {
		return volkshochschulkurs;
	}

	public void setVolkshochschulkurs(Volkshochschulkurs volkshochschulkurs) {
		this.volkshochschulkurs = volkshochschulkurs;
	}
	
	

	public void schreibeVolkshochschulenInCsvDatei()throws IOException {
		
			Creator writer=new ConcreteCreator();
			Product product= writer.factoryMethod();
			product.fuegeInDateiHinzu(volkshochschulkurs);
			product.schliesseDatei();
   			
		
	}
	
	public void leseAusCsvDatei() throws IOException {
        ReaderCreator readerCreator = new ConcreteReaderCreator();
        ReaderProduct reader = readerCreator.factoryMethod("csv");
        this.kurse=reader.leseAusDatei();
        
        //if (kurse != null && kurse.length > 0) {
            //this.volkshochschulkurs = kurse[0];
            //System.out.println("CSV-Datei erfolgreich eingelesen!\n");
            //for (Volkshochschulkurs kurs : kurse) {
                //if (kurs != null) {
                   // System.out.println(kurs.gibVolkshochschuleZurueck(' '));
                //}
            //}
       // } else {
           // System.out.println("Keine Kurse gefunden!");
	//}
	}
   
	
	public void leseAusTxtDatei() throws IOException {
        ReaderCreator readerCreator = new ConcreteReaderCreator();
        ReaderProduct reader = readerCreator.factoryMethod("txt");
        this.kurse=reader.leseAusDatei();

    
    }
}
