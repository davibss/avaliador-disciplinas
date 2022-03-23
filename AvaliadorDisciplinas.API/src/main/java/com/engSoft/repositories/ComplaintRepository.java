package com.engSoft.repositories;

import com.engSoft.entities.Complaint;
import com.engSoft.entities.Reaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ComplaintRepository extends JpaRepository<Complaint,Long> {
    List<Complaint> findAllByIdComment(Long idComment);
    List<Complaint> findAllByIdStudent(Long idStudent);
}
