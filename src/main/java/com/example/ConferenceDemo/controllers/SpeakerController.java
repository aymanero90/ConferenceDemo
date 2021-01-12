package com.example.ConferenceDemo.controllers;

import com.example.ConferenceDemo.models.Speaker;
import com.example.ConferenceDemo.repositories.SpeakerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController     //define the rest controller to handle the sessions requests
@RequestMapping("/api/v1/speakers")   // tell the router where to look or what mapping look like

public class SpeakerController {

    @Autowired
    private SpeakerRepository speakerRepository;

    @GetMapping
    public List<Speaker> list() {
        return speakerRepository.findAll();
    }

    @GetMapping
    @RequestMapping ("{id}")
    public Speaker get (@PathVariable Long id) {
        return speakerRepository.getOne(id);
    }

    @PostMapping
    public Speaker create (@RequestBody final Speaker speaker){
        return speakerRepository.saveAndFlush(speaker);
    }

    @RequestMapping (value = "{id}", method = RequestMethod.DELETE)
    public void delete (@PathVariable Long id){
        // check for children
        speakerRepository.deleteById(id);
    }

    @RequestMapping (value = "{id}", method = RequestMethod.PUT)
    public Speaker update (@PathVariable Long id , @RequestBody Speaker speaker){
        Speaker existingSpeaker = speakerRepository.getOne(id);
        BeanUtils.copyProperties(speaker, existingSpeaker, "speaker_id");  // ignore speaker_id, may not be changed
        return speakerRepository.saveAndFlush(existingSpeaker);
    }


}
