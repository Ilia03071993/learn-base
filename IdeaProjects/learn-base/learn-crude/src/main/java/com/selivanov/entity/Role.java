package com.selivanov.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @ManyToMany(cascade = CascadeType.PERSIST, mappedBy = "roles")
    private List<ApplicationUser> users;
}
