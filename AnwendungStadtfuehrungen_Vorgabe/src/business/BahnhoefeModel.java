package business;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import fileCreatorsDahak.CsvCreator;
import fileCreatorsDahak.ReaderProductDahak;
import fileCreatorsDahak.ReaderCreatorDahak;
import fileCreatorsDahak.TxtCreator;

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
	public void schreibeBahnhoefeInTxtDatei() throws IOException{
		BufferedWriter aus = new BufferedWriter(new FileWriter("BahnhoefeAusgabe.txt", true));
		aus.write(this.getBanhof().gibBahnhofZurueck(';'));
		aus.close();
		
		}
	public void leseBahnhoefeAusDatei(String typ) throws IOException{
		ReaderCreatorDahak creator;
		if("csv".equals(typ)) {
			creator = new CsvCreator();
		}else {
			creator = new TxtCreator();
		}
		ReaderProductDahak reader = creator.factoryMethod();
		try {
			String[] daten = reader.leseAusDatei();
			Bahnhof bahnhof = new Bahnhof(daten[0], 
					daten[1], 
					Integer.parseInt(daten[2]), 
					Integer.parseInt(daten[3]), 
					daten[4].split("_"));
			this.setBanhof(bahnhof);
			
		}finally {
			reader.schliesseDatei();
		}
		
		}
	public void leseBahnhoefeAusTxtDatei() throws IOException {
		ReaderCreatorDahak creator = new TxtCreator();
		ReaderProductDahak reader = creator.factoryMethod();
		try {
			String[] daten = reader.leseAusDatei();
			if (daten.length != 5) {
		        throw new IOException("Die Zeile muss fünf Felder enthalten.");
		    }
			
			Bahnhof bahnhof = new Bahnhof(daten[0], 
					daten[1], 
					Integer.parseInt(daten[2]), 
					Integer.parseInt(daten[3]), 
					daten[4].split("_"));
			this.setBanhof(bahnhof);
			
		}finally {
			reader.schliesseDatei();
		}
		
	
}}
