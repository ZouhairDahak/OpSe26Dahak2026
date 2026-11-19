package fileCreatorsDahak;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

public class CsvProduct extends ReaderProductDahak {
	private BufferedReader ein;
	public CsvProduct() throws IOException {
		ein = new BufferedReader(new FileReader("Bahnhof.csv"));
	}
	@Override
	public String[] leseAusDatei() throws IOException{
		String zeile = ein.readLine();

	    if (zeile == null) {
	        throw new IOException("Bahnhof.csv ist leer.");
	    }

	    String[] daten = zeile.split(";", -1);

	    return daten;
		
		
	}
	@Override
	public void schliesseDatei() throws IOException{
		ein.close();
	}

}
