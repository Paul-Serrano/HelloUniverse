import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HelloUniverse {

    public static void main(String... args) {

        Galaxie systemeSolaire = new Galaxie();
        systemeSolaire.nom = "Système solaire";

        Atmosphere marsAtmosphere = new Atmosphere();
        marsAtmosphere.constituants.put("CO2", 95f);
        marsAtmosphere.constituants.put("CO2", 95f);
        marsAtmosphere.constituants.put("N2", 3f);
        marsAtmosphere.constituants.put("AR", 1.5f);
        marsAtmosphere.constituants.put("NO", 0.013f);


        PlaneteTellurique mercure = new PlaneteTellurique("Mercure", 1);
        mercure.diametre = 4880;
        mercure.distanceEtoile=2;

        PlaneteTellurique venus = new PlaneteTellurique("Venus", 2);
        venus.diametre = 12100;
        venus.distanceEtoile = 5;

        PlaneteTellurique terre = new PlaneteTellurique("Terre", 10);
        terre.diametre = 12756;
        terre.distanceEtoile = 6;

        PlaneteTellurique mars = new PlaneteTellurique("Mars", 3);
        mars.diametre = 6792;
        mars.distanceEtoile = 8;
        mars.atmosphere = marsAtmosphere;

        System.out.println("L'atmosphère de Mars est composé de :");

        for (Map.Entry<String, Float> constituants : mars.atmosphere.constituants.entrySet()) {
            String key = constituants.getKey();
            Float value = constituants.getValue();
            System.out.println(value + " % de " + key);
        }


        PlaneteGazeuse jupiter = new PlaneteGazeuse("Jupiter");
        jupiter.diametre = 142984;
        jupiter.distanceEtoile = 15;

        PlaneteGazeuse saturne = new PlaneteGazeuse("Saturne");
        saturne.diametre = 120536;
        saturne.distanceEtoile = 18;

        PlaneteGazeuse uranus = new PlaneteGazeuse("Uranus");
        uranus.diametre = 51118;
        uranus.distanceEtoile = 25;

        PlaneteGazeuse neptune = new PlaneteGazeuse("Neptune");
        neptune.diametre = 49532;
        neptune.distanceEtoile = 30;

        systemeSolaire.planetes.add(jupiter);
        systemeSolaire.planetes.add(mars);
        systemeSolaire.planetes.add(venus);
        systemeSolaire.planetes.add(neptune);
        systemeSolaire.planetes.add(uranus);
        systemeSolaire.planetes.add(terre);
        systemeSolaire.planetes.add(mercure);
        systemeSolaire.planetes.add(saturne);

        for (Planete planete: systemeSolaire.planetes) {
            System.out.println("la planète " + planete.nom + " se trouve à " + planete.distanceEtoile + " de km de l'étoile la plus proche");
        }

        Atmosphere atmosphereUranus = new Atmosphere();
        atmosphereUranus.tauxHydrogene = 83f;
        atmosphereUranus.tauxHelium = 15f;
        atmosphereUranus.tauxMethane = 2.5f;
        atmosphereUranus.tauxAzote = 0f;


        Vaisseau chasseur = new VaisseauDeGuerre(TypeVaisseau.CHASSEUR);
        chasseur.nbPassagers = 3;
        chasseur.blindage = 156;
        chasseur.resistanceDuBouclier = 2;

        Vaisseau chasseur1 = new VaisseauDeGuerre(TypeVaisseau.CHASSEUR);
        chasseur.nbPassagers = 3;
        chasseur.blindage = 156;
        chasseur.resistanceDuBouclier = 2;

        Vaisseau chasseur2 = new VaisseauDeGuerre(TypeVaisseau.CHASSEUR);
        chasseur.nbPassagers = 2;
        chasseur.blindage = 156;
        chasseur.resistanceDuBouclier = 2;

        Vaisseau croiseur = new VaisseauDeGuerre(TypeVaisseau.CROISEUR);
        croiseur.nbPassagers = 35;
        croiseur.blindage = 851;
        croiseur.resistanceDuBouclier = 25;

        Vaisseau fregate = new VaisseauDeGuerre(TypeVaisseau.FREGATE);
        fregate.nbPassagers = 100;
        fregate.blindage = 542;
        fregate.resistanceDuBouclier = 50;

        Vaisseau cargo = new VaisseauCivil(TypeVaisseau.CARGO);
        cargo.nbPassagers = 1000;
        cargo.blindage = 1520;
        cargo.resistanceDuBouclier = 20;

        Vaisseau cargo1 = new VaisseauCivil(TypeVaisseau.CARGO);
        cargo.nbPassagers = 1500;
        cargo.blindage = 1520;
        cargo.resistanceDuBouclier = 20;

        Vaisseau vaisseauMonde = new VaisseauCivil(TypeVaisseau.VAISSEAUMONDE);
        vaisseauMonde.nbPassagers = 10000;
        vaisseauMonde.blindage = 4784;
        vaisseauMonde.resistanceDuBouclier = 30;

        terre.accueillirVaisseaux(chasseur1, chasseur2, cargo1);

        boolean recommencer = true;

        while(recommencer == true) {

            Scanner sc = new Scanner(System.in);
            System.out.println("Quel vaisseau souhaitez vous manipuler : CHASSEUR, FREGATE, CROISEUR, CARGO ou VAISSEAUMONDE ?");
            String vaisseauSelectionne = sc.nextLine();
            TypeVaisseau typeVaisseau = TypeVaisseau.valueOf(vaisseauSelectionne);
            Vaisseau vaisseau = null;
            switch (typeVaisseau) {
                case CHASSEUR:
                    vaisseau = chasseur;
                    break;
                case FREGATE:
                    vaisseau = fregate;
                    break;
                case CROISEUR:
                    vaisseau = croiseur;
                    break;
                case CARGO:
                    vaisseau = cargo;
                    break;
                case VAISSEAUMONDE:
                    vaisseau = vaisseauMonde;
                    break;
            }

            System.out.println("Sur quelle planète tellurique du systeme solaire voulez-vous vous poser : Mercure, Venus, Terre ou Mars ?");
            String planete = sc.nextLine();


            Planete p = null;
            for (Planete planet : systemeSolaire.planetes) {
                if (planete == planet.nom) {
                    p = planet;
                }
            }


            if (p instanceof PlaneteGazeuse) {
                System.out.println("Planète gazeuse, nous de vons repartir !");
                continue;
            }

            PlaneteTellurique planeteTel = (PlaneteTellurique) p;


            if (!planeteTel.restePlaceDisponible(vaisseau)) {
                System.out.println("Le vaisseau ne peut pas se poser sur la planète par manque de place disponible dans la baie");
            } else {
                planeteTel.accueillirVaisseaux(vaisseau);
            }


            System.out.println("Voulez-vous recommencer ?");
            recommencer = sc.nextLine().equalsIgnoreCase("oui");
        }
    }
}

