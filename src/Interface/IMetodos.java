package Interface;

import Dominio.Cliente;
import Dominio.Transaccion;


public interface IMetodos {
public void altaCliente(Cliente cliente);
public void registroPoeracion(Transaccion tran);
public Cliente buscarCuenta(Cliente cliente);
}
