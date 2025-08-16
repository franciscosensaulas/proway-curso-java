/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package br.com.proway.granacerta.enums;

/**
 *
 * @author francisco.sens
 */
public enum ContaTipoEnum {
    ENTRADA(0), SAIDA(1);

    private final int code;

    private ContaTipoEnum(int code) {
        this.code = code;
    }

    public static ContaTipoEnum fromCode(int code) {
        for (ContaTipoEnum tipo : values()) {
            if (tipo.code == code) {
                return tipo;
            }
        }
        throw new IllegalArgumentException("Código do tipo da Conta é inválido: " + code);
    }

    public int getCode() {
        return code;
    }
}
