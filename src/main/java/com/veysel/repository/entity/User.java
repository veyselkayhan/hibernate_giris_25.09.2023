package com.veysel.repository.entity;

import javax.persistence.*;


/*
Hibernate birçok konfigurasyonunu anatasyonlar ile yapar.Bu anatasyonların neler olduğunu  ve
ne işe yaradığı çok önemlidir.

@Entity -> üzerinde geldiğin sınıfın bir varlık sınıfı olduğunu tanımlar.Mutlaka
ORM için kullanılmak zorunludur.
@Table -> üzerinde eklendiği sınıfın DB de ki özelliklerini düzenlemek için kullanılır.
kullanılması gereklidir.Her tablo için bir isimlendirme yapılması önerilir.Eğer yapılmazsa
sınıfın adı tablonun adı olarak kullanılır.

 */



@Entity
@Table(name = "tbluser")
public class User {

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)//id için otomatik artım yapan sayacı ifade ediyor.

    Long id;
    String name;
    String phone;

    public User(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
