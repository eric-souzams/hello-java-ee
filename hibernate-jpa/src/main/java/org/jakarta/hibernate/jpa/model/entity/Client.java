package org.jakarta.hibernate.jpa.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "under_name")
    private String underName;

    @Column(name = "payment_type")
    private String paymentType;

    public Client() {
    }

    public Client(String name, String underName) {
        this.name = name;
        this.underName = underName;
    }

    public Client(Long id, String name, String underName, String paymentType) {
        this.id = id;
        this.name = name;
        this.underName = underName;
        this.paymentType = paymentType;
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

    public String getUnderName() {
        return underName;
    }

    public void setUnderName(String underName) {
        this.underName = underName;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    @Override
    public String toString() {
        return "Client = {" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", underName='" + underName + '\'' +
                ", paymentType='" + paymentType + '\'' +
                '}';
    }
}
