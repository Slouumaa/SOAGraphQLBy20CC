package entite;

import java.util.Objects;

public class Logement {
	private int reference;
	private String adresse;
	private String delegation;
	private String gouvernorat;
	private Type type;
	private String description;
	private float prix;
	
	public enum Type {Studio, Appartement, Villa, EtageVilla} ;

	public int getReference() {
		return reference;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Logement)) return false;
		Logement logement = (Logement) o;
		return reference == logement.reference && Float.compare(prix, logement.prix) == 0 && Objects.equals(adresse, logement.adresse) && Objects.equals(delegation, logement.delegation) && Objects.equals(gouvernorat, logement.gouvernorat) && type == logement.type && Objects.equals(description, logement.description);
	}

	@Override
	public int hashCode() {
		return Objects.hash(reference, adresse, delegation, gouvernorat, type, description, prix);
	}

	public void setReference(int reference) {
		this.reference = reference;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public void setDelegation(String delegation) {
		this.delegation = delegation;
	}

	public void setGouvernorat(String gouvernorat) {
		this.gouvernorat = gouvernorat;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}

	public String getAdresse() {
		return adresse;
	}

	public String getDelegation() {
		return delegation;
	}

	public String getGouvernorat() {
		return gouvernorat;
	}

	public Type getType() {
		return type;
	}

	public String getDescription() {
		return description;
	}

	public float getPrix() {
		return prix;
	}

	public Logement(int reference, String adresse, String delegation, String gouvernorat, Type type, String description, float prix) {
		this.reference = reference;
		this.adresse = adresse;
		this.delegation = delegation;
		this.gouvernorat = gouvernorat;
		this.type = type;
		this.description = description;
		this.prix = prix;
	}

	public Logement() {
	}

	public Logement(int reference, String adresse) {
		this.reference = reference;
		this.adresse = adresse;
	}
}
