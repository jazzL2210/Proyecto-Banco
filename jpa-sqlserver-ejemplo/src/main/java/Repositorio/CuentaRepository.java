package Repositorio;

import Entidades.Cuenta;
import Enum.TipoCuenta;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import java.util.List;

public class CuentaRepository {

    @PersistenceContext
    private EntityManager em;

    public Cuenta findById(Long id) {
        return em.find(Cuenta.class, id);
    }

    public Cuenta findByNumeroCuenta(String numeroCuenta) {
        TypedQuery<Cuenta> query = em.createQuery(
            "SELECT c FROM Cuenta c WHERE c.numeroCuenta = :numero", Cuenta.class);
        query.setParameter("numero", numeroCuenta);
        return query.getSingleResult();
    }

    public List<Cuenta> findByTipoCuenta(TipoCuenta tipo) {
        return em.createQuery(
            "SELECT c FROM Cuenta c WHERE c.tipoCuenta = :tipo", Cuenta.class)
            .setParameter("tipo", tipo)
            .getResultList();
    }

    public List<Cuenta> findByClienteId(Long clienteId) {
        return em.createQuery(
            "SELECT c FROM Cuenta c WHERE c.cliente.id = :clienteId", Cuenta.class)
            .setParameter("clienteId", clienteId)
            .getResultList();
    }

    public void save(Cuenta cuenta) {
        em.persist(cuenta);
    }

    public void update(Cuenta cuenta) {
        em.merge(cuenta);
    }
}
