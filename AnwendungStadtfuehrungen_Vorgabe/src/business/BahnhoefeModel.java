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
			BufferedWriter aus = new BufferedWriter(new FileWriter("BahnhoefeAusgabe.csv", true));
			aus.write(this.getBanhof().gibBahnhofZurueck(';'));
			aus.close();
			}
	public void leseBahnhoefeAusCsvDatei() throws IOException{
		String zeile;
		try(BufferedReader ein = new BufferedReader(new FileReader("Bahnhof.csv"));) {
		zeile = ein.readLine();}
		if(zeile == null) {
			throw new IOException("Die Datei ist leer.");
		}
		String[] daten = zeile.split(";", -1);
		if (daten.length != 5) {
	        throw new IOException("Die Zeile muss fünf Felder enthalten.");
	    }
		
		Bahnhof bahnhof = new Bahnhof(daten[0], 
				daten[1], 
				Integer.parseInt(daten[2]), 
				Integer.parseInt(daten[3]), 
				daten[4].split("_"));
		this.setBanhof(bahnhof);
		}
	public void leseBahnhoefeAusTxtDatei() throws IOException {
	    String zeile;

	    try (BufferedReader ein = new BufferedReader(
	            new FileReader("Bahnhof.txt"))) {
	        zeile = ein.readLine();
	    }

	    if (zeile == null) {
	        throw new IOException("Die Datei ist leer.");
	    }

	    String[] daten = zeile.split(";", -1);

	    if (daten.length != 5) {
	        throw new IOException("Die Zeile muss fünf Felder enthalten.");
	    }

	    Bahnhof bahnhof = new Bahnhof(
	        daten[0],
	        daten[1],
	        Integer.parseInt(daten[2].trim()),
	        Integer.parseInt(daten[3].trim()),
	        daten[4].split("_")
	    );

	    this.setBanhof(bahnhof);
	}
		
	
}
