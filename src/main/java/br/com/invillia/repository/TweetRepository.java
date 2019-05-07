package br.com.invillia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.com.invillia.entity.Tweet;

public interface TweetRepository extends CrudRepository<Tweet, Long> {

    Tweet findByTexto(String texto);

    @Query("SELECT o FROM Tweet o")
    List<Tweet> getAll();

}
