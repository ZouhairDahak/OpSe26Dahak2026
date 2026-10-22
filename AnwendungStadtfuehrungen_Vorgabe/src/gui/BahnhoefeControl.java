package gui;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import business.BahnhoefeModel;
import business.Bahnhof;
import javafx.stage.Stage;
public class BahnhoefeControl {
	private BahnhoefeView view;
	private BahnhoefeModel model;
	
	public BahnhoefeControl(Stage stage) {
		model = new BahnhoefeModel();
		view = new BahnhoefeView(stage, this);
	}
	
	public void nehmeBahnhofAuf(){
    	try{ 
    		String name = view.getName();
    		String ort = view.getOrt();
    		int AnzahlGleise = Integer.parseInt(view.getAnzahlGleise());
    		int LetzteRenovierung = 	Integer.parseInt(view.getLetzteRenovierung());
    		String Zugarten = view.getZugarten();
    		Bahnhof bahnhof = new Bahnhof( name,  ort, AnzahlGleise, LetzteRenovierung, Zugarten.split(";"));
    		model.setBanhof(bahnhof);
    		view.zeigeInformationsfensterAn("Der Bahnhof wurde aufgenommen!");;
       	}
       	catch(Exception exc){
       		view.zeigeFehlermeldungsfensterAn(exc.getMessage());
     	}
    }
    public void zeigeBahnhoefeAn(){
    	Bahnhof bahnhof = model.getBanhof();
    	if(bahnhof != null){
    		view.zeigeText(bahnhof.gibBahnhofZurueck(' '));
    	}
    	else{
    		view.zeigeInformationsfensterAn("Bisher wurde keine Bahnhof aufgenommen!");
    	}
    }
    
    
    private void leseAusDatei(String typ){
    	try {
      		if("csv".equals(typ)){
      			model.leseBahnhoefeInCsvDatei();
      		}
       		else{
	   			view.zeigeInformationsfensterAn(
	   				"Noch nicht implementiert!");
	   		}
		}
		catch(IOException exc){
			view.zeigeFehlermeldungsfensterAn(
				"IOException beim Lesen!");
		}
		catch(Exception exc){
			view.zeigeFehlermeldungsfensterAn(
				"Unbekannter Fehler beim Lesen!");
		}
	}
}
