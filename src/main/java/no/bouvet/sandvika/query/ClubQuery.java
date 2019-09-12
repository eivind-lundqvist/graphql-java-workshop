package no.bouvet.sandvika.query;

import java.util.List;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import no.bouvet.sandvika.domain.Club;
import no.bouvet.sandvika.service.ClubService;

@Component
public class ClubQuery implements GraphQLQueryResolver
{
    private final ClubService clubService;

    @Autowired
    public ClubQuery(ClubService clubService)
    {
        this.clubService = clubService;
    }

    public List<Club> getClubs() {
        return this.clubService.getAllClubs();
    }
}
