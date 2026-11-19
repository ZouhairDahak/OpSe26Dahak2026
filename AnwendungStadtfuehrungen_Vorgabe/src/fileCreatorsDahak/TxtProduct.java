package fileCreatorsDahak;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
public class TxtProduct extends ReaderProductDahak {
	private BufferedReader ein;
	public TxtProduct() throws IOException {
		ein = new BufferedReader(new FileReader("Bahnhof.txt"));
	}
	@Override
	public String[] leseAusDatei() throws IOException{
		String zeile = ein.readLine();
		String[] ergebnis = new String[5];
		int i =0;
		while(i < ergebnis.length) {
			ergebnis[i] = zeile;
			zeile = ein.readLine();
			i++;
		}
		return ergebnis;
		
		
	}
	@Override
	public void schliesseDatei() throws IOException{
		ein.close();
	}

}
