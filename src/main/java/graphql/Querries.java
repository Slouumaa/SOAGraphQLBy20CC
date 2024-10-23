package graphql;

import com.coxautodev.graphql.tools.GraphQLRootResolver;
import entite.Logement;
import entite.RendezVous;
import repository.LogementRepository;
import repository.RendezVousRepository;

import java.util.List;

public class Querries implements GraphQLRootResolver {
    RendezVousRepository rdvRepo;
    LogementRepository logementRepository;

    public Querries(RendezVousRepository rdvRepo,LogementRepository logementRepository) {
        this.rdvRepo = rdvRepo;
        this.logementRepository=logementRepository;
    }

    public List<RendezVous> listRendezVous(){
        return rdvRepo.getListeRendezVous();
    }

    public List<RendezVous> listRendezVousByRef(int ref){
        return rdvRepo.getListeRendezVousByLogementRef(ref);

    }
    public RendezVous rendezVousById(int id){
        return rdvRepo.getRendezVousBy(id);
    }
    public List<Logement> allLogement(){
        return this.logementRepository.getAllLogements();
    }
    public Logement ListLogByRef(int ref){
        return logementRepository.getLogementsByReference(ref);
    }
    public List<Logement> ListLogByType(Logement.Type type){
        return logementRepository.getLogementsByType(type);
    }
}
