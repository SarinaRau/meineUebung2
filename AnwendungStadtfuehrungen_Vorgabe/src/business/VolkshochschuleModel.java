package business;


import java.io.IOException;

import readers.ConcreteReaderCreator;
import writer.Creator;
import writer.Product;
import writer.ConcreteCreator;
import readers.ReaderCreator;
import readers.ReaderProduct;

public class VolkshochschuleModel {

	Volkshochschulkurs volkshochschulkurs;
	Volkshochschulkurs[] kurs=new Volkshochschulkurs[100];
	
	public Volkshochschulkurs getVolkshochschulkurs() {
		return volkshochschulkurs;
	}

	public void setVolkshochschulkurs(Volkshochschulkurs volkshochschulkurs) {
		this.volkshochschulkurs = volkshochschulkurs;
	}

	public void schreibeVolkshochschulenInCsvDatei()throws IOException {
		
			Creator creator=new ConcreteCreator();
			Product writer=creator.factoryMethod();
			writer.fuegeDateiHinzu(volkshochschulkurs);
			writer.schliesseDatei();
   			
		
	}
	
	public void leseVolkshochschuleAusCsvDatei()throws IOException {
		
		ReaderCreator readercreator=new ConcreteReaderCreator();
		ReaderProduct reader=readercreator.factoryMethod("csv");
		this.kurs=reader.leseAusDatei();
		
		
	}
	
	public void leseVolkshochschuleAusTxtDatei()throws IOException {
		ReaderCreator readercreator=new ConcreteReaderCreator();
		ReaderProduct reader=readercreator.factoryMethod("txt");
		this.kurs=reader.leseAusDatei();
		
	}
}