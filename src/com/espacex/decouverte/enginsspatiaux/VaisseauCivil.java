package com.espacex.decouverte.enginsspatiaux;
import static com.espacex.decouverte.enginsspatiaux.TypeVaisseau.VAISSEAUMONDE;
import static com.espacex.decouverte.enginsspatiaux.TypeVaisseau.CARGO;

public class VaisseauCivil extends Vaisseau {

    public VaisseauCivil(TypeVaisseau type) {
        super(type);
        if (type == CARGO) {
            tonnageMax = 500;
        } else if (type == VAISSEAUMONDE) {
            tonnageMax = 2000;
        }

    }

    public int emporterCargaison(int tonnage) {

        int tonnageRestant = tonnageMax - tonnageActuel;
        if (tonnage > tonnageRestant) {
            tonnageActuel = tonnageMax;
            return tonnage-tonnageRestant;
        }
        tonnageActuel+=tonnage;
        return 0;
    }

}
