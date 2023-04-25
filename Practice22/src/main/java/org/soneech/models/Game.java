package org.soneech.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Entity
@Table(name = "games")
@Getter
@Setter
@NoArgsConstructor
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "creation_date")
    private Date creationDate;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "game_author_id")
    private GameAuthor gameAuthor;

    @Override
    public String toString() {
        return "Class: Game; id: " + id +
                "; name: " + name + "; creation_date: " + creationDate +
                "; game_author: " + gameAuthor.getNickname();
    }
}
