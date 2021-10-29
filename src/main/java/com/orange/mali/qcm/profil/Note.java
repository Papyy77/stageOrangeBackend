package com.orange.mali.qcm.profil;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.orange.mali.qcm.entities.Questionnaire;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "user")
@EqualsAndHashCode(exclude = "user")
public class Note implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne()
    @JoinColumn(name = "id_qcm", referencedColumnName = "id", insertable = false, updatable = false)
    @JsonIgnore
    private Questionnaire idQcm;
    private double note;
    @ManyToOne()
    @JoinColumn(name = "user", referencedColumnName = "id", insertable = false, updatable = false)
    @JsonIgnore
    private User user;

    private String email;
    private String qcm;

    private Date date;
}
