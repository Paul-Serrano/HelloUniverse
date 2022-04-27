
public class PlaneteTellurique extends Planete implements Habitable{

    Vaisseau[] baieAccostage;

    public PlaneteTellurique(String nom, int tailleBaie) {
        super(nom, tailleBaie);
        this.baieAccostage = new Vaisseau[tailleBaie];
    }

    public boolean restePlaceDisponible() {
        for(int i = 0; i < baieAccostage.length; i++) {
            if(baieAccostage[i] == null) {
                return true;
            }
        }
        return false;
    }

    public void accueillirVaisseau(Vaisseau vaisseau){

        if (vaisseau instanceof VaisseauDeGuerre){
            ((VaisseauDeGuerre)vaisseau).desactiverArmes();
        }

        totalVisiteurs+=vaisseau.nbPassagers;

        for(int i = 0; i < baieAccostage.length; i++) {
            if(baieAccostage[i] == null) {
                baieAccostage[i] = vaisseau;
                break;
            }
        }

    }



}
