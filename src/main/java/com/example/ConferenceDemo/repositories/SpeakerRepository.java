package com.example.ConferenceDemo.repositories;

import com.example.ConferenceDemo.models.Speaker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpeakerRepository extends JpaRepository <Speaker, Long> {     // the interface for the data access layer
}
