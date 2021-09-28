package com.hibernate.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Table(name = "movie")
public class Movie extends BaseEntity{
    @Column(name = "name")
    private String name;

    @Column(name = "gerne")
    private String gerne;

    private String language;

    private double duration;

    @OneToMany(mappedBy = "movie")
    private List<ScreenTimeMovie> screenTimeMovie;
}
