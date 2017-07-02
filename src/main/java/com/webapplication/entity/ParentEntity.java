package com.webapplication.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by dimitris on 5/21/2017.
 */
@Entity
@Table(
        name = "parents"
)
public class ParentEntity {
    @Id
    @SequenceGenerator(name = "parents_id_seq",
            sequenceName = "parents_id_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY,
            generator = "parents_id_seq")
    @Column(name = "id", nullable = false)
    private Integer id;
    private Integer points;
    @OneToOne
    private UserEntity user;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private Set<CommentEventEntity> event_comments = new HashSet<CommentEventEntity>(0);
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private Set<CommentProviderEntity> provider_comments = new HashSet<CommentProviderEntity>(0);
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "parent_id")
    private Set<TransactionEntity> transactions = new HashSet<TransactionEntity>(0);
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "parent_id")
    private Set<BookingEntity> bookings = new HashSet<BookingEntity>(0);

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity userByUserId) {
        this.user = userByUserId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public Set<CommentEventEntity> getEvent_comments() {
        return event_comments;
    }

    public void setEvent_comments(Set<CommentEventEntity> event_comments) {
        this.event_comments = event_comments;
    }

    public Set<CommentProviderEntity> getProvider_comments() {
        return provider_comments;
    }

    public void setProvider_comments(Set<CommentProviderEntity> provider_comments) {
        this.provider_comments = provider_comments;
    }

    public Set<TransactionEntity> getTransactions() {
        return transactions;
    }

    public void setTransactions(Set<TransactionEntity> transactions) {
        this.transactions = transactions;
    }

    public Set<BookingEntity> getBookings() {
        return bookings;
    }

    public void setBookings(Set<BookingEntity> bookings) {
        this.bookings = bookings;
    }
}
