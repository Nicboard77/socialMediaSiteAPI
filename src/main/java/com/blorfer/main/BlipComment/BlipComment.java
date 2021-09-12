package com.blorfer.main.BlipComment;

import com.blorfer.main.Blip.Blip;
import com.blorfer.main.BlipAccount.BlipAccount;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

import static javax.persistence.GenerationType.SEQUENCE;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity(name = "BlipComment")
@Table(name = "blip_comment")
public class BlipComment {
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
            name = "blip_account_id",
            referencedColumnName = "id",
            nullable = false,
            foreignKey = @ForeignKey(
                    name = "blip_account_id_comment_fk"
            )
    )
    private BlipAccount blipCommentPoster;
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
    private Blip blipToPost;
    @Column(
            name = "comment_content"
    )
    private String commentContent;
    @Column(
            name = "created_at",
            columnDefinition = "TIMESTAMP WITHOUT TIME ZONE"
    )
    private LocalDateTime createdAt;

    public BlipComment(BlipAccount blipCommentPoster, Blip blipToPost, LocalDateTime createdAt) {
        this.blipCommentPoster = blipCommentPoster;
        this.blipToPost = blipToPost;
        this.createdAt = createdAt;
    }
}
