package org.jakarta.hibernate.jpa.model.dto;

public class ClientDto {

    private String name;
    private String underName;

    public ClientDto() {
    }

    public ClientDto(String name, String underName) {
        this.name = name;
        this.underName = underName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnderName() {
        return underName;
    }

    public void setUnderName(String underName) {
        this.underName = underName;
    }

    @Override
    public String toString() {
        return "ClientDto = {" +
                "name='" + name + '\'' +
                ", underName='" + underName + '\'' +
                '}';
    }
}
