package com.example.usercrudspringbootapp.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="user_preferences")
public class UserPreferences {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id = 0;
    @Column(name = "receive_email")
    private boolean receiveEmail = false;
    @Column(name = "receive_sms")
    private boolean receiveSms = true;

    public int getId() {
        return id;
    }

    public boolean getReceiveEmail() {
        return receiveEmail;
    }

    public void setReceiveEmail(boolean receiveEmail) {
        this.receiveEmail = receiveEmail;
    }

    public boolean getReceiveSms() {
        return receiveSms;
    }

    public void setReceiveSms(boolean receiveSms) {
        this.receiveSms = receiveSms;
    }
}
