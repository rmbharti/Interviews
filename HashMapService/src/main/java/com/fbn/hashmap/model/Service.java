package com.fbn.hashmap.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "services")
public class Service {

    @Id
    private String id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private boolean bindable;

    @OneToMany(orphanRemoval = true)
    @JoinColumn(name = "service_id")
    private Set<Plan> plans = new HashSet<>();

    @Transient
    private final Metadata metadata;

    public Service() {
        this.metadata = new Metadata();
    }

    public Metadata getMetadata() {
        return metadata;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public boolean isBindable() {
        return bindable;
    }

    public void setBindable(boolean bindable) {
        this.bindable = bindable;
    }

    public Set<Plan> getPlans() {
        return plans;
    }

    public void setPlans(Set<Plan> plans) {
        this.plans = plans;
    }

    public void addPlan(Plan plan) {
        this.plans.add(plan);
    }
    

 /*   *//**
     * A Builder class used to create new Person objects.
     *//*
    public static class Builder {
        Service built;

        *//**
         * Creates a new Builder instance.
         * @param firstName The first name of the created Person object.
         * @param lastName  The last name of the created Person object.
         *//*
        Builder(String firstName, String lastName) {
            built = new Service();
            built.firstName = firstName;
            built.lastName = lastName;
        }

        *//**
         * Builds the new Person object.
         * @return  The created Person object.
         *//*
        public Person build() {
            return built;
        }
    }*/
}
