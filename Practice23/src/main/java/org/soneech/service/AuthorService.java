package org.soneech.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.soneech.models.GameAuthor;
import org.soneech.repository.AuthorRepository;
import org.soneech.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class AuthorService {
    private final AuthorRepository authorRepository;
    private final GameRepository gameRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository, GameRepository gameRepository) {
        this.authorRepository = authorRepository;
        this.gameRepository = gameRepository;
    }

    public List<GameAuthor> getAuthors() {
        return authorRepository.findAll();
    }

    public GameAuthor getAuthorById(long id) {
        return authorRepository.findById(id);
    }

    public void addAuthor(GameAuthor author) {
        authorRepository.save(author);
    }

    public void deleteAuthor(long id) {
        GameAuthor author = authorRepository.findById(id);
        gameRepository.deleteAll(author.getGames());
        authorRepository.delete(author);
    }

    public void updateAuthor(long id, GameAuthor updatedAuthor) {
        GameAuthor author = getAuthorById(id);
        author.setNickname(updatedAuthor.getNickname());
        author.setBirthDate(updatedAuthor.getBirthDate());
        addAuthor(author);
    }

    public List<GameAuthor> orderedAuthorsByNickname() {
        return authorRepository.findAll(Sort.by("nickname"));
    }

    public List<GameAuthor> orderedAuthorsByBirthDate() {
        return authorRepository.findAll(Sort.by("birthDate"));
    }
}
