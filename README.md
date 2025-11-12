Klasse WriterCreator 
 
public abstract class WriterCreator { 
  
 public abstract WriterProduct factoryMethod(); 
 
} 
 
Klasse WriterProduct 
 
public abstract class WriterProduct { 
  
 public abstract void schreibeArtikel( 
  int anzahlArtikel, Artikel[] artikel) 
  throws IOException; 
} 
 
Klasse ConcreteTxtWriterCreator 
 
public class ConcreteTxtWriterCreator extends WriterCreator{ 
  
 @Override 
 public WriterProduct factoryMethod(){ 
  return new ConcreteTxtWriterProduct(); 
 }   
} 
 
Klasse ConcreteTxtWriterProduct 
 
public class ConcreteTxtWriterProduct extends WriterProduct{ 
  
 @Override 
 public void schreibeArtikel(int anzahlArtikel, Artikel[] artikel)  
  throws IOException{ 
  BufferedWriter aus  
    = new BufferedWriter(new FileWriter("Artikel.txt")); 
  aus.write(anzahlArtikel + ""); 
  aus.newLine(); 
  for(int i = 0; i < anzahlArtikel; i++) { 
   aus.write(artikel[i].getArtikelnummer() + ""); 
   aus.newLine(); 
   aus.write(artikel[i].getArtikelname()); 
   aus.newLine(); 
   aus.write(artikel[i].getBasispreis() + ""); 
   aus.newLine();  
  } 
 
 
  2 
  aus.close(); 
 }  
} 
 
In Klasse ArtikelModel 
 
 public void schreibeArtikelInTxtDatei() 
      throws IOException{ 
  WriterCreator writerCreator = new ConcreteTxtWriterCreator(); 
  WriterProduct writer = writerCreator.factoryMethod(); 
  writer.schreibeArtikel(this.getAnzahlArtikel(), this.artikel); 
  } 
 
 
Aufgabe 3.3 
 
Klasse ReaderCreator 
 
public abstract class ReaderCreator {  
 public abstract ReaderProduct factoryMethod(); 
} 
 
Klasse ReaderProduct 
 
public abstract class ReaderProduct { 
 
 public abstract int leseAnzahlArtikel()  
  throws IOException; 
 
 public abstract Artikel[] leseArtikel()  
  throws IOException;  
} 
 
Klasse ConcreteCsvReaderCreator 
 
public class ConcreteCsvReaderCreator extends ReaderCreator{ 
  
 @Override 
 public ReaderProduct factoryMethod(){ 
  return new ConcreteCsvReaderProduct(); 
 }  
} 
 
 
 
 
 
 
 
 
  3 
Klasse ConcreteCsvReaderProduct 
 
public class ConcreteCsvReaderProduct extends ReaderProduct { 
    
 @Override 
 public int leseAnzahlArtikel() throws IOException { 
  int anzahlArtikel = 0; 
  BufferedReader ein  
    = new BufferedReader(new FileReader("Artikel.csv")); 
  anzahlArtikel = Integer.parseInt(ein.readLine()); 
  ein.close(); 
  return anzahlArtikel; 
 } 
 
 @Override 
 public Artikel[] leseArtikel() throws IOException { 
  Artikel[] artikel = new Artikel[100]; 
  BufferedReader ein = new BufferedReader( 
    new FileReader("Artikel.csv")); 
  int anzahlArtikel = Integer.parseInt(ein.readLine()); 
  String[] zeile = null; 
  for(int i = 0; i < anzahlArtikel; i++) { 
   zeile = ein.readLine().split(";"); 
   artikel[i] = new Artikel( 
    Integer.parseInt(zeile[0]), zeile[1], 
    Double.parseDouble(zeile[2])); 
  }     
      ein.close(); 
  return artikel; 
 } 
} 
 
In Klasse ArtikelModel 
 
public void leseArtikelAusCsvDatei() 
        throws IOException{ 
  ReaderCreator readerCreator = new ConcreteCsvReaderCreator(); 
  ReaderProduct reader = readerCreator.factoryMethod(); 
  this.setAnzahlArtikel(reader.leseAnzahlArtikel()); 
  this.artikel = reader.leseArtikel(); 
 } 
 
Aufgabe 3.4.1 
 
Klasse ConcreteKonsoleWriterCreator 
 
public class ConcreteKonsoleWriterCreator extends WriterCreator{ 
 
 @Override 
 public WriterProduct factoryMethod(){ 
  return new ConcreteKonsoleWriterProduct();  
 }   
} 
 
  4 
Klasse ConcreteKonsoleWriterProduct 
 
public class ConcreteKonsoleWriterProduct extends WriterProduct{ 
 
 @Override  
 public void schreibeArtikel(int anzahlArtikel, Artikel[] artikel)  
  throws IOException{ 
  System.out.println("Anzahl vorhandener Artikel: "  
    + anzahlArtikel + ""); 
  System.out.println(""); 
  for(int i = 0; i < anzahlArtikel; i++) { 
    System.out.println("Artikelnummer: " 
     + artikel[i].getArtikelnummer()); 
 
   System.out.println("Artikelname:   "  
     + artikel[i].getArtikelname()); 
   System.out.println("Basispreis:    "  
     + artikel[i].getBasispreis()); 
   System.out.println(""); 
  }     
 }  
} 
 
In Klasse ArtikelModel 
 
public void leseArtikelAusCsvDatei() 
        throws IOException{ 
  ReaderCreator readerCreator = new ConcreteCsvReaderCreator(); 
  ReaderProduct reader = readerCreator.factoryMethod(); 
  this.setAnzahlArtikel(reader.leseAnzahlArtikel()); 
  this.artikel = reader.leseArtikel(); 
 } 
 
 public void schreibeArtikelInKonsole() 
  throws IOException{ 
  WriterCreator writerCreator = new ConcreteKonsoleWriterCreator(); 
  WriterProduct writer = writerCreator.factoryMethod(); 
  writer.schreibeArtikel(this.getAnzahlArtikel(), this.artikel); 
 } 
 
 
In Klasse Main 
   
public static void main(String[] args) { 
  ArtikelModel artikelModel = new ArtikelModel(); 
  try { 
   artikelModel.leseArtikelAusCsvDatei(); 
   artikelModel.schreibeArtikelInTxtDatei(); 
   artikelModel.schreibeArtikelInKonsole(); 
  }  
  catch (IOException e) { 
   e.printStackTrace(); 
  } 
 }  
 
  5 
Aufgabe 3.4.2 
 
In Klasse WriterCreator 
 
public abstract WriterCreator { 
 
 public abstract WriterProduct factoryMethod(String typ);  
 }   
} 
 
Klasse ConcreteWriterCreator 
 
public class ConcreteWriterCreator extends WriterCreator{ 
 
 @Override 
 public WriterProduct factoryMethod(String typ){ 
   if("txt".equals(typ)){ 
    return new ConcreteTxtWriterProduct(); 
   } 
   else{ 
    return new ConcreteKonsoleWriterProduct(); 
   }  
 }   
} 
 
 
In Klasse ArtikelModel 
 
  public void schreibeArtikelInTxtDatei() 
  throws IOException{ 
  WriterCreator writerCreator = new ConcreteWriterCreator(); 
  WriterProduct writer = writerCreator.factoryMethod("txt"); 
  writer.schreibeArtikel(this.getAnzahlArtikel(), this.artikel); 
 } 
 
 public void schreibeArtikelInKonsole() 
  throws IOException{ 
  WriterCreator writerCreator = new ConcreteWriterCreator(); 
  WriterProduct writer = writerCreator.factoryMethod("konsole"); 
  writer.schreibeArtikel(this.getAnzahlArtikel(), this.artikel); 
 }
