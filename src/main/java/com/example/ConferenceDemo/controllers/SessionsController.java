package com.example.ConferenceDemo.controllers;

import com.example.ConferenceDemo.repositories.SessionRepository;
import com.example.ConferenceDemo.models.Session;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController  //define the rest controller to handle the sessions requests
@RequestMapping("/api/v1/sessions")  // tell the router where to look or what mapping look like
public class SessionsController {
    @Autowired   // connect the repo (DB interface)
    private SessionRepository sessionRepository;  // inject the session interface

    @GetMapping
    public List<Session> list() {
        return sessionRepository.findAll();
    }

    @GetMapping
    @RequestMapping(value = "{id}" /*, method = RequestMethod.GET*/)
    public Session get(@PathVariable Long id) {
        return sessionRepository.getOne(id);
    }

    @PostMapping
    public Session create (@RequestBody final Session session) {   // Ido not know why it is not void
        return sessionRepository.saveAndFlush(session);
    }

    @RequestMapping(value = "{id}" , method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id){
        // check for children records
        sessionRepository.deleteById(id);
    }

    @RequestMapping ( value = "{id}", method = RequestMethod.PUT )   // why it is not void
    public Session update (@PathVariable Long id , @RequestBody Session session){
        Session existingSession = sessionRepository.getOne(id);
        BeanUtils.copyProperties(session, existingSession, "session_id" ); // ignore copying session_id , this may not be changed
        return sessionRepository.saveAndFlush(existingSession);
    }

}
