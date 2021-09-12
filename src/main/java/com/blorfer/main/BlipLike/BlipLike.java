package com.blorfer.main.BlipLike;

import com.blorfer.main.Blip.Blip;
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
@Entity(name = "BlipLike")
@Table(name = "blip_like")
public class BlipLike {
    @Id
    @SequenceGenerator(
            name = "blip_comment_id_sequence",
            sequenceName = "blip_comment_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "blip_comment_id_sequence"
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
            name = "blip_account_like_id",
            referencedColumnName = "id",
            nullable = false,
            foreignKey = @ForeignKey(
                    name = "blip_account_like_fk"
            )
    )
    private BlipAccount blipAccount;
    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "blip_id",
            referencedColumnName = "id",
            nullable = false,
            foreignKey = @ForeignKey(
                    name = "blip_id_fk"
            )
    )
    private Blip blip;
    @Column(
            name = "created_at",
            columnDefinition = "TIMESTAMP WITHOUT TIME ZONE"
    )
    private LocalDateTime createdAt;

    public BlipLike(BlipAccount blipAccount, Blip blip, LocalDateTime createdAt) {
        this.blipAccount = blipAccount;
        this.blip = blip;
        this.createdAt = createdAt;
    }
}
