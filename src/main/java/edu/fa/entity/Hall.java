package edu.fa.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "hall")

public class Hall extends BaseEntity{


    @Column(name = "hall_name")
    private String hallName;

    @Column(name = "qty_seat")
    private int qtySeat;


    @OneToMany(mappedBy = "timehall")
    private List<TimeHall> timehall;

    @OneToMany(mappedBy = "seat")
    private Set<Seat> seat;

}