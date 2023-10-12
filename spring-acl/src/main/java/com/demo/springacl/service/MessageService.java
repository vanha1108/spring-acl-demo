package com.demo.springacl.service;

import com.demo.springacl.entities.Message;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

public interface MessageService {

    @PostFilter("hasPermission(filterObject, 'WRITE')")
    List<Message> getAll();

    @SuppressWarnings("unchecked")
    @PreAuthorize("hasPermission(#message, 'WRITE')")
    Message save(Message message);

    @PostAuthorize("hasPermission(returnObject, 'READ')")
    Message getById(Integer id);

    @PreAuthorize("hasPermission(#message, 'DELETE')")
    void deleteMessage(Message message);
}
