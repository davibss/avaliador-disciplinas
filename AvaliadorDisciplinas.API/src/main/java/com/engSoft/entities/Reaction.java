package com.engSoft.entities;

import com.engSoft.DTO.ReactionDTO;
import com.engSoft.entities.types.LikeEnum;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Reaction {
    @Id
    @GeneratedValue
    private Long id;
    private Long idStudent;
    private Long idFeedback;
    private LikeEnum likeOrDislike;
    public Reaction(ReactionDTO reactionDTO){
        this.idStudent=reactionDTO.getIdStudent();
        this.likeOrDislike=reactionDTO.getLikeEnum();
    }

    public Reaction() {

    }
}
