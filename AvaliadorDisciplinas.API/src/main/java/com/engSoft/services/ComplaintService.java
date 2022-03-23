package com.engSoft.services;

import com.engSoft.entities.Comment;
import com.engSoft.entities.Complaint;
import com.engSoft.entities.User;

import java.util.List;
import java.util.Optional;

public interface ComplaintService {
    public void saveComplaint(Complaint Complaint);
    public List<Complaint> listComplaints();
    public List<Complaint> findComplaintByStudent(Long idStudent);
    public void removeComplaint(Long idComplaint);
    public Optional<Complaint> findComplaintById(Long id);
    public void updateReports(User user, Complaint Complaint);
    public void removeReports(User user,Complaint Complaint);
    public List<Complaint> findAllByIdComment(Long idComment);
    public List<Complaint> findAllByIdStudent(Long idStudent);
}
