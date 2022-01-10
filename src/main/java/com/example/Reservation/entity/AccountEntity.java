package com.example.Reservation.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "account_table")
public class AccountEntity implements Serializable {
    @Id
    @Column(name="id")
    int id;
    @Column(name="user_id")
    String user_Id;
    @Column(name="user_pwd")
    String user_Pwd;
    @Column(name="user_name")
    String user_Name;
    @Column(name="user_email")
    String user_Email;

    public String getUser_Id() {
        return user_Id;
    }

    public void setUser_Id(String user_Id) {
        this.user_Id = user_Id;
    }

    public String getUser_Pwd() {
        return user_Pwd;
    }

    public void setUser_Pwd(String user_Pwd) {
        this.user_Pwd = user_Pwd;
    }

    public String getUser_Name() {
        return user_Name;
    }

    public void setUser_Name(String user_Name) {
        this.user_Name = user_Name;
    }

    public String getUser_Email() {
        return user_Email;
    }

    public void setUser_Email(String user_Email) {
        this.user_Email = user_Email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
