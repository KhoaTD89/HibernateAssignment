package edu.fa.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "timehall")
public class TimeHall extends BaseEntity{

    @Column(name = "hallId")
    private int hallId;

    @Column(name = "time_id")
    private double timeId;

    @ManyToOne
    @JoinColumn(name = "hall_id", referencedColumnName = "hall_id")
    private Hall hall;

    @ManyToOne
    @JoinColumn(name = "time_id", referencedColumnName = "time_id")
    private Time time;


}
