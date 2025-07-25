package Service;

import Entidades.Clientes;
import Repositorio.ClienteRepository;

import jakarta.inject.Inject;

import jakarta.transaction.Transactional;



public class ClientesService {



   @Inject

   private ClienteRepository clienteRepository;



   @Transactional

   public void registrarCliente(Clientes cliente) {

       clienteRepository.save(cliente);

   }



   public Clientes buscarPorDocumento(String numeroDocumento) {

       return clienteRepository.findByNumeroDocumento(numeroDocumento);

   }

}

