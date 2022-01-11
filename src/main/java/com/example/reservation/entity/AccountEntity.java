package com.example.reservation.entity;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "account_table")
public class AccountEntity implements Serializable {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "id")
    Integer id;
    @Column(name = "user_id")
    String user_Id;
    @Column(name = "user_pwd")
    String user_Pwd;
    @Column(name = "user_name")
    String user_Name;
    @Column(name = "user_email")
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {

        return this.id + "," + this.user_Id + "," +

                this.user_Pwd + "," +

                this.user_Name + "," +
                this.user_Email;
    }
}
