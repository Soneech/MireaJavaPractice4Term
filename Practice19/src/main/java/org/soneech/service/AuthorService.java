package org.soneech.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.soneech.models.GameAuthor;
import org.soneech.repository.AuthorRepository;
import org.soneech.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthorService {
    private AuthorRepository authorRepository;
    private GameRepository gameRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository, GameRepository gameRepository) {
        this.authorRepository = authorRepository;
        this.gameRepository = gameRepository;
    }

    public List<GameAuthor> getAuthors() {
        log.info("Find all authors");
        return authorRepository.findAll();
    }

    public GameAuthor getAuthorById(Long id) {
        log.info("Getting author by id");
        return authorRepository.findById(id).get();
    }

    public void addAuthor(GameAuthor author) {
        log.info("Adding author to DB with data from form");
        authorRepository.save(author);
    }

    public void deleteAuthor(GameAuthor author) {
        log.info("Deleting author from DB");
        gameRepository.deleteAll(author.getGames());
        authorRepository.delete(author);
    }

    public void updateAuthor(Long id, GameAuthor updatedAuthor) {
        log.info("Updating author with data from update form");
        GameAuthor author = getAuthorById(id);
        author.setNickname(updatedAuthor.getNickname());
        author.setBirthDate(updatedAuthor.getBirthDate());
        addAuthor(author);
    }

    public List<GameAuthor> orderedAuthorsByNickname() {
        log.info("Getting list of authors, ordered by nickname");
        return authorRepository.findAll(Sort.by("nickname"));
    }

    public List<GameAuthor> orderedAuthorsByBirthDate() {
        log.info("Getting list of authors, ordered by birth date");
        return authorRepository.findAll(Sort.by("birthDate"));
    }
}
