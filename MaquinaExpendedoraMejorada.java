public class MaquinaExpendedoraMejorada {

    // El precio del billete
    private int precioBillete;
    // La cantidad de dinero que lleva metida el cliente actual
    private int balanceClienteActual;
    // El total de dinero almacenado en la maquina desde su ultimo vaciado
    private int totalDineroAcumulado;
    // El origen del billete
    private String estacionOrigen;
    // El destino del billete
    private String estacionDestino;
    // Numero de billetes vendidos
    private int billetesVendidos;
    // Tipo de maquina
    private boolean maquinaConPremios;

    /**
     * Crea una maquina expendedora de billetes de tren con el 
     * precio del billete y el origen y destino dados. Se asume que el precio
     * del billete que se recibe es mayor que 0.
     */
    public MaquinaExpendedoraMejorada(int precioDelBillete, String origen, String destino, boolean maquinaPremios) {
        precioBillete = precioDelBillete;
        balanceClienteActual = 0;
        totalDineroAcumulado = 0;
        estacionOrigen = origen;
        estacionDestino = destino;
        billetesVendidos = 0;
        maquinaConPremios = maquinaPremios;
    }

    /**
     * Devuelve el precio del billete
     */
    public int getPrecioBillete() {
        return precioBillete;
    }

    /**
     * Devuelve la cantidad de dinero que el cliente actual lleva introducida
     */
    public int getBalanceClienteActual() {
        return balanceClienteActual;
    }

    /**
     * Simula la introduccion de dinero por parte del cliente actual
     */
    public void introducirDinero(int cantidadIntroducida) {
        if (cantidadIntroducida > 0) {
            balanceClienteActual = balanceClienteActual + cantidadIntroducida;
        }
        else {
            System.out.println(cantidadIntroducida + " no es una cantidad de dinero valida.");
        }        
    }

    /**
     * Imprime un billete para el cliente actual
     */
    public void imprimirBillete() {
        int cantidadDeDineroQueFalta = (precioBillete - balanceClienteActual);
        int descuentoCompras = ((precioBillete * 10) / 100);
        if (cantidadDeDineroQueFalta <= 0) {        
            // Simula la impresion de un billete
            if (maquinaConPremios) {
                System.out.println("##################");
                System.out.println("# Billete de tren:");
                System.out.println("# De " + estacionOrigen + " a " + estacionDestino);
                System.out.println("# " + precioBillete + " euros.");
                System.out.println("# Tiene un descuento de " + descuentoCompras + " euros para compras en el comercio que tu elijas.");
                System.out.println("##################");
                System.out.println();         

                // Actualiza el total de dinero acumulado en la maquina
                totalDineroAcumulado = totalDineroAcumulado + precioBillete;
                // Reduce el balance del cliente actual dejandole seguir utilizando la maquina
                balanceClienteActual = balanceClienteActual - precioBillete;
                billetesVendidos = billetesVendidos + 1;
            }
            else {
                System.out.println("##################");
                System.out.println("# Billete de tren:");
                System.out.println("# De " + estacionOrigen + " a " + estacionDestino);
                System.out.println("# " + precioBillete + " euros.");
                System.out.println("##################");
                System.out.println();         

                // Actualiza el total de dinero acumulado en la maquina
                totalDineroAcumulado = totalDineroAcumulado + precioBillete;
                // Reduce el balance del cliente actual dejandole seguir utilizando la maquina
                balanceClienteActual = balanceClienteActual - precioBillete;
                billetesVendidos = billetesVendidos + 1;
            }
        }
        else {
            System.out.println("Necesitas introducir " + (cantidadDeDineroQueFalta) + " euros mas!");
        }  
    }

    /**
     * Cancela la operacion de compra del cliente actual y le
     * devuelve al cliente el dinero que ha introducido hasta el momento
     */
    public int cancelarOperacionYDevolverDinero() {
        int cantidadDeDineroADevolver;
        cantidadDeDineroADevolver = balanceClienteActual;
        balanceClienteActual = 0;
        return cantidadDeDineroADevolver;
    }   

    /**
     * Vacia todo el dinero de la m?quina incluyendo los dos depositos y
     * devuelve la cantidad de dinero extraida.
     */
    public int vaciarDineroDeLaMaquina() {
        int cantidadExtraida = balanceClienteActual + totalDineroAcumulado;
        if (balanceClienteActual == 0) {
            balanceClienteActual = 0;
            totalDineroAcumulado = 0;
        }
        else  {
            cantidadExtraida = -1;
            System.out.println("Hay una operaci?n en curso y no es posible vaciar el dinero de la m?quina, disculpe las molestias");
        }
        return cantidadExtraida;
    }

    /**
     * devuelve el numero de billetes vendidos.
     */
    public int getNumeroBilletesVendidos() {
        return billetesVendidos;
    }

    /**
     * imprime el numero de billetes vendido.
     */
    public void imprimeNumeroBilletesVendidos() {
        System.out.println("numero de billetes vendidos:" + billetesVendidos);
    }
}
