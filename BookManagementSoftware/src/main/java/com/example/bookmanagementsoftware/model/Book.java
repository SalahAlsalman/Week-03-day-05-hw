package com.example.bookmanagementsoftware.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@AllArgsConstructor @NoArgsConstructor @Getter @Setter
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "name is required")
    private String name;
    @NotEmpty(message = "genre is required")
    private String genre;

    @ManyToMany(mappedBy = "books",cascade = CascadeType.ALL)
    private Set<Loan> loans;


}
