package crud.springbootexpert.domain.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "pedidos")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idPedido")
    private Integer idPedido;


    private String nomeCliente;
}
