package com.example.ConferenceDemo.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity(name = "sessions")  // bind the JPA column name
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) // solve the problem with fetch one session per id, you do not have to serialize this (ignore)
public class Session {
    @Id // represents the primary key for this class
    @GeneratedValue(strategy = GenerationType.IDENTITY) // with this strategy JPA creates sequence for primary key values
    private Long session_id;
    private String session_name;             // They should be the exact name as DB columns, JPA will then bind them
    private String session_description;      // without annotating them with @Column
    private int session_length;


    @ManyToMany // The first side of the relationship
    @JoinTable(
            name = "session_speakers",   // Injection between speakers and sessions
            joinColumns = @JoinColumn(name= "session_id"),
            inverseJoinColumns = @JoinColumn( name = "speaker_id")
    )
    private List<Speaker> speakers;  // one session can have MANY speakers

    public Session(){

    }

    public Long getSession_id() {
        return session_id;
    }

    public void setSession_id(Long session_id) {
        this.session_id = session_id;
    }

    public String getSession_name() {
        return session_name;
    }

    public void setSession_name(String session_name) {
        this.session_name = session_name;
    }

    public String getSession_description() {
        return session_description;
    }

    public void setSession_description(String session_description) {
        this.session_description = session_description;
    }

    public int getSession_length() {
        return session_length;
    }

    public void setSession_length(int session_length) {
        this.session_length = session_length;
    }

    public List<Speaker> getSpeakers() { return speakers;}

    public void setSpeakers(List<Speaker> speakers) { this.speakers = speakers;}
}
