package hellojpa;

import jakarta.persistence.*;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            //비영속
           Member member= new Member();
           member.setId(100L);
           member.setName("HelloJPA");

           //영속
           em.persist(member);
           em.detach(member);

           tx.commit();
        }catch (Exception e) {
            tx.rollback();
        }finally{
            em.close();
        }
        emf.close();
    }
}
