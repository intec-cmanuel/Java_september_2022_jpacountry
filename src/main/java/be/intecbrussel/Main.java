package be.intecbrussel;

import be.intecbrussel.model.Country;
import be.intecbrussel.service.CountryService;

import java.util.Optional;

public class Main {



    public static void main(String[] args) {
        // Create countries
        Country belgium = new Country("Belgium", 11000000);
        Country france = new Country("France", 60000000);
        Country peru = new Country("Peru", 33000000);

        // Service handles the logic
        CountryService cs = new CountryService();

        // Saves countries to database
        cs.createCountry(belgium);
        cs.createCountry(france);
        cs.createCountry(peru);

        // Read countries from database
        Optional<Country> dbCountry = cs.readCountry("venezuela");
        if (dbCountry.isPresent()) {
            System.out.println(dbCountry.get());
        } else {
            System.out.println("No country found!");
        }

        // Delete country from database
        cs.deleteCountry("France");

        // Update a country
        Optional<Country> countryToUpdate = cs.readCountry("Belgium");
        if (countryToUpdate.isPresent()) {
            Country foundCountry = countryToUpdate.get();
            foundCountry.setPopulation(foundCountry.getPopulation()+1);
            cs.uC(foundCountry);
        }
    }
}