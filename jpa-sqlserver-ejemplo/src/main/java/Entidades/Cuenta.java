package Entidades;

import jakarta.persistence.*;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;

import java.time.LocalDateTime;

import java.util.List;

import Enum.EstadoCuenta;
import Enum.TipoCuenta;



@Entity

public class Cuenta {



   @Id

   @GeneratedValue(strategy = GenerationType.IDENTITY)

   private Long id;



   @Pattern(regexp = "\\d{4}-\\d{4}-\\d{4}")

   @Column(unique = true, nullable = false)

   private String numeroCuenta;



   @Enumerated(EnumType.STRING)

   private TipoCuenta tipoCuenta;



   @DecimalMin("0.00")

   private BigDecimal saldoActual;



   private LocalDateTime fechaApertura;



   private LocalDateTime fechaUltimoMovimiento;



   @Enumerated(EnumType.STRING)

   private EstadoCuenta estado;



   @ManyToOne

   @JoinColumn(name = "cliente_id")

   private Clientes cliente;



   @OneToMany(mappedBy = "cuenta", cascade = CascadeType.ALL, orphanRemoval = true)

   private List<Movimiento> movimientos;



@PrePersist

   public void prePersist() {

       this.fechaApertura = LocalDateTime.now();

       this.fechaUltimoMovimiento = this.fechaApertura;

       if (this.estado == null) {

           this.estado = EstadoCuenta.ACTIVA;

       }

   }



public Long getId() {
	return id;
}



public void setId(Long id) {
	this.id = id;
}



public String getNumeroCuenta() {
	return numeroCuenta;
}



public void setNumeroCuenta(String numeroCuenta) {
	this.numeroCuenta = numeroCuenta;
}



public TipoCuenta getTipoCuenta() {
	return tipoCuenta;
}



public void setTipoCuenta(TipoCuenta tipoCuenta) {
	this.tipoCuenta = tipoCuenta;
}



public BigDecimal getSaldoActual() {
	return saldoActual;
}



public void setSaldoActual(BigDecimal saldoActual) {
	this.saldoActual = saldoActual;
}



public LocalDateTime getFechaApertura() {
	return fechaApertura;
}



public void setFechaApertura(LocalDateTime fechaApertura) {
	this.fechaApertura = fechaApertura;
}



public LocalDateTime getFechaUltimoMovimiento() {
	return fechaUltimoMovimiento;
}



public void setFechaUltimoMovimiento(LocalDateTime fechaUltimoMovimiento) {
	this.fechaUltimoMovimiento = fechaUltimoMovimiento;
}



public EstadoCuenta getEstado() {
	return estado;
}



public void setEstado(EstadoCuenta estado) {
	this.estado = estado;
}



public Clientes getClientes() {
	return getClientes();
}



public void setCliente(Clientes clientes) {
	this.cliente = cliente;
}



public List<Movimiento> getMovimientos() {
	return movimientos;
}



public void setMovimientos(List<Movimiento> movimientos) {
	this.movimientos = movimientos;
}




}




