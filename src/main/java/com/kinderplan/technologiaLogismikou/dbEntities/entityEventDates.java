package com.kinderplan.technologiaLogismikou.dbEntities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * Created by dimitris on 5/16/2017.
 */
@Entity
@Table(name = "Event_Dates", schema = "public", catalog = "kinderplan_db")
public class entityEventDates {
    private Integer id;
    private Integer event;
    private Timestamp startDate;
    private Timestamp endDate;
    private Integer availableTickets;
    private Integer ticketsSold;
    private String note;
    private entityEvents eventsByEvent;
    private Collection<entityTransactions> transactionssById;

    @Id
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "event", nullable = false)
    public Integer getEvent() {
        return event;
    }

    public void setEvent(Integer event) {
        this.event = event;
    }

    @Basic
    @Column(name = "start_date", nullable = false)
    public Timestamp getStartDate() {
        return startDate;
    }

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    @Basic
    @Column(name = "end_date", nullable = false)
    public Timestamp getEndDate() {
        return endDate;
    }

    public void setEndDate(Timestamp endDate) {
        this.endDate = endDate;
    }

    @Basic
    @Column(name = "available_tickets", nullable = false)
    public Integer getAvailableTickets() {
        return availableTickets;
    }

    public void setAvailableTickets(Integer availableTickets) {
        this.availableTickets = availableTickets;
    }

    @Basic
    @Column(name = "tickets_sold", nullable = false)
    public Integer getTicketsSold() {
        return ticketsSold;
    }

    public void setTicketsSold(Integer ticketsSold) {
        this.ticketsSold = ticketsSold;
    }

    @Basic
    @Column(name = "note", nullable = true, length = -1)
    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        entityEventDates that = (entityEventDates) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (event != null ? !event.equals(that.event) : that.event != null) return false;
        if (startDate != null ? !startDate.equals(that.startDate) : that.startDate != null) return false;
        if (endDate != null ? !endDate.equals(that.endDate) : that.endDate != null) return false;
        if (availableTickets != null ? !availableTickets.equals(that.availableTickets) : that.availableTickets != null)
            return false;
        if (ticketsSold != null ? !ticketsSold.equals(that.ticketsSold) : that.ticketsSold != null) return false;
        if (note != null ? !note.equals(that.note) : that.note != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (event != null ? event.hashCode() : 0);
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        result = 31 * result + (availableTickets != null ? availableTickets.hashCode() : 0);
        result = 31 * result + (ticketsSold != null ? ticketsSold.hashCode() : 0);
        result = 31 * result + (note != null ? note.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "event", referencedColumnName = "id", nullable = false)
    public entityEvents getEventsByEvent() {
        return eventsByEvent;
    }

    public void setEventsByEvent(entityEvents eventsByEvent) {
        this.eventsByEvent = eventsByEvent;
    }

    @OneToMany(mappedBy = "eventDatesByEvent")
    public Collection<entityTransactions> getTransactionssById() {
        return transactionssById;
    }

    public void setTransactionssById(Collection<entityTransactions> transactionssById) {
        this.transactionssById = transactionssById;
    }
}
