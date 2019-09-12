package no.bouvet.sandvika.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import static javax.persistence.CascadeType.ALL;

@Data
@EqualsAndHashCode
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Athlete implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String lastName;
    private String firstName;

    @ManyToMany(cascade = ALL)
    private List<Activity> activities;

    public List<Activity> getActivities()
    {
        if(activities == null)
        {
            activities = new ArrayList<>();
        }

        return activities;
    }

    @ManyToMany(cascade = ALL)
    private List<Club> clubs;

    public List<Club> getClubs()
    {
        if(clubs == null)
        {
            clubs = new ArrayList<>();
        }

        return clubs;
    }
}
