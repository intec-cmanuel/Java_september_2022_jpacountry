package be.intecbrussel;

import be.intecbrussel.model.Country;
import be.intecbrussel.service.CountryService;

import java.util.Optional;

public class Main {



    public static void main(String[] args) {
        Country belgium = new Country("Belgium", 11000000);
        Country france = new Country("France", 60000000);
        Country peru = new Country("Peru", 33000000);

        CountryService cs = new CountryService();
        cs.createCountry(belgium);
        cs.createCountry(france);
        cs.createCountry(peru);

        Optional<Country> dbCountry = cs.readCountry("venezuela");
        if (dbCountry.isPresent()) {
            System.out.println(dbCountry.get());
        } else {
            System.out.println("No country found!");
        }

        cs.deleteCountry("France");
    }
}