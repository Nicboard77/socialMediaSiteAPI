package com.blorfer.main.BlipAccount;

import com.blorfer.main.UserProfile.UserProfile;
import lombok.*;

import javax.persistence.*;

import java.time.LocalDateTime;

import static javax.persistence.GenerationType.SEQUENCE;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity(name = "blipAccount")
@Table(name = "blip_account")
public class BlipAccount {
    @Id
    @SequenceGenerator(
            name = "blip_account_id_sequence",
            sequenceName = "blip_account_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "blip_account_id_sequence"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;
    @OneToOne(
            cascade = {CascadeType.MERGE, CascadeType.REMOVE, CascadeType.REFRESH})
    @JoinColumn(
            name = "user_profile_id",
            nullable = false,
            updatable = false,
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "user_profile_id_fk"
            )
    )
    private UserProfile userProfile;
    @Column(
            name = "username",
            nullable = false
    )
    private String username;
    @Column(
            name = "created_at",
            nullable = false
    )
    private LocalDateTime createdAt;

    public BlipAccount(UserProfile userProfile, String username, LocalDateTime createdAt) {
        this.userProfile = userProfile;
        this.username = username;
        this.createdAt = createdAt;
    }

    public BlipAccount(UserProfile userProfile, String username) {
        this.userProfile = userProfile;
        this.username = username;
        this.createdAt = LocalDateTime.now();
    }
}
