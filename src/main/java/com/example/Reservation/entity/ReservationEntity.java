package com.example.Reservation.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name="reservation_table")
public class ReservationEntity implements Serializable {
    @Id
    @Column(name="id")
    int id;
    @Column(name="user_id")
    String user_Id;
    @Column(name="start_date")
    Timestamp start_Date;
    @Column(name="end_date")
    Timestamp end_Date;
    @Column(name="content")
    String content;

    public String getUser_Id() {
        return user_Id;
    }

    public void setUser_Id(String user_Id) {
        this.user_Id = user_Id;
    }

    public Timestamp getStart_Date() {
        return start_Date;
    }

    public void setStart_Date(Timestamp start_Date) {
        this.start_Date = start_Date;
    }

    public Timestamp getEnd_Date() {
        return end_Date;
    }

    public void setEnd_Date(Timestamp end_Date) {
        this.end_Date = end_Date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
