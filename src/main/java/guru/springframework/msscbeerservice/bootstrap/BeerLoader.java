package guru.springframework.msscbeerservice.bootstrap;

import guru.springframework.msscbeerservice.domain.Beer;
import guru.springframework.msscbeerservice.repositories.BeerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class BeerLoader implements CommandLineRunner {
    private final BeerRepository repository;

    public BeerLoader(BeerRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadBeerObjects();
    }

    private void loadBeerObjects() {
        if (repository.count() == 0) {
            repository.save(Beer.builder()
                    .beerName("Mango Bobs")
                    .beerStyle("IPA")
                    .qtyToBrew(200)
                    .upc(119L)
                    .minOnHand(15)
                    .price(new BigDecimal("12.95"))
                    .build());

            repository.save(Beer.builder()
                    .beerName("Galaxy Cat")
                    .beerStyle("Pale Ale")
                    .qtyToBrew(200)
                    .upc(521L)
                    .minOnHand(15)
                    .price(new BigDecimal("11.95"))
                    .build());
        }

//        System.out.println("Loaded Beers: " + repository.count());
    }
}
