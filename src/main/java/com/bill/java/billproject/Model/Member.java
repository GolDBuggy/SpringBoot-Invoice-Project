package com.bill.java.billproject.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "members")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Member {

    @Id
    @GenericGenerator(name = "UUID",strategy = "org.hibernate.id.UUIDGenerator")
    @GeneratedValue(generator = "UUID")
    @Column(name = "member_id")
    private String id;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "company_position")
    private String companyPosition;

    @Column(name = "passw")
    private String password;

    @Column(name = "phone")
    private String phone;

    @Column(name = "roles")
    private String roles;

    @Column(name = "register_date")
    private Date registerDate;

    @OneToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @OneToMany(mappedBy = "member")
    private List<Wallet> wallets;

    @OneToMany(mappedBy = "member")
    @JsonIgnore
    private List<Invoice> invoices;


    @OneToMany(mappedBy = "member")
    @JsonIgnore
    private List<Auction> auctions;
}
