package Main;

import java.util.Scanner;

import Dominio.Cliente;
import Implementacion.Implementacion;

public class principal {

	public static void main(String[] args) {
		Cliente clienTemp =null;
		int cantidadFinal, depositado;
		boolean salir=false;
		
		int menu = 0;
		
		String nombre=null;
		int numCuenta = 0;
		
		Implementacion imp = new Implementacion();
		Scanner lectura = null;

		do {
			System.out.println("MENU BANCOMER BIENVENIDO");
			System.out.println("1 ---- Alta Cliente");
			System.out.println("2 ---- Consultar saldo");
			System.out.println("3 ---- Deposito en efectivo");
			System.out.println("4 ---- Retiro en efectivo");
			System.out.println("5 ---- Salir");

			lectura = new Scanner(System.in);
			try {
				menu = lectura.nextInt();
			} catch (Exception e) {
				System.out.println("Opcion no valida");
			}

			switch (menu) {
			case 1:
				System.out.println("Ingresa los datos del nuevo usuario");
				System.out.println("Nombre");
				try {
					lectura = new Scanner(System.in);
				nombre = lectura.nextLine();
					
				} catch (Exception e) {
					System.out.println("Error al recibir nombre");
				}
				
				System.out.println("Numero de cuenta");
				try {
					lectura = new Scanner(System.in);
					numCuenta = lectura.nextInt();					
				} catch (Exception e) {
					System.out.println("Error al recibir numero de cuenta");
				}
				
				clienTemp = new Cliente(numCuenta);
				if(imp.buscarCuenta(clienTemp) != null) {
					System.out.println("el numero de cuenta ya existe");
					break;
				}else {
					clienTemp = new Cliente(nombre, numCuenta, 0);
					imp.altaCliente(clienTemp);					
					System.out.println(imp.buscarCuenta(clienTemp));					
				}
				 
							

				break;
			case 2:
				System.out.println("Ingrese el numero de cuenta a consultar");
				lectura = new Scanner(System.in);
				try {
					numCuenta = lectura.nextInt();	
				} catch (Exception e) {
					System.out.println("Ingrese un número de cuenta válido");
				}
				
				clienTemp = new Cliente(numCuenta);				
				if(imp.buscarCuenta(clienTemp) == null) {
					System.out.println("el numero de cuenta no existe");
					break;
				}else {
					clienTemp = imp.buscarCuenta(clienTemp);
					System.out.println("El saldo de la cuenta: "+clienTemp.getNumCuenta()+" es: "
							+clienTemp.getSaldo());
				}

				break;
			case 3:
				System.out.println("Ingrese el numero de cuenta a depositar");
				lectura = new Scanner(System.in);
				try {
					numCuenta = lectura.nextInt();	
				} catch (Exception e) {
					System.out.println("Ingrese un número de cuenta válido");
				}
				
				clienTemp = new Cliente(numCuenta);				
				if(imp.buscarCuenta(clienTemp) == null) {
					System.out.println("el numero de cuenta no existe");
					break;
				}else {						
						do {System.out.println("Ingrese la cantidad a depositar");
						lectura = new Scanner(System.in);
						cantidadFinal = lectura.nextInt();
							try {						
								salir = false;
								if(cantidadFinal%10==0) {
									if (cantidadFinal <10000) {
										imp.deposito(clienTemp, cantidadFinal);
										System.out.println("Se realizo correctamente el deposito de: $" + cantidadFinal);
										clienTemp = imp.buscarCuenta(clienTemp);
										System.out.println("El saldo de la cuenta: "+clienTemp.getNumCuenta()+" es: "
												+clienTemp.getSaldo());
										salir=true;	
									}else {
										System.out.println("La cantidad Maxima a depositar es de $10,000");										
									}
									
								}else {
									System.out.println("Favor de depositar numeros multiplos de $10");
								}	
							} catch (Exception e) {
								System.out.println("Favor de ingresar un monto numerico");
							}								
						} while (salir==false);			
				}

				break;
			case 4:
				System.out.println("Ingrese el numero de cuenta a retirar");
				lectura = new Scanner(System.in);
				try {
					numCuenta = lectura.nextInt();	
				} catch (Exception e) {
					System.out.println("Ingrese un número de cuenta válido");
				}
				
				clienTemp = new Cliente(numCuenta);				
				if(imp.buscarCuenta(clienTemp) == null) {
					System.out.println("el numero de cuenta no existe");
					break;
				}else {
					do {
						System.out.println("Ingrese la cantidad a retirar");
						lectura = new Scanner(System.in);
						cantidadFinal = lectura.nextInt();
						try {							
							salir = false;
							if(cantidadFinal%10==0&&cantidadFinal>40) {
								if (cantidadFinal <10000) {
									if(imp.consultaSaldo(clienTemp)>=cantidadFinal) {
										imp.retiro(clienTemp, cantidadFinal);									
										System.out.println("Se retiraron correctamente : $"+cantidadFinal);
										clienTemp = imp.buscarCuenta(clienTemp);
										System.out.println("Su saldo actual es de : $"+imp.consultaSaldo(clienTemp));									
										salir=true;	
									}else {
										System.out.println("Fondos Insuficientes");
										salir = false;
									}	
								}else {
									System.out.println("La cantidad maxima permitioda es $10,000");
								}
								
							}else {
								System.out.println("Ingrese la cantidad en multipos de $10");
							}
						} catch (Exception e) {
					System.out.println("Ingrese una cantidad valida");
						}
					} while (salir == false);
				}		

				break;
			case 5:

				break;

			default:
				break;
			}

		} while (menu < 5);

	}

}
