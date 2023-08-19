package com.silverio.sistema.entities.pk;

import java.io.Serializable;
import java.util.Objects;

import com.silverio.sistema.entities.Cliente;
import com.silverio.sistema.entities.Equipamento;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class EquipamentoClientePK implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name ="cliente_id")
	private Cliente cliente;
	
	@ManyToOne
	@JoinColumn(name ="equipamento_id")
		private Equipamento equipamento;
	
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Equipamento getEquipamento() {
		return equipamento;
	}
	public void setEquipamento(Equipamento equipamento) {
		this.equipamento = equipamento;
	}
	@Override
	public int hashCode() {
		return Objects.hash(cliente, equipamento);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EquipamentoClientePK other = (EquipamentoClientePK) obj;
		return Objects.equals(cliente, other.cliente) && Objects.equals(equipamento, other.equipamento);
	}
	
	
}
