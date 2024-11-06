package crud.springbootexpert.domain.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "ItemPedido")
public class ItemPedido {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idItemPedido;
}
