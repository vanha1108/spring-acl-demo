package com.demo.springacl.controllers;

import com.demo.springacl.entities.Message;
import com.demo.springacl.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/message")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @GetMapping
    public List<Message> findAllMessages() {
        return messageService.getAll();
    }

    @GetMapping("/saveM1U1")
    public ResponseEntity<?> testSaveMessage1ByUser1() {
        try {
            Message message = new Message();
            message.setId(1);
            message.setContent("This is a message 1 updated by User 1");
            messageService.save(message);
            return new ResponseEntity<>(message, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/saveM2U1")
    public ResponseEntity<?> testSaveMessage2ByUser1() {
        try {
            Message message = new Message();
            message.setId(2);
            message.setContent("This is a message 2 updated by User 1");
            messageService.save(message);
            return new ResponseEntity<>(message, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/saveM1U2")
    public ResponseEntity<?> testSaveMessage1ByUser2() {
        try {
            Message message = new Message();
            message.setId(1);
            message.setContent("This is a message 1 updated by User 2");
            messageService.save(message);
            return new ResponseEntity<>(message, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/saveM2U2")
    public ResponseEntity<?> testSaveMessage2ByUser2() {
        try {
            Message message = new Message();
            message.setId(2);
            message.setContent("This is a message 2 updated by User 2");
            messageService.save(message);
            return new ResponseEntity<>(message, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getMessageById(@PathVariable Integer id) {
        try {
            return new ResponseEntity<>(messageService.getById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<?> deleteMessageById(@PathVariable Integer id) {
        try {
            Message message = messageService.getById(id);
            messageService.deleteMessage(message);
            return new ResponseEntity<>("Delete message successful!", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
