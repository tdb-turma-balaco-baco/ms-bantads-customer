package br.net.dac.client.Presentation.Controllers;

import br.net.dac.client.Application.Services.Client.IClientService;
import br.net.dac.client.Application.Services.Client.Result.AddressClient;
import br.net.dac.client.Application.Services.Client.Result.ClientResult;
import br.net.dac.client.Domain.Exceptions.ClientNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/client")
public class ClientController {

   @Autowired
   IClientService _service;

    @GetMapping("/{cpf}/details")
    public ResponseEntity<ClientResult> findClientByCpf(@PathVariable String cpf)
    {
        try {
            var client = _service.findOneByCpf(cpf);
            return ResponseEntity.ok(client);
        }catch(ClientNotFoundException ex){
            return ResponseEntity.badRequest().build();
        }catch (Exception ex) {
            return ResponseEntity.internalServerError().build();
        }
    }
    @GetMapping("/{cpf}/address")
    public ResponseEntity<AddressClient> findClientAdressByCpf(@PathVariable String cpf)
    {
        try {
            var client = _service.findOneAdressByCpf(cpf);
            return ResponseEntity.ok(client);
        } catch(ClientNotFoundException ex){
            return ResponseEntity.badRequest().build();
        }
        catch (Exception ex) {
            return ResponseEntity.internalServerError().build();
        }
    }

}
