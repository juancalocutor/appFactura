import java.util.Scanner;

import com.juancalocutor.appfactura.modelo.*;

public class App {
    public static void main(String[] args) throws Exception {

        Cliente cliente = new Cliente();
        cliente.setNombreCliente("Juan Carlos");
        cliente.setCedulaCliente("86009422");

        System.out.println();

        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese una descripción de la factura: ");
        Factura factura = new Factura(sc.nextLine(), cliente);

        Producto producto;

        System.out.println();

        for (int i = 0; i < 5; i++) {
            producto = new Producto();
            System.out.print("Ingrese producto n° " + producto.getCodigo() + ": ");
            producto.setNombreProducto(sc.nextLine());

            System.out.print("Ingrese precio $ ");
            producto.setPrecio(sc.nextDouble());

            System.out.print("Ingrese la cantidad: ");
            factura.addItemFactura(new ItemFactura(sc.nextInt(), producto));

            System.out.println();
            sc.nextLine();

        }

        sc.close();

        System.out.println(factura);


        // ************************************
    }
}
