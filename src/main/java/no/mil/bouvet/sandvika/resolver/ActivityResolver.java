package no.mil.bouvet.sandvika.resolver;

import java.util.List;

import com.coxautodev.graphql.tools.GraphQLResolver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import no.mil.bouvet.sandvika.domain.Activity;
import no.mil.bouvet.sandvika.domain.Athlete;
import no.mil.bouvet.sandvika.repository.AthleteRepository;

@Component
public class ActivityResolver implements GraphQLResolver<Activity>
{
    private final AthleteRepository athletesRepository;

    @Autowired
    public ActivityResolver(AthleteRepository athletesRepository)
    {
        this.athletesRepository = athletesRepository;
    }

    public List<Athlete> athletes(Activity activity)
    {
        return athletesRepository.findByActivities_Id(activity.getId());
    }
}
