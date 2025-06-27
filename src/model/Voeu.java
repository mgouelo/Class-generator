package model;

/**
 * Classe Voeu associant un élève avec un autre ; Que ce soit pour les séparer ou pour qu'ils soient dans la même classe.
 */
public class Voeu {
    /**
     * Identifiant du vœu
     */
    private long id;

    /**
     * true --> vœu formulé par un élève (X souhaite être avec Y)
     * false --> vœu formulé par un enseignant (X ne doit pas être avec Y)
     */
    private boolean positif;

    /**
     * Eleve ciblé par le voeu
     */
    private Eleve unEleve;

    /**
     * Constructeur de Vœu
     * @param positif true si vœu de l'élève, false si vœu d'un enseignant
     * @param unEleve l'élève concerné dans le vœu
     */
    public Voeu(long idVoeu, boolean positif, Eleve unEleve) {
        this.id = idVoeu;

        this.positif = positif;

        if (unEleve == null) {
            throw new IllegalArgumentException("Erreur Voeu() : l'élève renseigné en paramètre est à null !");
        } else {
            this.unEleve = unEleve;
        }
    }

    /**
     * Getter id du voeu
     * @return identifiant du vœu
     */
    public long getId() {
        return this.id;
    }

    /**
     * Getter qui retourne si c'est un vœu de l'élève ou d'un enseignant
     * vœu d'un élève : X souhaite être dans la même classe que Y
     * vœu d'un enseignant : X ne doit pas être dans la même classe que Y
     * @return true si vœu de l'élève, faux sinon
     */
    public boolean getTypeVoeu() {
        return this.positif;
    }

    /**
     * Getter qui retourne l'élève mentionné dans le vœu
     * @return l'élève
     */
    public Eleve getLEleve() {
        return this.unEleve;
    }

    // ######################## REDEFINITION ########################

    @Override
    public boolean equals(Object obj) {
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        } else {
            Voeu autreVoeu = (Voeu) obj;
            if (this == autreVoeu) {
                return true;
            } else if (this.getId() == autreVoeu.getId()) {
                return true;
            } else {
                return false;
            }
        }
    }

    @Override
    public int hashCode() {
        return Long.hashCode(id);
    }
}