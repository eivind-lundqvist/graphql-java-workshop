package no.bouvet.sandvika.repository;

import no.bouvet.sandvika.domain.Athlete;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Stream;

@Repository
public interface AthleteRepository extends JpaRepository<Athlete, Long>
{
    List<Athlete> findByLastName(String lastName);

    List<Athlete> findByActivities_Id(Long id);

    List<Athlete> findByClubs_Id(Long id);

    @Query("from Athlete")
    Stream<Athlete> streamAll();

}
