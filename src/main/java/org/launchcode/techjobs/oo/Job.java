package org.launchcode.techjobs.oo;

import java.util.Objects;

public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    // TODO: Add two constructors - one to initialize a unique ID and a second to initialize the
    //  other five fields. The second constructor should also call the first in order to initialize
    //  the 'id' field.
    // Constructor to initialize a unique ID
    public Job() {
        id = nextId;
        nextId++;
    }

    // Constructor to initialize the other five fields
    public Job(String name, Employer employer, Location location, PositionType positionType, CoreCompetency coreCompetency) {
        this(); // Calls the first constructor to initialize the 'id' field
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;
    }

    // TODO: Add custom equals and hashCode methods. Consider two Job objects "equal" when their id fields
    //  match.
    // Custom equals method
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return id == job.id;
    }

    // Custom hashCode method
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    // TODO: Add getters for each field EXCEPT nextId. Add setters for each field EXCEPT nextID
    //  and id.
    // Getters for each field EXCEPT nextId
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public Location getLocation() {
        return location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    // Setters for each field EXCEPT nextId and id
    public void setName(String name) {
        this.name = name;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }

    // Custom toString method that includes blank lines and proper formatting
    @Override
    public String toString() {
        String result = "\n";
        result += "ID: " + id + "\n";
        result += "Name: " + (name == null || name.isEmpty() ? "Data not available" : name) + "\n";
        result += "Employer: " + (employer == null || employer.getValue().isEmpty() ? "Data not available" : employer.getValue()) + "\n";
        result += "Location: " + (location == null || location.getValue().isEmpty() ? "Data not available" : location.getValue()) + "\n";
        result += "Position Type: " + (positionType == null || positionType.getValue().isEmpty() ? "Data not available" : positionType.getValue()) + "\n";
        result += "Core Competency: " + (coreCompetency == null || coreCompetency.getValue().isEmpty() ? "Data not available" : coreCompetency.getValue()) + "\n";
        return result;
    }
}