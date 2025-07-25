package Service;

import Entidades.Movimiento;
import Repositorio.MovimientoRepository;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

public class MovimientoService {

    @Inject
    private MovimientoRepository movimientoRepository;

    @Transactional
    public void registrarMovimiento(Movimiento movimiento) {
        movimientoRepository.save(movimiento);
    }

    public Movimiento buscarPorNumeroTransaccion(String numeroTransaccion) {
        return movimientoRepository.findByNumeroTransaccion(numeroTransaccion);
    }

    public Movimiento buscarPorId(Long id) {
        return movimientoRepository.findById(id);
    }
}
