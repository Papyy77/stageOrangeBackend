package com.orange.mali.qcm.profil;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "note")
@EqualsAndHashCode(exclude = "note")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String login;
    private String password;
    private String email;
    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Note> notes;
}
