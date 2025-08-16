/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package br.com.proway.granacerta.enums;

import static br.com.proway.granacerta.enums.ContaTipoEnum.values;

/**
 *
 * @author francisco.sens
 */
public enum ContaStatusEnum {
    PENDENTE(0),
    REALIZADO(1),
    CANCELADO(2);

    private final int code;

    private ContaStatusEnum(int code) {
        this.code = code;
    }

    public static ContaStatusEnum fromCode(int code) {
        for (ContaStatusEnum tipo : values()) {
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
