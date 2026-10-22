package business;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BahnhoefeModel {
	private Bahnhof banhof;

	public Bahnhof getBanhof() {
		return banhof;
	}

	public void setBanhof(Bahnhof banhof) {
		this.banhof = banhof;
	}
	public void schreibeBahnhoefeInCsvDatei() throws IOException{
			Bahnhof bahnhof = getBanhof();
			BufferedWriter aus = new BufferedWriter(new FileWriter("BahnhoefeAusgabe.csv", true));
			aus.write(bahnhof.gibBahnhofZurueck(';'));
			aus.close();
			}
	
	public void schreibeBahnhoefeInTxtDatei() throws IOException{
		Bahnhof bahnhof = getBanhof();
		BufferedWriter aus = new BufferedWriter(new FileWriter("BahnhoefeAusgabe.csv", true));
		aus.write(bahnhof.gibBahnhofZurueck(';'));
		aus.newLine();
		aus.newLine();
		aus.close();
		}
	public void leseBahnhoefeInCsvDatei() throws IOException{
		BufferedReader ein = new BufferedReader(new FileReader("Bahnhof.csv"));
		String[] zeile = ein.readLine().split(";");
		Bahnhof bahnhof = new Bahnhof(zeile[0], 
				zeile[1], 
				Integer.parseInt(zeile[2]), 
				Integer.parseInt(zeile[3]), 
				zeile[4].split("_"));
		ein.close();
		}
		
	
}
