package com.szaniawski.artur.artur.web;


import com.szaniawski.artur.artur.domain.entities.BeerEntity;
import com.szaniawski.artur.artur.domain.repository.BeerRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class BeerController {
  private BeerRepository repository;

  public BeerController(BeerRepository repository) {
    this.repository = repository;
  }

  @GetMapping("/good-beers")
  public List<BeerEntity> goodBeers (){
    return repository.findAll().stream()
      .filter(this::isGreat)
      .collect(Collectors.toList());
  }

  private boolean isGreat(BeerEntity beer){
    return !beer.getName().equals("Budweiser")
      && !beer.getName().equals("CoorsLight") && !beer.getName().equals("PBR");
  }
}
