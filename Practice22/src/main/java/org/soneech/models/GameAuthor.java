package org.soneech.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "authors")
@Getter
@Setter
@NoArgsConstructor
public class GameAuthor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "nickname")
    private String nickname;
    @Basic
    @Column(name = "birth_date")
    private Date birthDate;

    @OneToMany(mappedBy = "gameAuthor", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Game> games;

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder
                .append("Class: GameAuthor; id: ").append(id)
                .append("; nickname: ").append(nickname)
                .append("; birth_date: ").append(birthDate.toString())
                .append(";\n\tgames:");

        for (Game game: games) {
            stringBuilder.append("\n\t\t")
                    .append("id: ").append(game.getId())
                    .append("; name: ").append(game.getName())
                    .append("; creation_date: ").append(game.getCreationDate());
        }
        return stringBuilder.toString();
    }
}
