package com.andreanbuhchev.bulgarian_racing_community.service.impl;

import com.andreanbuhchev.bulgarian_racing_community.model.dto.EventDto;
import com.andreanbuhchev.bulgarian_racing_community.model.entity.Event;
import com.andreanbuhchev.bulgarian_racing_community.model.entity.ShoppingCart;
import com.andreanbuhchev.bulgarian_racing_community.model.entity.UserEntity;
import com.andreanbuhchev.bulgarian_racing_community.model.repository.EventRepository;
import com.andreanbuhchev.bulgarian_racing_community.model.repository.ShoppingCartRepository;
import com.andreanbuhchev.bulgarian_racing_community.model.repository.UserRepository;
import com.andreanbuhchev.bulgarian_racing_community.model.view.EventView;
import com.andreanbuhchev.bulgarian_racing_community.service.EventService;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class EventServiceImpl implements EventService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final EventRepository eventRepository;
    private final ShoppingCartRepository shoppingCartRepository;

    public EventServiceImpl(UserRepository userRepository, ModelMapper modelMapper, EventRepository eventRepository, ShoppingCartRepository shoppingCartRepository) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.eventRepository = eventRepository;
        this.shoppingCartRepository = shoppingCartRepository;
    }

    @Override
    public void addEvent(EventDto addEventModel, UserDetails userDetails) {
        Event newEvent = new Event();

        UserEntity user = userRepository.findByUsername(userDetails.getUsername()).
                orElseThrow();

        modelMapper.map(addEventModel,newEvent);
        newEvent.setUserEntity(user);



        eventRepository.save(newEvent);
    }

    @Override
    public void buyEvent(Long id,UserDetails userDetails) {

        Event event = eventRepository.findById(id).orElseThrow();

        ShoppingCart shoppingCart = shoppingCartRepository.findByUserEntityUsername(userDetails.getUsername());

        shoppingCart.getEvents().add(event);
    }

    @Override
    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);
    }

    @Override
    public List<EventView> findAll() {
        List<Event> events = eventRepository.findAll();
        List<EventView> eventViews = new ArrayList<>();

        events.forEach(event -> {
            EventView eventView = new EventView();
            modelMapper.map(event,eventView);
            eventView.setAuthor(event.getUserEntity().fullName());
            eventViews.add(eventView);
        });
        return eventViews;
    }
}
