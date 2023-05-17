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
@RequiredArgsConstructor
@Transactional
public class AuthorService {
    private AuthorRepository authorRepository;
    private GameRepository gameRepository;
    private EmailService emailService;

    @Autowired
    public AuthorService(AuthorRepository authorRepository, GameRepository gameRepository, EmailService emailService) {
        this.authorRepository = authorRepository;
        this.gameRepository = gameRepository;
        this.emailService = emailService;
    }

    public List<GameAuthor> getAuthors() {
        return authorRepository.findAll();
    }

    public GameAuthor getAuthorById(Long id) {
        return authorRepository.findById(id).get();
    }

    public void addAuthor(GameAuthor author) {
        emailService.sendNotification("Save new object: " +
                author.getClass().getName() + ", hash code: " + author.hashCode());
        authorRepository.save(author);
    }

    public void deleteAuthor(GameAuthor author) {
        gameRepository.deleteAll(author.getGames());
        authorRepository.delete(author);
    }

    public void updateAuthor(Long id, GameAuthor updatedAuthor) {
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
