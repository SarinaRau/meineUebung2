package readers;
import java.io.IOException;

import business.Volkshochschulkurs;

public abstract class ReaderProduct {
	
	public abstract Volkshochschulkurs[] leseAusDatei() throws IOException;

}
