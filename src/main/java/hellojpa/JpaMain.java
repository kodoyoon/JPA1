package hellojpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;
import java.util.Set;


public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

            Member member = new Member();
            member.setUsername("member1");
            member.setHomeaddress(new Address("homecity" ,"street" ,"10000"));
            member.getFavoriteFoods().add("치킨");
            member.getFavoriteFoods().add("피자");
            member.getFavoriteFoods().add("족발");

            member.getAddressHistory().add(new AddressEntity("old1", "street", "10000"));
            member.getAddressHistory().add(new AddressEntity("old2", "street", "10000"));

            em.persist(member);

            em.flush();
            em.clear();

            System.out.println("========start========");

           Member findMember =  em.find(Member.class,member.getId());
//home -> new
// findMember.getHomeaddress().setCity("newCity");

            //통으로 새롭게 해야함 ,
//            findMember.getHomeaddress().setCity("newCity");
//            Address a = findMember.getHomeaddress();
//            findMember.setHomeaddress(new Address("newCity", a.getStreet(), a.getZipcode()));

            //치킨 -> 한식
//            findMember.getFavoriteFoods().remove("치킨");
//            findMember.getFavoriteFoods().add("한식");

            //주소변경(old -> new) , 컬렉션들은 대부분 equals 사용
//            findMember.getAddressHistory().remove(new AddressEntity("old1", "street", "10000"));
//            findMember.getAddressHistory().add(new AddressEntity("newCity1", "street", "10000"));





            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
        emf.close();
    }

}
