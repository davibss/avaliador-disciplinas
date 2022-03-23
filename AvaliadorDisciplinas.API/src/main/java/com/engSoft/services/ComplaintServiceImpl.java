package com.engSoft.services;

import com.engSoft.entities.Comment;
import com.engSoft.entities.Complaint;
import com.engSoft.entities.User;
import com.engSoft.repositories.ComplaintRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ComplaintServiceImpl implements ComplaintService{
    @Autowired
    ComplaintRepository complaintRepository;

    @Override
    public void saveComplaint(Complaint complaint) {
        this.complaintRepository.save(complaint);

    }

    @Override
    public List<Complaint> listComplaints() {
        return this.complaintRepository.findAll();
    }

    @Override
    public List<Complaint> findComplaintByStudent (Long idStudent) {
        return null;
    }

    @Override
    public void removeComplaint(Long idcomplaint) {
        this.complaintRepository.deleteById(idcomplaint);

    }

    @Override
    public Optional<Complaint> findComplaintById(Long id) {
        return this.complaintRepository.findById(id);
    }

    @Override
    public void updateReports(User user, Complaint Complaint) {
        user.setReportedComments(user.getReportedComments()+1);

    }

    @Override
    public void removeReports(User user, Complaint Complaint) {
        user.setReportedComments(user.getReportedComments()-1);

    }

    @Override
    public List<Complaint> findAllByIdComment(Long idComment) {
        return this.complaintRepository.findAllByIdComment(idComment);
    }

    @Override
    public List<Complaint> findAllByIdStudent(Long idStudent) {
        return this.complaintRepository.findAllByIdStudent(idStudent);
    }


}
