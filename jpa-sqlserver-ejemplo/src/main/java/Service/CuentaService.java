package Service;

import Entidades.Cuenta;
import Repositorio.CuentaRepository;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

public class CuentaService {

    @Inject
    private CuentaRepository cuentaRepository;

    @Transactional
    public void registrarCuenta(Cuenta cuenta) {
        cuentaRepository.save(cuenta);
    }

    public Cuenta buscarPorNumeroCuenta(String numeroCuenta) {
        return cuentaRepository.findByNumeroCuenta(numeroCuenta);
    }

    public Cuenta buscarPorId(Long id) {
        return cuentaRepository.findById(id);
    }
}
