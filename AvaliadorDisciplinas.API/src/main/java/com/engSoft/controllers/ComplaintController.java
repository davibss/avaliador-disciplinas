package com.engSoft.controllers;

import com.engSoft.services.CommentService;
import com.engSoft.services.ComplaintService;
import com.engSoft.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ComplaintController {

    @Autowired
    CommentService commentService;

    @Autowired
    UserService userService;

    @Autowired
    ComplaintService complaintService;

    


}
