package com.company;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import static java.util.stream.Collectors.toList;

public class Main {

    public static void main(String[] args) throws IOException {

        List<Persona> listaPersona = new ArrayList<>() ;

        BufferedReader br = null;
        String nombreFichero = "C:\\Users\\alvaro.fernandez\\Desktop\\fichero.txt";


            br = new BufferedReader(new FileReader(nombreFichero));
            //Leer la primera línea, guardando en un String
            String texto = br.readLine();

            //Repetir mientras no se llegue al final del fichero
            while(texto != null)
            {
                String texto2 = texto;
                String[] parts = texto2.split(":");
                String nombre = parts[0] ;
                String ciudad = parts[1];
               /*if(ciudad.isEmpty()){
                    ciudad = "Desconocido";
                }*/
                int edad = 0;
                if(parts.length>2){
                    edad =  Integer.parseInt(parts[2]);
                }
                Persona p1 = new Persona();

                p1.setNombre(nombre);
                p1.setPoblacion(ciudad);
                p1.setEdad(edad);
                //Hacer lo que sea con la línea leída
                listaPersona.add(p1);

                //System.out.println(p1.toString());
                //Leer la siguiente línea
                texto = br.readLine();
            }

        /*for (Persona p: listaPersona
             ) {
            System.out.println(p.toString());
        }*/

         listaPersona.stream().filter(x-> x.getEdad().isPresent()).filter(x-> x.getEdad().get() != 0).filter(x-> x.getEdad().get() < 25).forEach(x-> System.out.println("Linea "+ "Nombre: " +x.getNombre().orElse("Desconocido")+", Poblacion: "+x.getPoblacion().orElse("Desconocido")+ ", Edad: "+x.getEdad()));


    }




}
