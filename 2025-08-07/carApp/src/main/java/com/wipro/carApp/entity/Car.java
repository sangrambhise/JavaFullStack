package com.wipro.carApp.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Car {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String make;

    @OneToOne(cascade=CascadeType.ALL,orphanRemoval=true)
    @JoinColumn(name="registration_id",referencedColumnName="id")
    private CarRegistrationDetail registrationDetail;
}
