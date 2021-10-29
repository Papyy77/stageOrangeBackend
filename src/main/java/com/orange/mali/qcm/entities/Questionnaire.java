package com.orange.mali.qcm.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "question")
@EqualsAndHashCode(exclude = "question")
public class Questionnaire implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String description;
    private String duration;
    private String title;
    @OneToMany(mappedBy = "questionnaire")
    @JsonIgnore
    private List<Question> questions;
}
