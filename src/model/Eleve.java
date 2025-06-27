package model;

import java.util.ArrayList;

public class Eleve {

    /**
     * Liste de tous les niveaux
     */
    private final String[] lesNiveaux = {"CP", "CE1", "CE2", "CM1", "CM2"};

    /**
     * Nom de l'élève
     */
    private String nom;

    /**
     * Prénom de l'élève
     */
    private String prenom;

    /**
     * Sa classe à la rentrée prochaine
     */
    private String niveau;

    /**
     * Liste des voeux de l'élève (2 maximum)
     */
    private ArrayList<Voeu> sesVoeux;

    /**
     * -1 --> Discret
     * 0 --> Normal
     * 1 --> Dissipé
     */
    private byte temperament;

}