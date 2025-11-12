package business;



import java.io.IOException;

import reader.ConcreteReaderCreator;
import reader.ReaderCreator;
import reader.ReaderProduct;
import writer.ConcreteCreator;
import writer.Creator;
import writer.Product;
public class VolkshochschuleModel {

	Volkshochschulkurs volkshochschulkurs;
	Volkshochschulkurs[]kurs;
	
	public Volkshochschulkurs getVolkshochschulkurs() {
		return volkshochschulkurs;
	}

	public void setVolkshochschulkurs(Volkshochschulkurs volkshochschulkurs) {
		this.volkshochschulkurs = volkshochschulkurs;
	}

	public void schreibeVolkshochschulenInCsvDatei()throws IOException {
		
			Creator creator=new ConcreteCreator();
			Product writer=creator.factoryMethod();
			writer.fuegeInDateiHinzu(volkshochschulkurs);
			writer.schliesseDatei();  			
		
	}
	
	public void leseVolkshochschuleAusCsvDatei()throws IOException{
		
		ReaderCreator readercreator=new ConcreteReaderCreator();
		ReaderProduct reader=readercreator.factoryMethod("csv");
		this.kurs=reader.leseAusdatei();
		
	}
	
	public void leseVolkshochschuleAusTxtDatei()throws IOException{
		
		ReaderCreator readercreator=new ConcreteReaderCreator();
		ReaderProduct reader=readercreator.factoryMethod("txt");
		this.kurs=reader.leseAusdatei();
		
	}
}