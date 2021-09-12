package com.blorfer.main.UserProfile;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

import static javax.persistence.GenerationType.SEQUENCE;

@ToString
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "userProfile")
@Table(
        name = "user_profile",
        uniqueConstraints = @UniqueConstraint(
                name = "user_email_unique",
                columnNames = "email"
        )

)
public class UserProfile {
    @Id
    @SequenceGenerator(
            name = "user_profile_sequence",
            sequenceName = "user_profile_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "user_profile_sequence"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;
    @Column(
            name = "first_name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String firstName;
    @Column(
            name = "last_name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String lastName;
    @Column(
            name = "email",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String email;
    @Column(
            name = "gender",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String gender;
    @Column(
            name = "age",
            nullable = false
    )
    private Integer age;
    @Column(
            nullable = false,
            updatable = false,
            columnDefinition = "TIMESTAMP WITHOUT TIME ZONE"
    )
    private LocalDateTime created_at;

    public UserProfile(String firstName, String lastName, String email, String gender, Integer age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.age = age;
        this.created_at = LocalDateTime.now();
    }


}
