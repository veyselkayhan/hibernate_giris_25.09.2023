package com.veysel;

import com.veysel.repository.entity.User;
import com.veysel.util.HibernateUtility;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Entity;
import javax.persistence.EntityManager;

public class Main {
    public static void main(String[] args) {

        /*
        1-Hibernate ve Driver baglanlılıkları eklendi
        2-Hibernate konfigurasyonları yapıldı (hibernate.cfg.xml)
        3-config dosyasının yöneterek oturum açmakta olan java util sınıfını yazdık.
        4-Entity sınıfı olusturuldu.
        5-Baglantı kurmak ve entity leri yönetmek için EntityManager kullanılır.
        6-Bir oturum açmamız gerekli ve onun üzerinden işlem yapmalaıyız.Sesion
        7-Transaction yönetimi yapmaamız gerekli.
         */

        EntityManager entityManager;
        Session session;
        Transaction transaction;

        /*
        Kaydetme,Silme,Guncelleme işlemlerini sırayla yapalim.
         */

        User user= new User("Muhammet Hoca ","5378470633");
        session = HibernateUtility.getSessionFactory().openSession();//baglantı açıldı.
        transaction=session.beginTransaction();//sistem izleme başladı.

//        session.save(user);//kayıt işlemi yapıldı.

        /*
        Kimi nasıl güncelleyeceksiniz??
        update tbluser set name='Muhammet Hoca',phone ='12829018' where id=1;
        entity ler id ler üzerinde eşleşir.Bu nedenle güncelleme ve silme işlemlerinde
        mutlaka id belirtmek zorundsaınız
         */


//        user.setId(2L);
//        session.update(user);

        /*
        delete from tbluser Where id=1;
         */

        User silinecek=new User();
        silinecek.setId(3L);
        session.delete(silinecek);//kullanıcı silme işlemi
        transaction.commit();//işlemi onayladık.
        session.close();//baglantıyı kapattık.



    }
}