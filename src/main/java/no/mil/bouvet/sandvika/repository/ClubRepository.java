package no.mil.bouvet.sandvika.repository;

import no.mil.bouvet.sandvika.domain.Club;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClubRepository extends JpaRepository<Club, Long>
{
    List<Club> findByAthletes_Id(Long id);
}
