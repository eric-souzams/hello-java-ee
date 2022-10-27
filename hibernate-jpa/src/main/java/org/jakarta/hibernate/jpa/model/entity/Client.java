package org.jakarta.hibernate.jpa.model.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "client")
    @JoinColumn(name = "client_details_id")
    private ClientDetails clientDetails;

//    @JoinColumn(name = "client_id")
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinTable(name = "clients_addresses",
               joinColumns = @JoinColumn(name = "client_id"),
               inverseJoinColumns = @JoinColumn(name = "address_id"),
               uniqueConstraints = @UniqueConstraint(columnNames = {"address_id"}))
    private List<Address> addresses;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "client")
    private List<Invoice> invoices;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @PrePersist
    public void prePersist() {
        System.out.println("Starting pre persist Client");
        this.createdAt = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        System.out.println("Starting pre update Client");
        this.updatedAt = LocalDateTime.now();
    }

    @PreRemove
    public void preRemove() {
        System.out.println("Starting pre remove Client");
    }

    public Client() {
        this.addresses = new ArrayList<>();
        this.invoices = new ArrayList<>();
    }

    public Client(String name, String underName) {
        this();
        this.name = name;
        this.underName = underName;
    }

    public Client(Long id, String name, String underName, String paymentType) {
        this();
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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public Client addAddress(Address address) {
        this.addresses.add(address);

        return this;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public List<Invoice> getInvoices() {
        return invoices;
    }

    public void setInvoices(List<Invoice> invoices) {
        this.invoices = invoices;
    }

    public ClientDetails getClientDetails() {
        return clientDetails;
    }

    public void setClientDetails(ClientDetails clientDetails) {
        this.clientDetails = clientDetails;
    }

    public Client addInvoices(Invoice invoice) {
        invoice.setClient(this);
        this.invoices.add(invoice);

        return this;
    }

    public Client removeInvoices(Invoice invoice) {
        this.invoices.remove(invoice);

        return this;
    }

    public Client removeAddress(Address address) {
        this.addresses.remove(address);

        return this;
    }

    public void addDetail(ClientDetails clientDetails) {
        this.clientDetails = clientDetails;
        clientDetails.setClient(this);
    }

    public void removeDetail() {
        this.clientDetails.setClient(null);
        this.clientDetails = null;
    }

    @Override
    public String toString() {
        return "Client {" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", underName='" + underName + '\'' +
                ", paymentType='" + paymentType + '\'' +
                ", addresses=" + addresses +
                ", invoices=" + invoices +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
