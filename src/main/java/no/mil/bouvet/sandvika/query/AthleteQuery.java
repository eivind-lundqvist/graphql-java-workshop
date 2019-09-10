package no.mil.bouvet.sandvika.query;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import no.mil.bouvet.sandvika.domain.Athlete;
import no.mil.bouvet.sandvika.service.AthleteService;

@Component
public class AthleteQuery implements GraphQLQueryResolver
{
    private final AthleteService athleteService;

    @Autowired
    public AthleteQuery(AthleteService athleteService)
    {
        this.athleteService = athleteService;
    }

    public List<Athlete> getAthletes(final int count) {
        return this.athleteService.getAllAthletes(count);
    }

    @Transactional
    public Optional<Athlete> getAthlete(final Long id) {
        return this.athleteService.getAthlete(id);
    }
}
