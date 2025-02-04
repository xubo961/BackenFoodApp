package com.app.foodapp.dto;

import com.app.foodapp.models.Roles;

public class RoleDTO {

    private Long id;
    private String name;
    private String image;
    private String description;
    private String route;

    public RoleDTO(Roles role) {
        this.id = role.getId();
        this.name = role.getName();
        this.image = role.getImage();
        this.description = role.getDescription();
        this.route = role.getRoute();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }
}
