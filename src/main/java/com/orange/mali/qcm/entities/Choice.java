package com.orange.mali.qcm.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "question")
@EqualsAndHashCode(exclude = "question")
public class Choice implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private boolean isAnswer;
    @ManyToOne()
    @JoinColumn(name = "question", referencedColumnName = "id", insertable = false, updatable = false)
    @JsonIgnore
    private Question question;
}
