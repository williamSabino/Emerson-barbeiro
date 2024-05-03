package br.com.will.EmersonBarber.models.servicos;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Servicos {
    private boolean degrade;
    private boolean tesoura;
    private boolean barba;
    private boolean test1;
    private boolean test2;
    private boolean outros;
}
