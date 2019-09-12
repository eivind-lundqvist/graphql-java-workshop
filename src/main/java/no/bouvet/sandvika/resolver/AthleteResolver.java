package no.bouvet.sandvika.resolver;

import java.util.List;

import com.coxautodev.graphql.tools.GraphQLResolver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import no.bouvet.sandvika.domain.Activity;
import no.bouvet.sandvika.domain.Athlete;
import no.bouvet.sandvika.domain.Club;
import no.bouvet.sandvika.repository.ActivityRepository;
import no.bouvet.sandvika.repository.ClubRepository;

@Component
public class AthleteResolver implements GraphQLResolver<Athlete>
{
    private final ActivityRepository activityRepository;

    private final ClubRepository clubRepository;

    @Autowired
    public AthleteResolver(ActivityRepository activityRepository, ClubRepository clubRepository)
    {
        this.activityRepository = activityRepository;
        this.clubRepository = clubRepository;
    }

    public List<Activity> activities(Athlete athlete)
    {
        return activityRepository.findByAthletes_Id(athlete.getId());
    }

    public List<Club> clubs(Athlete athlete)
    {
        return clubRepository.findByAthletes_Id(athlete.getId());
    }
}