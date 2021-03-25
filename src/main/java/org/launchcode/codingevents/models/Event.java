package org.launchcode.codingevents.models;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.*;

@Entity
public class Event {

    @Id
    @GeneratedValue
    private int id;


    @NotBlank(message = "Name is required")
    @Size(min = 3, max = 12, message = "Name must be between 3 and 12 chars long")
    private String name;

    @Size(max = 50, message = "Description too long")
    private String description;

    //Enum
    private EventType type;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email. Try again")
    private String contactEmail;

    @NotNull(message = "Location cannot be null")
    @NotBlank(message = "Location cannot be blank")
    @Size(min = 2, max = 50, message = "Location is required")
    private String location;

    private Boolean registration;

    @Positive(message = "Number must be positive")
    private Integer attendees;

    public Event(String name, String description, String contactEmail, EventType type, String location, Boolean registration, Integer attendees) {
        this.name = name;
        this.description = description;
        this.contactEmail = contactEmail;
        this.type = type;
        this.location = location;
        this.registration = registration;
        this.attendees = attendees;
    }

    public Event(){

    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getDescription() {

        return description;
    }

    public void setDescription(String description) {

        this.description = description;
    }

    public String getContactEmail() {

        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {

        this.contactEmail = contactEmail;
    }

    public EventType getType() {

        return type;
    }

    public void setType(EventType type) {

        this.type = type;
    }

    public String getLocation() {

        return location;
    }

    public void setLocation(String location) {

        this.location = location;
    }

    public Boolean getRegistration() {

        return registration;
    }

    public void setRegistration(Boolean registration) {

        this.registration = registration;
    }

    public Integer getAttendees() {

        return attendees;
    }

    public void setAttendees(Integer attendees) {

        this.attendees = attendees;
    }

    public int getId() {

        return id;
    }

    @Override
    public String toString() {

        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return id == event.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
