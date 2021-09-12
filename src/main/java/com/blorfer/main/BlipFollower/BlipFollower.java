package com.blorfer.main.BlipFollower;

import com.blorfer.main.BlipAccount.BlipAccount;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

import static javax.persistence.GenerationType.SEQUENCE;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity(name = "BlipFollower")
@Table(name = "blip_follower")
public class BlipFollower {
    @Id
    @SequenceGenerator(
            name = "blip_follower_id_sequence",
            sequenceName = "blip_follower_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "blip_follower_id_sequence"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;
    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "blip_account_to_follow",
            referencedColumnName = "id",
            nullable = false,
            foreignKey = @ForeignKey(
                    name = "blip_account_to_follow_fk"
            )
    )
    private BlipAccount blipAccountToFollow;
    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "blip_account_following",
            referencedColumnName = "id",
            nullable = false,
            foreignKey = @ForeignKey(
                    name = "blip_account_following_fk"
            )
    )
    private BlipAccount blipAccountFollowing;
    @Column(
            name = "created_at",
            columnDefinition = "TIMESTAMP WITHOUT TIME ZONE"
    )
    private LocalDateTime createdAt;

    public BlipFollower(BlipAccount blipAccountToFollow, BlipAccount blipAccountFollowing, LocalDateTime createdAt) {
        this.blipAccountToFollow = blipAccountToFollow;
        this.blipAccountFollowing = blipAccountFollowing;
        this.createdAt = createdAt;
    }
}
