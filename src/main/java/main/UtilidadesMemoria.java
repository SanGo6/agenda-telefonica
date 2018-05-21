package main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import modelo.gestores.GestorClientes;

public class UtilidadesMemoria {
	public static void guardar(GestorClientes gc){
        try {
            FileOutputStream fileOut = new FileOutputStream("datos.bin");
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(gc);
            fileOut.close();

        }catch (FileNotFoundException e){
            e.printStackTrace();
        } catch(java.io.IOException i){
            i.printStackTrace();
        }
    }

    public static GestorClientes cargar(){
    	GestorClientes datos = new GestorClientes();
        try{
            if(new File("datos.bin").exists()) {
                FileInputStream fileIn = new FileInputStream("datos.bin");
                ObjectInputStream objectIn = new ObjectInputStream(fileIn);
                datos = (GestorClientes) objectIn.readObject();
                fileIn.close();
            }
        }catch (java.io.IOException e){
            e.printStackTrace();
        }catch (ClassNotFoundException i){
            i.printStackTrace();
        }
        return datos;
    }
}
