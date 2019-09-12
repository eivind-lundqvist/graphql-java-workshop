package no.bouvet.sandvika;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.support.TransactionTemplate;

import lombok.extern.slf4j.Slf4j;
import no.bouvet.sandvika.domain.Activity;
import no.bouvet.sandvika.domain.Athlete;
import no.bouvet.sandvika.domain.Club;
import no.bouvet.sandvika.repository.AthleteRepository;

@Slf4j
@SpringBootApplication
@EnableTransactionManagement
public class GraphQLApplication
{
    public final TransactionTemplate transactionTemplate;

    @Autowired
    public GraphQLApplication(TransactionTemplate transactionTemplate)
    {
        this.transactionTemplate = transactionTemplate;
    }

    public static void main(String[] args)
    {
        SpringApplication.run(GraphQLApplication.class, args);
    }

    @Bean
    public CommandLineRunner populateDatabase(AthleteRepository repository)
    {
        return (args) -> {

            transactionTemplate.execute(status -> {
                Athlete jack = Athlete.builder().firstName("Jack").lastName("Bauer").build();
                Athlete tyler = Athlete.builder().firstName("Tyler").lastName("Durden").build();

                Activity fight = Activity.builder().name("Fight!").athletes(List.of(jack, tyler)).build();
                jack.getActivities().add(fight);
                tyler.getActivities().add(fight);

                Club fightClub = Club.builder().name("Fight Club").athletes(List.of(jack, tyler)).build();
                jack.getClubs().add(fightClub);
                tyler.getClubs().add(fightClub);

                repository.save(jack);
                repository.save(tyler);

                repository.save(Athlete.builder().firstName("Conor").lastName("McGregor").build());
                repository.save(Athlete.builder().firstName("Emil").lastName("Meek").build());

                log.info("Athletes found with findAll():");
                log.info("-------------------------------");
                for (Athlete athlete : repository.findAll())
                {
                    log.info(athlete.toString());
                }
                log.info("");

                repository.findById(1L)
                    .ifPresent(athlete -> {
                        log.info("Athlete found with findById(0L):");
                        log.info("--------------------------------");
                        log.info(athlete.toString());
                        log.info("");
                    });

                log.info("Athlete found with findByLastName('Durden'):");
                log.info("--------------------------------------------");
                repository.findByLastName("Durden").forEach(durden -> {
                    log.info(durden.toString());
                });
                log.info("");

                return null;
            });
        };
    }
}
