package org.soneech.repository;

import org.soneech.models.GameAuthor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<GameAuthor, Long> { }
