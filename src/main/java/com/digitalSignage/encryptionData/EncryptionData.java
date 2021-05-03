package com.digitalSignage.encryptionData;


import com.digitalSignage.converter.StringEncryptDecryptConverter;


import javax.persistence.*;

@Entity
@Table(name = "encryption_data")
public class EncryptionData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "email_id")
    @Convert(converter = StringEncryptDecryptConverter.class)
    private String user_email;
    @Column(name = "password")
    @Convert(converter = StringEncryptDecryptConverter.class)
    private String password;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}



