package com.engSoft.DTO;

import com.engSoft.entities.types.LikeEnum;

public class ReactionDTO {
    private Long idStudent;
    private LikeEnum likeEnum;


    public Long getIdStudent() {
        return idStudent;
    }

    public LikeEnum getLikeEnum() {
        return likeEnum;
    }
}
