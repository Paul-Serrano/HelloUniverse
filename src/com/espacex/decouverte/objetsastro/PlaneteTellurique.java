package com.espacex.decouverte.objetsastro;

import com.espacex.decouverte.enginsspatiaux.Vaisseau;
import com.espacex.decouverte.enginsspatiaux.VaisseauDeGuerre;

public class PlaneteTellurique extends Planete implements Habitable {

    Vaisseau[][] baieAccostage;

    public PlaneteTellurique(String nom, int tailleBaie) {
        super(nom, tailleBaie);
        this.baieAccostage = new Vaisseau[tailleBaie][tailleBaie];
    }

    public boolean restePlaceDisponible(Vaisseau vaisseau) {

        int indexZone = 0;

        switch(vaisseau.type) {
            case CARGO:
            case VAISSEAUMONDE:
                indexZone = 1;
        }

        for(int i = 0; i < baieAccostage[indexZone].length; i++) {
            if(baieAccostage[indexZone][i] == null) {
                return true;
            }
        }
        return false;
    }

    public void accueillirVaisseaux(Vaisseau... vaisseaux){

        for(int j = 0; j < vaisseaux.length; j++) {

            int indexZone = 0;

            switch(vaisseaux[j].type) {
                case CARGO:
                case VAISSEAUMONDE:
                    indexZone = 1;
            }


            for(int i = 0; i < baieAccostage[indexZone].length; i++) {
                if(baieAccostage[indexZone][i] == null) {
                    baieAccostage[indexZone][i] = vaisseaux[j];
                    break;
                }
            }

            if (vaisseaux[j] instanceof VaisseauDeGuerre){
                ((VaisseauDeGuerre)vaisseaux[j]).desactiverArmes();
            }

            totalVisiteurs+=vaisseaux[j].nbPassagers;


        }

    }

}
