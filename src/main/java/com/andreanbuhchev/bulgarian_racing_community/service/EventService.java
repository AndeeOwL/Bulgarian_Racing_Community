package com.andreanbuhchev.bulgarian_racing_community.service;


import com.andreanbuhchev.bulgarian_racing_community.model.dto.EventDto;
import com.andreanbuhchev.bulgarian_racing_community.model.view.EventView;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface EventService {

    void addEvent(EventDto addEventModel, UserDetails userDetails);

    void buyEvent(Long id,UserDetails userDetails);

    void deleteEvent(Long id);

    List<EventView> findAll();
}
