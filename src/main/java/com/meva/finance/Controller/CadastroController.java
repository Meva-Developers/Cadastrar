package com.meva.finance.Controller;



import com.meva.finance.dto.UsersDto;
import com.meva.finance.modelo.Users;
import com.meva.finance.repository.UsersRepository;
import com.meva.finance.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import javax.xml.bind.ValidationException;


@RestController
@RequestMapping("/Login")
public class CadastroController {

    @Autowired
    private UsersRepository usersRepository;


    @Autowired
    private UserService userService;

    @PostMapping("/cadastrar")
    public ResponseEntity<UsersDto> cadastrar(@RequestBody UsersDto dto) throws ValidationException {
      userService.serviceCadastrar(dto);
      return ResponseEntity.ok().build();

    }

    @PutMapping("/atualizar/{cpf}")
    public ResponseEntity<UsersDto> atualizar(@PathVariable String cpf, @RequestBody @Valid UsersDto usersDto){
       Users users = userService.atualizar(usersDto);
        return ResponseEntity.ok(new UsersDto(users));
    }

    @DeleteMapping("/{cpf}")
    public ResponseEntity<String> remover(@PathVariable String id, UsersDto usersDto){
        userService.remover(id);
        return ResponseEntity.ok().build();
    }


}
