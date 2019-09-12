package no.bouvet.sandvika.mutation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import no.bouvet.sandvika.domain.Athlete;
import no.bouvet.sandvika.service.AthleteService;

@Component
public class AthleteMutation implements GraphQLMutationResolver
{
    private final AthleteService athleteService;

    @Autowired
    public AthleteMutation(AthleteService athleteService)
    {
        this.athleteService = athleteService;
    }

    public Athlete createAthlete(final String lastName, final String firstName) {
        return this.athleteService.createAthlete(lastName, firstName);
    }
}
