package graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import entite.Logement;
import entite.RendezVous;
import repository.LogementRepository;
import repository.RendezVousRepository;

import java.util.List;

public class Mutation implements GraphQLMutationResolver {
    private final RendezVousRepository rdvRepository;
    private final LogementRepository logRepository;

    public Mutation(RendezVousRepository rdvRepository, LogementRepository logRepository) {
        this.rdvRepository = rdvRepository;
        this.logRepository = logRepository;
    }
    public RendezVous addRendezVous(int id, String date, String heure, int logementRef, String numTel) {
        // Crée un nouvel objet RendezVous sans logement (il sera ajouté après)
        RendezVous rendezVous = new RendezVous(id, date, heure, null, numTel);

        // Récupère le logement en utilisant la référence via le repository
        Logement logement = rdvRepository.getLogementByRDV(logementRef);
        if (logement == null) {
            throw new RuntimeException("Logement introuvable avec la référence " + logementRef);
        }

        // Affecte le logement au rendez-vous
        rendezVous.setLogement(logement);

        // Ajoute le rendez-vous au repository
        if (rdvRepository.addRendezVous(rendezVous)) {
            return rendezVous;
        } else {
            throw new RuntimeException("Échec de l'ajout du rendez-vous.");
        }
    }

    public String updateRendezVous1(int id, String date, String heure, String numTel) {
        Logement l = rdvRepository.getLogementByRDV(id);
        RendezVous rendezVous = new RendezVous(id, date, heure,l, numTel);
        if(rdvRepository.updateRendezVous(rendezVous))
            return "success";
        return "echec";

    }
   /* public RendezVous updateRendezVous(int id, String date, String heure, int logementRef, String numTel) {
        // Rechercher le rendez-vous existant par ID
        RendezVous existingRendezVous = rdvRepository.getListeRendezVous().stream()
                .filter(rdv -> rdv.getId() == id)
                .findFirst()
                .orElse(null);

        if (existingRendezVous == null) {
            throw new RuntimeException("Rendez-vous introuvable avec l'ID " + id);
        }

        // Mettre à jour les propriétés du rendez-vous
        existingRendezVous.setDate(date);
        existingRendezVous.setHeure(heure);
        existingRendezVous.setNumTel(numTel);

        // Récupérer le logement par référence
        Logement logement = rdvRepository.getLogementByRDV(logementRef);
        if (logement == null) {
            throw new RuntimeException("Logement introuvable avec la référence " + logementRef);
        }

        // Affecter le logement au rendez-vous
        existingRendezVous.setLogement(logement);

        // Mettre à jour le rendez-vous dans le repository
        if (rdvRepository.updateRendezVous(existingRendezVous)) {
            return existingRendezVous;
        } else {
            throw new RuntimeException("Échec de la mise à jour du rendez-vous.");
        }
    }
*/


    public boolean deleteRendezVous(int id) {
        boolean isDeleted = rdvRepository.deleteRendezVous(id);
        if (!isDeleted) {
            throw new RuntimeException("Échec de la suppression du rendez-vous avec l'ID " + id);
        }
        return true;
    }

public List<Logement> creatLogement(int reference, String adresse){
        Logement l=new Logement(reference,adresse);
        logRepository.saveLogement(l);
        return logRepository.getAllLogements();
}
public boolean deleteLog(int ref){
        return logRepository.deleteLogement(ref);
}

}
