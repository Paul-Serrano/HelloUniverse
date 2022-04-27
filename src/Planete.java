
public abstract class Planete {
    String nom;
    int tailleBaie;
    int diametre;
    int totalVisiteurs;

    Atmosphere atmosphere;

    static String forme="Sphérique";
    static int nbPlanetesDecouvertes;

    Planete(String nom){
        this.nom=nom;
        this.tailleBaie = tailleBaie;
        nbPlanetesDecouvertes++;
    }

    Planete(String nom, int tailleBaie){
        this.nom=nom;
        this.tailleBaie = tailleBaie;
        nbPlanetesDecouvertes++;
    }

    int revolution(int degres){
        System.out.println("Je suis la planète "+nom+" et je tourne autour de mon étoile de "+degres+" degrés.");
        return degres/360;
    }

    int rotation(int degres){
        System.out.println("Je suis la planète "+nom+" et je tourne sur moi-même de "+degres+" degrés.");
        return degres/360;
    }



    static String expansion (double milliardsDAnneesLumiere){
        if (milliardsDAnneesLumiere < 14){
            return "Oh la la mais c'est super rapide !";
        }
        else {
            return "Je rêve ou c'est plus rapide que la lumière ?";
        }
    }

}
