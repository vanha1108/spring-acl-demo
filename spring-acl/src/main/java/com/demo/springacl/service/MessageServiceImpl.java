package com.demo.springacl.service;

import com.demo.springacl.entities.Message;
import com.demo.springacl.repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.acls.model.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageRepository messageRepository;

    @Override
    public List<Message> getAll() {
        return messageRepository.findAll();
    }

    @Override
    public Message save(Message message) {
        return messageRepository.save(message);
    }

    @Override
    public Message getById(Integer id) {
        return messageRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Message not found"));
    }

    @Override
    public void deleteMessage(Message message) {
        messageRepository.delete(message);
    }
}
