package modele;

public class Pizza {
    private String nom;
    private int prix;
    private int nbIngredients;
    private String id;

    public Pizza(String nom, int prix, int nbIngredients) {
        this.nom = nom;
        this.prix = prix;
        this.nbIngredients = nbIngredients;
    }

    public Pizza(String nom, int prix, int nbIngredients, String id) {
        this.nom = nom;
        this.prix = prix;
        this.nbIngredients = nbIngredients;
        this.id = id;
    }

    public Pizza() {

    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public int getNbIngredients() {
        return nbIngredients;
    }

    public void setNbIngredients(int nbIngredients) {
        this.nbIngredients = nbIngredients;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "nom='" + nom + '\'' +
                ", prix=" + prix +
                ", nbIngredients=" + nbIngredients +
                ", id='" + id + '\'' +
                '}';
    }
}

