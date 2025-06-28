/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package br.com.proway.granacerta;

import java.util.ArrayList;

/**
 *
 * @author francisco.sens
 */
public class Granacerta {

    public static void main(String[] args) {
        ArrayList<String> numeros = new ArrayList<>();
        numeros.add("Pedro");
        numeros.add("Laura");
        numeros.add("Ana");
        numeros.add("Claudia");
        numeros.add("Roberval");
        numeros.remove(1);
        System.out.println(numeros);
    }
}
