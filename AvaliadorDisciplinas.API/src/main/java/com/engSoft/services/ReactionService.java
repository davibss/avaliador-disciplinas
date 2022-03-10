package com.engSoft.services;

import com.engSoft.entities.Feedback;
import com.engSoft.entities.Reaction;

import java.util.List;

public interface ReactionService {
    public List<Reaction> listReaction(Long idComment);
    public void saveReaction (Reaction reaction);
}
