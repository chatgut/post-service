package com.example.postservice.service;

import com.example.postservice.dto.EntityDto;
import com.example.postservice.entity.MessageEntity;
import com.example.postservice.repository.MessageRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MessageService {

    private final MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public MessageEntity save(MessageEntity messageEntity) {
        return messageRepository.save(messageEntity);
    }

    public List<MessageEntity> getMessages() {
        return messageRepository.findAll();
    }

    public List<EntityDto> findBySenderUsername(String senderUsername) {
        return messageRepository.findBySenderUsername(senderUsername).stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    public EntityDto mapToDto(MessageEntity messageEntity) {
        EntityDto dto = new EntityDto(String.valueOf(messageEntity.id()), messageEntity.senderUsername(), messageEntity.recieverUsername(), messageEntity.message());
        dto.setId(messageEntity.id());
        dto.setSenderUsername(messageEntity.senderUsername());
        dto.setRecieverUsername(messageEntity.recieverUsername());
        dto.setMessage(messageEntity.message());
        return dto;
    }
}