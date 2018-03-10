package br.com.alura.androilayout.model;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pacote implements Serializable {

    private String local;
    private String imagem;
    private int dias;
    private BigDecimal valor;

}
