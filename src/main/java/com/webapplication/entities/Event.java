package com.webapplication.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * Created by KechagiasKonstantinos on 28/05/2017.
 */
@Entity
public class Event {
    @Id
    Long evt_id;
    @ManyToOne
    Provider provider;

    public Event(){}

    public Event(Long evt_id, Provider provider) {
        this.evt_id = evt_id;
        this.provider = provider;
    }

    public Long getEvt_id() {
        return evt_id;
    }

    public void setEvt_id(Long evt_id) {
        this.evt_id = evt_id;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }
}
