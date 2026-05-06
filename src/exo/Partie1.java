package exo;

import models.Trip;

import java.time.LocalDate;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Partie1 {

    Predicate<Trip> longEtCher = trip -> trip.distanceKm() > 10 && trip.price() > 20;

    Predicate<Trip> mauvaiseNote = trip -> trip.rating() < 3;

    Predicate<Trip> trajetsRecents = trip -> {
        LocalDate aujourdhui = LocalDate.now();
        LocalDate dateTrajets = trip.startTime().toLocalDate();
        return dateTrajets.equals(aujourdhui) || dateTrajets.equals(aujourdhui.minusDays(1));
    };

    //Exercice 1
    public List<Trip> longAndExpensiveTrips(List<Trip> trips) {
        return trips.stream()
                .filter(longEtCher)
                .collect(Collectors.toList());
    }

    //Exercice 2
    public List<Trip> badTrips(List<Trip> trips) {
        return trips.stream()
                .filter(mauvaiseNote)
                .collect(Collectors.toList());
    }

    //Exercice 3
    public List<Trip> recentTrips(List<Trip> trips) {
        return trips.stream()
                .filter(trajetsRecents)
                .collect(Collectors.toList());
    }
}