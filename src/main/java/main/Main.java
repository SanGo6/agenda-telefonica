package main;

import controlador.ImplementacionControlador;
import modelo.ImplementacionModelo;
import modelo.gestores.GestorClientes;
import vista.ImplementacionVista;

public class Main {
	
    public static void main(String[] args) {
        new Main().run();
    }

    public void run(){
        GestorClientes gc = UtilidadesMemoria.cargar();
        
        ImplementacionVista vista = new ImplementacionVista();
        ImplementacionModelo modelo = new ImplementacionModelo();
        ImplementacionControlador controlador = new ImplementacionControlador();
        
        vista.setModelo(modelo);
        vista.setControlador(controlador);
        
        controlador.setVista(vista);
        controlador.setModelo(modelo);
        
        modelo.setVista(vista);
        modelo.setGestorClientes(gc);

        vista.creaGUI();
    }
}
