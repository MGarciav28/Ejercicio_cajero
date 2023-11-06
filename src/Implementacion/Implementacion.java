package Implementacion;

import java.util.HashMap;

import Dominio.Cliente;
import Dominio.Transaccion;
import Interface.IMetodos;

public class Implementacion implements IMetodos{
	HashMap<Integer, Cliente> hashClientes = new HashMap<Integer, Cliente>();
	HashMap<Integer, Transaccion> hashTransaccion = new HashMap<Integer, Transaccion>();
	



@Override
public void registroPoeracion(Transaccion tran) {
hashTransaccion.put(tran.getNumCuenta(), tran);
}


@Override
public void altaCliente(Cliente cliente) {
	hashClientes.put(cliente.getNumCuenta(), cliente);	
}


@Override
public Cliente buscarCuenta(Cliente cliente) {

	return hashClientes.get(cliente.getNumCuenta());
}

public int consultaSaldo(Cliente clien) {
	return hashClientes.get(clien.getNumCuenta()).getSaldo();
}

public void deposito(Cliente cliente, int cantidad) {
	int saldo = hashClientes.get(cliente.getNumCuenta()).getSaldo() + cantidad;
	hashClientes.get(cliente.getNumCuenta()).setSaldo(saldo);
}


public void retiro(Cliente cliente, int cantidad) {
	int saldo = hashClientes.get(cliente.getNumCuenta()).getSaldo()-cantidad;	
	hashClientes.get(cliente.getNumCuenta()).setSaldo(saldo);;
}


}
