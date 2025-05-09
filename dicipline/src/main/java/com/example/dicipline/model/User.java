package com.example.dicipline.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Id;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String email;

    private String password;

    private int totalViolations; // Ajout du champ manquant

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Violation> violations;

    private LocalDateTime lastMonitoringPing;

    private int tamperAttempts;

    // @OneToMany
    //Indique que l’entité courante possède une collection (généralement une List ou un Set)
    // d’objets d’une autre entité.
    //mappedBy = "user"
    //Précise que la gestion de la clé étrangère se fait côté opposé (l’entité “many”).
    //e mappedBy = "user" dit à Hibernate : « Ne crée pas de colonne supplémentaire dans la table du côté “one” ;
    // la colonne user_id est déjà définie dans la table many, via l’attribut user. »
    //cascade = CascadeType.ALL
    //Définit le comportement des opérations en cascade entre l’entité “one” et ses “many”. Avec ALL,
    // toutes les opérations Hibernate effectuées sur le User seront propagées aux entités liées :
    //PERSIST : si vous enregistrez un User, ses entités “many” seront aussi enregistrées automatiquement.
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Plan> plans;

    private LocalDateTime planStartDate;
    private int currentPhase;
    private int streakDays;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<BlockedSite> blockedSites;
}
