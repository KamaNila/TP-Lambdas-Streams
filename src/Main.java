import exo.Partie1;
import exo.Partie2;
import exo.Partie3;
import exo.Partie4;
import factory.TripFactory;
import models.Trip;

import java.util.List;

void main() {
    // ── Test rapide sur 10 éléments ──────────────────────
    List<Trip> petiteListe = TripFactory.generateTrips(10);

    Partie1 partie1 = new Partie1();
    Partie2 partie2 = new Partie2();
    Partie3 partie3 = new Partie3();
    Partie4 partie4 = new Partie4();

    System.out.println("Partie 1");
    System.out.println("Longs et chers : " + partie1.longAndExpensiveTrips(petiteListe));
    System.out.println("Mauvais trajets : " + partie1.badTrips(petiteListe));
    System.out.println("Trajets récents : " + partie1.recentTrips(petiteListe));

    System.out.println("\nPartie 2");
    System.out.println("Trajets par ville : " + partie2.countByCity(petiteListe));
    System.out.println("Revenu par chauffeur : " + partie2.revenueByDriver(petiteListe));
    System.out.println("Durée moyenne par ville : " + partie2.avgDurationByCity(petiteListe));

    System.out.println("\nPartie 3");
    System.out.println("Top 10 chers : " + partie3.top10ExpensiveTrips(petiteListe));
    System.out.println("Meilleur trajet : " + partie3.bestTrip(petiteListe));

    System.out.println("\nPartie 4");
    List<Trip> grandeListe = TripFactory.generateTrips(10_000_000);

    long debut = System.currentTimeMillis();
    double revenueSeq = partie4.totalRevenueSequential(grandeListe);
    long finSeq = System.currentTimeMillis();

    double revenuePar = partie4.totalRevenueParallel(grandeListe);
    long finPar = System.currentTimeMillis();

    System.out.println("Revenu séquentiel : " + revenueSeq + " (" + (finSeq - debut) + " ms)");
    System.out.println("Revenu parallèle  : " + revenuePar + " (" + (finPar - finSeq) + " ms)");
    System.out.println("Trajets par ville (parallel) : " + partie4.countByCityParallel(grandeListe));
    System.out.println("Trajets premium (parallel) : " + partie4.premiumTripsParallel(grandeListe).size() + " trajets");
}