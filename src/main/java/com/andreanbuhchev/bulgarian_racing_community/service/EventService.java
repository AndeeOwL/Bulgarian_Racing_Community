package com.andreanbuhchev.bulgarian_racing_community.service;


import com.andreanbuhchev.bulgarian_racing_community.model.dto.EventDto;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;

public interface EventService {

    void addEvent(EventDto addEventModel, UserDetails userDetails);

    void buyEvent(Long id,UserDetails userDetails);

    void deleteEvent(Long id);
}
