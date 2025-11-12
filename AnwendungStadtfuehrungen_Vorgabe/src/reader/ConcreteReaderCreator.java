package reader;

public class ConcreteReaderCreator extends ReaderCreator {

	@Override
	public ReaderProduct factoryMethod(String typ) {
		
		if("csv".equals(typ)) {
			return new ConcreteCsvReaderProduct();
		}else {
			return new ConcreteTxtReaderProduct();
		}
	}
	
	

}
