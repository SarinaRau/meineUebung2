package writer;

import java.io.IOException;

import business.Volkshochschulkurs;

public abstract class Product {
	
	public abstract void fuegeInDateiHinzu(Volkshochschulkurs kurs)throws IOException;
	public abstract void schliesseDatei()throws IOException;

}
