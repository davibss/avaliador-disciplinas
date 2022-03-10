package com.engSoft.repositories;

import com.engSoft.entities.Feedback;
import com.engSoft.entities.Reaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReactionRepository extends JpaRepository<Reaction,Long> {
    List<Feedback> findAllByCommentId(Long idComment);
}
