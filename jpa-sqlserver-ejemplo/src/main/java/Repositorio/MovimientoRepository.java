package Repositorio;

import Entidades.Movimiento;
import Enum.TipoMovimiento;
import Enum.Canal;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import java.util.List;

public class MovimientoRepository {

    @PersistenceContext
    private EntityManager em;

    public Movimiento findById(Long id) {
        return em.find(Movimiento.class, id);
    }

    public Movimiento findByNumeroTransaccion(String numeroTransaccion) {
        TypedQuery<Movimiento> query = em.createQuery(
            "SELECT m FROM Movimiento m WHERE m.numeroTransaccion = :num", Movimiento.class);
        query.setParameter("num", numeroTransaccion);
        return query.getSingleResult();
    }

    public List<Movimiento> findByTipoMovimiento(TipoMovimiento tipo) {
        return em.createQuery(
            "SELECT m FROM Movimiento m WHERE m.tipoMovimiento = :tipo", Movimiento.class)
            .setParameter("tipo", tipo)
            .getResultList();
    }

    public List<Movimiento> findByCuentaId(Long cuentaId) {
        return em.createQuery(
            "SELECT m FROM Movimiento m WHERE m.cuenta.id = :cuentaId", Movimiento.class)
            .setParameter("cuentaId", cuentaId)
            .getResultList();
    }

    public List<Movimiento> findByCanal(Canal canal) {
        return em.createQuery(
            "SELECT m FROM Movimiento m WHERE m.canal = :canal", Movimiento.class)
            .setParameter("canal", canal)
            .getResultList();
    }

    public void save(Movimiento movimiento) {
        em.persist(movimiento);
    }

    public void update(Movimiento movimiento) {
        em.merge(movimiento);
    }
}
