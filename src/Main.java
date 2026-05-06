import factory.TripFactory;
import models.Trip;
import exo.Partie1;
import exo.Partie2;
import exo.Partie3;
import exo.Partie4;

import java.util.List;
import java.util.Map;
import java.util.Optional;

void main() {
    //List<Trip> trips = TripFactory.generateTrips(10000000);
    List<Trip> trips = TripFactory.generateTrips(10);

    Partie1 partie1 = new Partie1();

    System.out.println("longAndExpensiveTrips");
    List<Trip> longAndExpensive = partie1.longAndExpensiveTrips(trips);
    longAndExpensive.forEach(System.out::println);

    System.out.println("\nbadTrips");
    List<Trip> badTrips = partie1.badTrips(trips);
    badTrips.forEach(System.out::println);

    System.out.println("\nrecentTrips");
    List<Trip> recentTrips = partie1.recentTrips(trips);
    recentTrips.forEach(System.out::println);

    Partie2 partie2 = new Partie2();

    System.out.println("\ncountByCity");
    Map<String, Long> countByCity = partie2.countByCity(trips);
    countByCity.forEach((city, count) -> System.out.println(city + " -> " + count));

    System.out.println("\nrevenueByDriver");
    Map<String, Double> revenueByDriver = partie2.revenueByDriver(trips);
    revenueByDriver.forEach((driver, revenue) -> System.out.println(driver + " -> " + revenue));

    System.out.println("\navgDurationByCity");
    Map<String, Double> avgDurationByCity = partie2.avgDurationByCity(trips);
    avgDurationByCity.forEach((city, avg) -> System.out.println(city + " -> " + avg));

    Partie3 partie3 = new Partie3();

    System.out.println("\ntop10ExpensiveTrips");
    List<Trip> top10Expensive = partie3.top10ExpensiveTrips(trips);
    top10Expensive.forEach(System.out::println);

    System.out.println("\nbestTrips");
    Optional<Trip> bestTrips = partie3.bestTrip(trips);
    bestTrips.ifPresent(System.out::println);

    Partie4 partie4 = new Partie4();

    System.out.println("\ntotalRevenueSequential");
    double totalSeq = partie4.totalRevenueSequential(trips);
    System.out.println(totalSeq);

    System.out.println("\ntotalRevenueParallel");
    double totalPar = partie4.totalRevenueParallel(trips);
    System.out.println(totalPar);

    System.out.println("\ncountByCityParallel");
    Map<String, Long> countByCityParallel = partie4.countByCityParallel(trips);
    countByCityParallel.forEach((city, count) -> System.out.println(city + " -> " + count));

    System.out.println("\npremiumTripsParallel");
    List<Trip> premiumTrips = partie4.premiumTripsParallel(trips);
    premiumTrips.forEach(System.out::println);

    // appeler les méthodes des exos ici
    // pour tester si ça marche bien, générer une liste de 10 éléments et afficher le résultat
}