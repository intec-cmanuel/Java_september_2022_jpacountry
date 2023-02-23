package be.intecbrussel.service;

import be.intecbrussel.connection.EntityManagerProvider;
import be.intecbrussel.model.Country;
import be.intecbrussel.repository.CountryRepository;
import jakarta.persistence.EntityManager;

import java.util.Optional;

public class CountryService {
    private CountryRepository countryRepository = new CountryRepository();

    public void createCountry(Country country) {
        EntityManager em = EntityManagerProvider.getEntityManager();
        countryRepository.createCountry(em, country);
        em.close();
    }

    public Optional<Country> readCountry(String name) {
        EntityManager em = EntityManagerProvider.getEntityManager();
        Optional<Country> optionalCountry = countryRepository.readCountry(em, name);
        em.close();
        return optionalCountry;
    }

    public void deleteCountry(String name) {
        EntityManager em = EntityManagerProvider.getEntityManager();
        Optional<Country> country = countryRepository.readCountry(em, name);

        if (country.isPresent()) {
            countryRepository.deleteCountry(em, country.get());
        }

        em.close();
    }
}



















