package model;

import java.util.LinkedHashSet;

/**
 * Classe Classe regroupant un certain nombre d'élèves dans le même groupe. C'est le type retourné par l'algorithme d'association d'un élève à une classe.
 */
public class Classe {

    /**
     * Liste de tous les niveaux en élémentaire
     */
    private final String[] lesNiveaux = {"CP", "CE1", "CE2", "CM1", "CM2"};

    /**
     * Identifiant unique de la classe
     */
    private long id;

    /**
     * Le niveau de la classe (CP, CE1, CE2, CM1, CM2)
     */
    private String[] niveaux;

    /**
     * Le nombre d'élèves que peut accueillir la classe
     */
    private byte nbEleve;

    /**
     * Liste des élèves dans la classe générée
     */
    private LinkedHashSet<Eleve> lesEleves;

    /**
     * Constructeur de Classe
     * @param idClasse identifiant de la classe
     * @param niveauClasse niveau de la classe
     * @param nbEleve nombre d'élèves maximum dans la classe
     */
    public Classe(long idClasse, String[] niveauClasse, byte nbEleve) {
        this.id = idClasse;

        if (niveauClasse == null) {
            throw new IllegalArgumentException("Erreur Classe() : la liste de niveaux renseignée en paramètre est null !");
        } else {
            boolean egal = false;
            this.niveaux = new String[niveauClasse.length];
            for (int i = 0 ; i < niveauClasse.length ; i++) {
                for (String niv : lesNiveaux) {
                    if (niveauClasse[i].equals(niv)) {
                        egal = true;
                        this.niveaux[i] = niveauClasse[i];
                    }
                }
                if ( ! egal) {
                    throw new IllegalArgumentException("Erreur Classe() : un niveau renseigné en paramètre n'est pas valide !");
                }
                egal = false;
            }
        }


        if (nbEleve > 1) {
            this.nbEleve = nbEleve;
        } else {
            throw new IllegalArgumentException("Erreur Classe() : le nombre d'élève possible pour cette classe est invalide !");
        }

        lesEleves = new LinkedHashSet<>();
    }

    /**
     * Getter identifiant de la classe
     * @return l'id de la classe
     */
    public long getId() {
        return this.id;
    }

    /**
     * Getter niveau de la classe
     * @return le niveau (CP, CE1, CE2, CM1, CM2)
     */
    public String[] getNiveau() {
        return this.niveaux;
    }

    /**
     * Getter nombre d'élèves max dans la classe
     * @return nombre d'élèves
     */
    public byte getNbEleve() {
        return this.nbEleve;
    }

    /**
     * Méthode qui ajoute un élève dans la classe
     * @param unEleve l'élève à ajouter
     */
    public void ajouterEleve(Eleve unEleve) {
        if (unEleve == null) {
            throw new IllegalArgumentException("Erreur ajouterEleve() : l'élève en paramètre est à null !");
        } else if (lesEleves.size() == nbEleve) {
            throw new ArrayStoreException("Erreur ajouterEleve() : impossible d'ajouter un élève car la classe est déjà complète !");
        } else {
            lesEleves.add(unEleve);
        }
    }

    /**
     * Méthode qui retire un élève de la classe
     * @param unEleve l'élève à retirer
     */
    public void retirerEleve(Eleve unEleve) {
        if (unEleve == null) {
            throw new IllegalArgumentException("Erreur retirerEleve() : l'élève en paramètre est à null !");
        } else if (lesEleves.size() == 0) {
            throw new IllegalCallerException("Erreur retirerEleve() : impossible de retirer un élève car la classe est vide !");
        } else {
            for (Eleve elv : lesEleves) {
                if (elv.getEleveID() == unEleve.getEleveID()) {
                    lesEleves.remove(elv);
                }
            }
        }
    }
}