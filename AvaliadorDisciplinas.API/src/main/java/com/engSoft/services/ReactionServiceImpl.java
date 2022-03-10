package com.engSoft.services;

import com.engSoft.entities.Reaction;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ReactionServiceImpl implements ReactionService{
    @Override
    public List<Reaction> listReaction(Long idComment) {
        return null;
    }

    @Override
    public void saveReaction(Reaction reaction) {

    }
}
