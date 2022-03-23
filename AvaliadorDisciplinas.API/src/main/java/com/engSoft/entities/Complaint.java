package com.engSoft.entities;

import com.engSoft.DTO.ComplaintDTO;
import com.engSoft.DTO.ReactionDTO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Complaint {
    @Id
    @GeneratedValue
    private Long id;
    private Long idComment;
    private Long idStudent;

    public Complaint(ComplaintDTO complaintDTO) {
        this.idStudent=complaintDTO.getIdStudent();
        this.idComment=complaintDTO.getIdComment();
    }

    public Complaint() {

    }



    public Long getIdComment() {
        return idComment;
    }

    public Long getIdStudent() {
        return idStudent;
    }
}
