package com.wellsfargo.counselor.entity;

import java.security.Security;
import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Portfolio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "portfolio_id")
    private Long portfolioId;

    @OneToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @Column(nullable = false)
    private LocalDate createdDate;

    @OneToMany(mappedBy = "portfolio", cascade = CascadeType.ALL)
    private List<Security> securities;

    // Full Constructor
    public Portfolio(Long portfolioId, Client client,
                     LocalDate createdDate, List<Security> securities) {

        this.portfolioId = portfolioId;
        this.client = client;
        this.createdDate = createdDate;
        this.securities = securities;
    }

    public Portfolio() {}

    // Getters
    public Long getPortfolioId() { return portfolioId; }
    public Client getClient() { return client; }
    public LocalDate getCreatedDate() { return createdDate; }
    public List<Security> getSecurities() { return securities; }

    // Setters (No setter for ID)
    public void setClient(Client client) { this.client = client; }
    public void setCreatedDate(LocalDate createdDate) { this.createdDate = createdDate; }
    public void setSecurities(List<Security> securities) { this.securities = securities; }
}
