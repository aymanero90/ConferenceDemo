package com.example.ConferenceDemo.repositories;

import com.example.ConferenceDemo.models.Session;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository extends JpaRepository <Session, Long> {       // the interface for the data access layer
}
