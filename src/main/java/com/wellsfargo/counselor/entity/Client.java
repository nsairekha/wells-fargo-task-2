package com.wellsfargo.counselor.entity;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_id")
    private Long clientId;

    @ManyToOne
    @JoinColumn(name = "advisor_id", nullable = false)
    private FinancialAdvisor advisor;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(unique = true)
    private String email;

    @Column
    private String phoneNumber;

    @Column
    private LocalDate dateOfBirth;

    @Column
    private String status;

    @OneToOne(mappedBy = "client", cascade = CascadeType.ALL)
    private Portfolio portfolio;

    // Full Constructor
    public Client(Long clientId, FinancialAdvisor advisor, String firstName,
                  String lastName, String email, String phoneNumber,
                  LocalDate dateOfBirth, String status, Portfolio portfolio) {

        this.clientId = clientId;
        this.advisor = advisor;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
        this.status = status;
        this.portfolio = portfolio;
    }

    public Client() {}

    // Getters
    public Long getClientId() { return clientId; }
    public FinancialAdvisor getAdvisor() { return advisor; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getEmail() { return email; }
    public String getPhoneNumber() { return phoneNumber; }
    public LocalDate getDateOfBirth() { return dateOfBirth; }
    public String getStatus() { return status; }
    public Portfolio getPortfolio() { return portfolio; }

    // Setters (No setter for ID)
    public void setAdvisor(FinancialAdvisor advisor) { this.advisor = advisor; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setEmail(String email) { this.email = email; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    public void setDateOfBirth(LocalDate dateOfBirth) { this.dateOfBirth = dateOfBirth; }
    public void setStatus(String status) { this.status = status; }
    public void setPortfolio(Portfolio portfolio) { this.portfolio = portfolio; }
}
