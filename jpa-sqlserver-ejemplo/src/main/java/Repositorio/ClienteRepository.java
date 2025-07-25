package Repositorio;

import Entidades.Clientes;

import Enum.TipoDocumento;



import jakarta.persistence.EntityManager;

import jakarta.persistence.PersistenceContext;

import jakarta.persistence.TypedQuery;

import java.util.List;



public class ClienteRepository {



   @PersistenceContext

   private EntityManager em;



   public Clientes findById(Long id) {

       return em.find(Clientes.class, id);

   }



   public Clientes findByNumeroDocumento(String numeroDocumento) {

       TypedQuery<Clientes> query = em.createQuery(

           "SELECT c FROM Clientes c WHERE c.numeroDocumento = :numero", Clientes.class);

       query.setParameter("numero", numeroDocumento);

       return query.getSingleResult();

   }



   public List<Clientes> findByTipoDocumento(TipoDocumento tipo) {

       return em.createQuery(

           "SELECT c FROM Cliente c WHERE c.tipoDocumento = :tipo", Clientes.class)

           .setParameter("tipo", tipo)

           .getResultList();

   }



   public void save(Clientes cliente) {

       em.persist(cliente);

   }



   public void update(Clientes cliente) {

       em.merge(cliente);

   }

}