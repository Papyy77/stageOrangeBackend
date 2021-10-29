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
@ToString(exclude = {"choices", "questionnaire"})
@EqualsAndHashCode(exclude = {"choices", "questionnaire"})
public class Question implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String type;
    @OneToMany(mappedBy = "question")
    @JsonIgnore
    private List<Choice> choices;
    @ManyToOne()
    @JoinColumn(name = "questionnaire", referencedColumnName = "id", insertable = false, updatable = false)
    @JsonIgnore
    private Questionnaire questionnaire;
}
