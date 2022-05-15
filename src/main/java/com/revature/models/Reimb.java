package com.revature.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ers_reimbursements")
public class Reimb {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "reimb_id")
    private int id;

    @Column(name = "amount")
    private double amount;

    @Column(name = "submitted")
    private LocalDate submitted;

    @Column(name = "resolved")
    private LocalDate resolved;

    @Column(name = "description")
    private String description;

    @Column(name = "receipt")
    private String receipt;

    @ManyToOne
    @JoinColumn(name = "author_id", referencedColumnName = "user_id")
    private User author;

    @ManyToOne
    @JoinColumn(name = "resolver_id", referencedColumnName = "user_id")
    private User resolver;

    @ManyToOne
    @JoinColumn(name = "status_id", referencedColumnName = "status_id")
    private ReimbStatus status;

    @ManyToOne
    @JoinColumn(name = "type_id", referencedColumnName = "type_id")
    private ReimbType type;

    public Reimb() {
        super();
    }

    public Reimb(double amount, LocalDate submitted, LocalDate resolved, String description, String receipt,
            User authorId, User resolverId, ReimbStatus statusId, ReimbType typeId) {
        super();
        this.amount = amount;
        this.submitted = submitted;
        this.resolved = resolved;
        this.description = description;
        this.receipt = receipt;
        this.author = authorId;
        this.resolver = resolverId;
        this.status = statusId;
        this.type = typeId;
    }

    public Reimb(int id, double amount, LocalDate submitted, LocalDate resolved, String description,
            String receipt,
            User authorId, User resolver, ReimbStatus status, ReimbType type) {
        super();
        this.id = id;
        this.amount = amount;
        this.submitted = submitted;
        this.resolved = resolved;
        this.description = description;
        this.receipt = receipt;
        this.author = authorId;
        this.resolver = resolver;
        this.status = status;
        this.type = type;
    }

    public int getReimbId() {
        return id;
    }

    public void setReimbId(int id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getSubmitted() {
        return submitted;
    }

    public void setSubmitted(LocalDate submitted) {
        this.submitted = submitted;
    }

    public LocalDate getResolved() {
        return resolved;
    }

    public void setResolved(LocalDate resolved) {
        this.resolved = resolved;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getReceipt() {
        return receipt;
    }

    public void setReceipt(String receipt) {
        this.receipt = receipt;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public User getResolverId() {
        return resolver;
    }

    public void setResolverId(User resolver) {
        this.resolver = resolver;
    }

    public ReimbStatus getStatus() {
        return status;
    }

    public void setStatusId(ReimbStatus status) {
        this.status = status;
    }

    public ReimbType getType() {
        return type;
    }

    public void setType(ReimbType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Reimb [amount=" + amount + ", author=" + author + ", description=" + description + ", receipt="
                + receipt + ", reimbId=" + id + ", resolved=" + resolved + ", resolver=" + resolver + ", status="
                + status + ", submitted=" + submitted + ", type=" + type + "]";
    }

}