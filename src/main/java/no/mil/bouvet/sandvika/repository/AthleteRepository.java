package no.mil.bouvet.sandvika.repository;

import no.mil.bouvet.sandvika.domain.Athlete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AthleteRepository extends JpaRepository<Athlete, Long>
{
    List<Athlete> findByLastName(String lastName);

    List<Athlete> findByActivities_Id(Long id);

    List<Athlete> findByClubs_Id(Long id);
}
