package oumoulay.net.tp03.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Collection;
import java.util.Date;

@Entity @NoArgsConstructor @AllArgsConstructor @Data @ToString
public class Patient {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;

    @Temporal(TemporalType.DATE)
    private Date dateNaissance;
    private boolean malade;
    private int score;
    /*@OneToMany(mappedBy = "patient" , fetch = FetchType.LAZY)
    private Collection<RendezVous> rendezVous;

     */

}
