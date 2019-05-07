package br.com.invillia.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.invillia.dto.TweetDTO;
import br.com.invillia.repository.TweetRepository;

@Service
public class TweetService {

    @Autowired
    private TweetRepository repository;

    public List<TweetDTO> getTweet() {
        return repository.getAll()
                .stream()
                .map(tweet -> new TweetDTO(tweet.getTexto()))
                .collect(Collectors.toList());
    }

}
