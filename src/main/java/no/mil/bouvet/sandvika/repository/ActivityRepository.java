package no.mil.bouvet.sandvika.repository;

import no.mil.bouvet.sandvika.domain.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ActivityRepository extends JpaRepository<Activity, Long>
{
    List<Activity> findByAthletes_Id(Long id);
}