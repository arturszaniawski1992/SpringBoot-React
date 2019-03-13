package com.szaniawski.artur.artur.peristance;


import com.szaniawski.artur.artur.domain.entities.BeerEntity;
import com.szaniawski.artur.artur.domain.repository.BeerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@Component
public class BeerComandLineRunner implements CommandLineRunner {

  private final BeerRepository repository;

  public BeerComandLineRunner(BeerRepository repository) {
    this.repository = repository;
  }

  @Override
  public void run(String... args) throws Exception {
    //top example beers from  https://www.beeradvocate.com/lists/top/
    Stream.of("Kentucky Brunch Brand Stout", "Good Morning", "Very Hazy", "King Julius",
      "Budweiser", "Coors Light", "PBR").forEach(name ->
      repository.save(new BeerEntity(name))
    );
    repository.findAll().forEach(System.out::println);
  }
}
