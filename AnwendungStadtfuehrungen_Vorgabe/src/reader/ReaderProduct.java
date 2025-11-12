package reader;

import java.io.IOException;

import business.Volkshochschulkurs;

public abstract class ReaderProduct {
	
	public abstract Volkshochschulkurs[] leseAusdatei()throws IOException;

}
