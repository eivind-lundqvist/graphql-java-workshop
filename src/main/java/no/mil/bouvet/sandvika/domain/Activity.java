package no.mil.bouvet.sandvika.domain;

import java.io.Serializable;
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
import lombok.ToString;

@Data
@EqualsAndHashCode
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Activity implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @ManyToMany(mappedBy = "activities")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Athlete> athletes;

    private String name;
    private String description;
    private double distanceInMeters;
    private int movingTimeInSeconds;
    private int elapsedTimeInSeconds;
    private double totalElevationGainInMeters;
    private float averageHeartrate;
    private int maxHeartrate;
}
