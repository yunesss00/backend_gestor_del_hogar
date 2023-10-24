package com.uco.tfg.app.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "shoppingLists")
public class ShoppingList {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "shoppingLists_seq")
    @SequenceGenerator(name = "shoppingLists_seq", sequenceName = "shoppingLists_seq", allocationSize = 1)
    
    @Column(name = "id")
    private Long id;

    @Column(name = "totalPrice")
    private Float totalPrice;

    @Column(name = "userId")
    private Long userId;
    
    @Column(name = "homeShoppingList")
    private int homeShoppingList;    
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "homeId")
    private Home home; 
    
    @ManyToMany(mappedBy = "lstShoppingList")
    private List<User> lstUsers;
    
    @ManyToMany(mappedBy = "lstShoppingList")
    private List<Product> lsProducts;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Long getUser() {
        return userId;
    }

    public void setUser(Long userId) {
        this.userId = userId;
    }
}
