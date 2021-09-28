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
@Table(name = "customer")
public class Customer extends BaseEntity {

    @Column(name = "customer_name")
    private String name;

    @Column(name = "customer_age")
    private int age;

    @Column(name = "customer_phone")
    private int phone;

    @OneToMany(mappedBy = "customer")
    private List<Ticket> tickets;








}
