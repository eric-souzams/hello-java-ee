package org.jakarta.hibernate.jpa.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "client_details")
public class ClientDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "prime")
    private boolean prime;

    @Column(name = "accumulated_points")
    private Long accumulatedPoints;

    @OneToOne
    @JoinColumn(name = "client_id")
    private Client client;

    public ClientDetails() {}

    public ClientDetails(boolean prime, Long accumulatedPoints) {
        this.prime = prime;
        this.accumulatedPoints = accumulatedPoints;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isPrime() {
        return prime;
    }

    public void setPrime(boolean prime) {
        this.prime = prime;
    }

    public Long getAccumulatedPoints() {
        return accumulatedPoints;
    }

    public void setAccumulatedPoints(Long accumulatedPoints) {
        this.accumulatedPoints = accumulatedPoints;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "ClientDetails = {" +
                "id=" + id +
                ", prime=" + prime +
                ", accumulatedPoints='" + accumulatedPoints + '\'' +
                ", client=" + client.getId() +
                '}';
    }
}
