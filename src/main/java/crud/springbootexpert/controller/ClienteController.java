package crud.springbootexpert.controller;

import crud.springbootexpert.domain.entity.Cliente;
import crud.springbootexpert.repository.Clientes;
import org.springframework.boot.autoconfigure.batch.BatchTransactionManager;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
//@RequestMapping("/api/clientes")
public class ClienteController {
    private Clientes clientes;

    public ClienteController(Clientes clientes) {
        this.clientes = clientes;
    }

    @GetMapping(value = "api/clientes/{idCliente}")
    @ResponseBody
    public ResponseEntity getClienteById( @PathVariable Integer idCliente) {
        Optional<Cliente>  cliente = clientes.findById(idCliente);
        if (cliente.isPresent()) {
            return ResponseEntity.ok(cliente.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/api/clientes")
    @ResponseBody
    public ResponseEntity saveCliente(@RequestBody Cliente cliente) {
         Cliente clienteSalvo = clientes.save(cliente);
         return ResponseEntity.ok(clienteSalvo);
    }

    @DeleteMapping("/api/clientes/{idCliente}")
    @ResponseBody
     public ResponseEntity deleteClienteById(@PathVariable Integer idCliente) {
        Optional<Cliente> cliente = clientes.findById(idCliente);
        if(cliente.isPresent()){
            clientes.delete(cliente.get());
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/api/clientes/{idCliente}")
    @ResponseBody
    public ResponseEntity atualzaCliente( @PathVariable Integer idCliente,
                                          @RequestBody Cliente cliente){
        return clientes
                .findById(idCliente)
                .map(clienteExistente ->{
                    cliente.setIdCliente(clienteExistente.getIdCliente());
                    clientes.save(cliente);
                    return ResponseEntity.noContent().build();
                }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    //Método para listagem e pesquisa de Clientes
    @GetMapping("/api/clientes")
    public ResponseEntity find( Cliente filtroDeCliente){
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(
                        ExampleMatcher.StringMatcher.CONTAINING);
        Example example = Example.of(filtroDeCliente, matcher);
        List<Cliente> lista = clientes.findAll(example);
        return ResponseEntity.ok(lista);
    }
}
