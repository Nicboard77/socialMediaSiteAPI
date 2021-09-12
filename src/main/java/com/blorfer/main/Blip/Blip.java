package com.blorfer.main.Blip;

import com.blorfer.main.BlipAccount.BlipAccount;
import com.blorfer.main.BlipComment.BlipComment;
import com.blorfer.main.BlipLike.BlipLike;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

import static javax.persistence.GenerationType.SEQUENCE;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity(name = "Blip")
@Table(name = "blip")
public class Blip {
    @Id
    @SequenceGenerator(
            name = "blip_id_sequence",
            sequenceName = "blip_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "blip_id_sequence"
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
            name = "blip_poster_id",
            nullable = false,
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "blip_poster_id_fk"
            )
    )
    private BlipAccount blipAccountId;

    @OneToMany(
            mappedBy = "id"
    )
    private List<BlipLike> likeId;
    @OneToMany(
            mappedBy = "id"
    )
    private List<BlipComment> commentId;
    @Column(
            name = "blip_content",
            columnDefinition = "TEXT",
            nullable = false
    )
    private String blipContent;
    @Column(
            name = "created_at",
            columnDefinition = "TIMESTAMP WITHOUT TIME ZONE",
            nullable = false
    )
    private LocalDateTime createdAt;

    public Blip(BlipAccount blipAccountId, List<BlipLike> likeId, List<BlipComment> commentId, String blipContent, LocalDateTime createdAt) {
        this.blipAccountId = blipAccountId;
        this.likeId = likeId;
        this.commentId = commentId;
        this.blipContent = blipContent;
        this.createdAt = createdAt;
    }


}
