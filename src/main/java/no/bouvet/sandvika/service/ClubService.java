package no.bouvet.sandvika.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import no.bouvet.sandvika.domain.Club;
import no.bouvet.sandvika.repository.ClubRepository;

@Service
public class ClubService
{
    private final ClubRepository clubRepository;

    public ClubService(final ClubRepository clubRepository)
    {
        this.clubRepository = clubRepository;
    }

    @Transactional(readOnly = true)
    public List<Club> getAllClubs()
    {
        return this.clubRepository.findAll();
    }
}
