package repository;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import entite.Logement;
import entite.Logement.Type;
import entite.RendezVous;

public class LogementRepository {
    
    private final List<Logement> logements;

    public LogementRepository() {
    	logements=new ArrayList<Logement>();
    	logements.add(new Logement(1,"27, Rue des roses", "El ghazela","Ariana",Type.Studio,"cuisine equipee",300f));
		logements.add(new Logement(5,"58, Rue des roses", "El ghazela","Ariana",Type.EtageVilla,"cuisine equipee",450f));
		logements.add(new Logement(2,"201, R�sidence Omrane4", "Riadh El Andalous","Ariana",Type.Appartement,"chauffage central, ascenseur, climatisation",700f));
		logements.add(new Logement(3,"540, R�sidence Les Tulipes", "El Aouina","Ariana",Type.Appartement,"S+2, chauffage central, ascenseur, climatisation",500f));
		logements.add(new Logement(4,"78, Rue des Oranges", "Bardo","Tunis",Type.EtageVilla,"chauffage central, ascenseur, climatisation",400f));
	 }

    public List<Logement> getAllLogements() {
        return logements;
    }
    public List<Logement> getLogementsByType(Type type){
		List<Logement> liste=new ArrayList<Logement>();
		for (Logement l:logements){
			if(l.getType().equals(type))
				liste.add(l);
		}
		return liste;
	}
    
    public void saveLogement(Logement logement) {
        logements.add(logement);
    }
    public Logement getLogementsByReference(int reference){
		
		for (Logement l:logements){
			if(l.getReference()==reference)
				return l;
		}
		return null;
	}
	public boolean deleteLogement(int ref){
		Iterator<Logement> iterator=logements.iterator();
		while(iterator.hasNext()) {
			Logement log = iterator.next();
			if (log.getReference() == ref)
				iterator.remove();
			return true;

		}
		return false;}
    
    
}
