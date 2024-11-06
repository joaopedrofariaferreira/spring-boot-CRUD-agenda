package crud.springbootexpert.repository;

import crud.springbootexpert.domain.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface Clientes extends JpaRepository<Cliente, Integer> {

    @Query(value = "select * from Cliente", nativeQuery = true)
    List<Cliente> encontrarPorNome(@Param("nome") String nome);

    @Query("delete from Cliente c where c.nome =:nome ")
    @Modifying
    void deletarPorNome(String nome);

    boolean existsByNome(String nome);

    @Query("select c from Cliente c left join fetch c.pedidos where c.idCliente = :id")
    Cliente EncontrarPorId(@Param("id") Integer id);


}


