package Main;

import Entidades.Clientes;
import Enum.TipoDocumento;
import Enum.EstadoCliente;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class BancoMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("bancoPU");
        EntityManager em = emf.createEntityManager();

        System.out.println("Sistema bancario iniciado correctamente.");

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            Clientes c1 = new Clientes();
            c1.setNombres("Jazmin");
            c1.setApellidos("Lorenzo");
            c1.setNumeroDocumento("76771661");
            c1.setTipoDocumento(TipoDocumento.DNI);
            c1.setEmail("lorenzojazmin@gmail.com");
            c1.setTelefono("914585202");
            c1.setFechaNacimiento(LocalDate.of(2004, 10, 22));
            c1.setFechaRegistro(LocalDateTime.now());
            c1.setEstado(EstadoCliente.ACTIVO);

            Clientes c2 = new Clientes();
            c2.setNombres("Leandro");
            c2.setApellidos("Salazar");
            c2.setNumeroDocumento("70340254");
            c2.setTipoDocumento(TipoDocumento.DNI);
            c2.setEmail("leando123@hotmail.com");
            c2.setTelefono("9884547565");
            c2.setFechaNacimiento(LocalDate.of(1999, 5, 26));
            c2.setFechaRegistro(LocalDateTime.now());
            c2.setEstado(EstadoCliente.ACTIVO);

            Clientes c3 = new Clientes();
            c3.setNombres("Milagros");
            c3.setApellidos("Ramírez");
            c3.setNumeroDocumento("11223344");
            c3.setTipoDocumento(TipoDocumento.DNI);
            c3.setEmail("milagros.ramirez@yahoo.com");
            c3.setTelefono("9776664");
            c3.setFechaNacimiento(LocalDate.of(1995, 12, 2));
            c3.setFechaRegistro(LocalDateTime.now());
            c3.setEstado(EstadoCliente.ACTIVO);

            em.persist(c1);
            em.persist(c2);
            em.persist(c3);

            tx.commit();
            System.out.println("Clientes insertados correctamente.");
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
    }
}
