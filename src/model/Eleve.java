package model;

import java.util.ArrayList;

/**
 * Classe Eleve contenant toutes les informations sur l'élève necessaire à la répartition dans les classes.
 */
public class Eleve {

    /**
     * Liste de tous les niveaux en élémentaire
     */
    private final String[] lesNiveaux = {"CP", "CE1", "CE2", "CM1", "CM2"};

    private long id;

    /**
     * Nom de l'élève
     */
    private String nom;

    /**
     * Prénom de l'élève
     */
    private String prenom;

    /**
     * Le genre de l'élève (F ou M)
     */
    private char genre;

    /**
     * Sa classe actuellement
     */
    private String niveau;

    /**
     * Liste des vœux de l'élève (2 maximum)
     */
    private ArrayList<Voeu> sesVoeux;

    /**
     * Liste des vœux des enseignants
     */
    private ArrayList<Voeu> voeuxEns;

    /**
     * -1 --> Discret
     * 0 --> Normal
     * 1 --> Dissipé
     */
    private byte temperament;

    /**
     * -1 --> élève qui n'a pas acquis toutes les compétences exigées à son niveau actuel
     * 0 --> élève qui a acquis les compétences exigées à son niveau actuel
     * 1 --> élève qui a des compétences transversales ou plus avancées que ce qui est exigé
     */
    private byte niveauScolaire;

    /**
     * Constructeur de Eleve
     * @param nomEleve nom de famille de l'élève
     * @param prenomEleve prénom de l'élève
     * @param niveauEleve classe actuelle
     * @param leTemperament tempérament de l'élève en classe
     */
    public Eleve(long idEleve, String nomEleve, String prenomEleve, char leGenre, String niveauEleve, byte leTemperament, byte leNiveauScolaire) {

        this.id = idEleve;

        if (nomEleve == null || prenomEleve == null) {
            throw new IllegalArgumentException("Erreur Eleve() : le nom ou le prénom de l'élève renseignés en paramètre sont invalides !");
        } else {
            this.nom = nomEleve;
            this.prenom = prenomEleve;
        }

        if (leGenre == 'F' || leGenre == 'M') {
            this.genre = leGenre;
        } else {
            throw new IllegalArgumentException("Erreur Eleve() : le genre de l'élève fournis en paramètre n'est pas connu !");
        }

        this.niveau = null;
        for (String unNiveau : lesNiveaux) {
            if (niveauEleve.equals(unNiveau)) {
                this.niveau = niveauEleve;
            }
        }
        if (this.niveau == null) {
            throw new IllegalArgumentException("Erreur Eleve() : le niveau renseigné en paramètre est invalide !");
        }

        if (leTemperament == -1 || leTemperament == 0 || leTemperament == 1) {
            this.temperament = leTemperament;
        } else {
            throw new IllegalArgumentException("Erreur Eleve() : le tempérament renseigné est invalide !");
        }

        if (leNiveauScolaire == -1 || leNiveauScolaire == 0 || leNiveauScolaire == 1) {
            this.niveauScolaire = leNiveauScolaire;
        } else {
            throw new IllegalArgumentException("Erreur Eleve() : le niveau scolaire renseigné est invalide !");
        }
    }

    public long getEleveID() {
        return this.id;
    }

    public String getNom() {
        return this.nom;
    }

    public String getPrenom() {
        return this.prenom;
    }

    public char getGenre() {
        return this.genre;
    }

    public String getNiveau() {
        return this.niveau;
    }

    public byte getTemperament() {
        return this.temperament;
    }

    public byte getNiveauScolaire() {
        return this.niveauScolaire;
    }

    /**
     * Setter pour définir un vœu de l'élève
     * @param unVoeu le vœu
     */
    public void setVoeu(Voeu unVoeu) {

        if (unVoeu == null) {
            throw new IllegalArgumentException("Erreur setVoeu() : le voeu fournis en paramètre est à null !");
        } else {

            if (unVoeu.getTypeVoeu()) {
                if (sesVoeux.size() < 2 && unVoeu.getLEleve().getEleveID() != this.getEleveID()) { // On vérifie que moins de 2 vœux ont été formulés par l'élève et que l'élève ne se souhaite pas lui-même.
                    sesVoeux.add(unVoeu);
                }
            } else {
                if (unVoeu.getLEleve().getEleveID() != this.getEleveID()) {
                    voeuxEns.add(unVoeu);
                }
            }

        }
    }

    // ######################## REDEFINITION ########################

    @Override
    public boolean equals(Object obj) {
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        } else {
            Eleve autreEleve = (Eleve) obj;
            if (this == autreEleve) {
                return true;
            } else if (this.id == autreEleve.getEleveID()) {
                return true;
            } else {
                return false;
            }
        }
    }

    @Override
    public int hashCode() {
        return Long.hashCode(this.id);
    }
}