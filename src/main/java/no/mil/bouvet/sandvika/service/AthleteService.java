package no.mil.bouvet.sandvika.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import no.mil.bouvet.sandvika.domain.Athlete;
import no.mil.bouvet.sandvika.repository.AthleteRepository;

@Service
public class AthleteService
{
    private final AthleteRepository athleteRepository ;

    public AthleteService(final AthleteRepository athleteRepository) {
        this.athleteRepository = athleteRepository ;
    }

    @Transactional
    public Athlete createAthlete(final String lastName, final String firstName) {
        final Athlete athlete = new Athlete();
        athlete.setLastName(lastName);
        athlete.setFirstName(firstName);
        return this.athleteRepository.save(athlete);
    }

    @Transactional(readOnly = true)
    public List<Athlete> getAllAthletes(final int count) {
        return this.athleteRepository.findAll().stream()
            .limit(count)
            .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public Optional<Athlete> getAthlete(final Long id) {
        return this.athleteRepository.findById(id);
    }
}
