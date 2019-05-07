package br.com.invillia.repository;
import static org.junit.Assert.assertEquals;

import br.com.invillia.entity.Tweet;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@EnableJpaRepositories
@RunWith(SpringRunner.class)
@EntityScan("br.com.invillia.entity")
@ActiveProfiles("test")
@EnableAutoConfiguration
@SpringBootTest(classes = {TweetRepository.class})
public class TwitterRepositoryTest {

    @Autowired
    private TweetRepository repository;

    @Test
    public void deveriaSalvarTwitter(){
        Tweet tweet  = new Tweet();
        tweet.setTexto("Java é Legal");


        repository.save(tweet);

        Tweet tweet1 = repository.findByTexto("Java é Legal");
        assertEquals("Java é Legal", tweet1.getTexto());
    }
}
