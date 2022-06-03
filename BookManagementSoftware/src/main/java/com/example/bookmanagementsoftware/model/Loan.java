package com.example.bookmanagementsoftware.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Set;

@AllArgsConstructor @NoArgsConstructor @Getter @Setter
@Entity
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull(message = "userId is required")
    private Integer userId;
    @NotNull(message = "bookId is required")
    private Integer bookId;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JsonIgnore
    private Set<Book> books;

}
