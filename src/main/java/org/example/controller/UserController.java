package org.example.controller;

import jakarta.annotation.PostConstruct;
import org.example.dto.UserDTO;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class UserController {

    @GetMapping("/")
    public String getMessage() {
        return "Spring boot is working";
    }

    public static List<UserDTO> users = new ArrayList<UserDTO>();

    @PostConstruct
    public void initList() {

        UserDTO userDTO = new UserDTO("Thiago Santos", "322",
                "Rua a", "thisantos@gmail.com",
                "7123-3213", new Date());

        UserDTO userDTO1 = new UserDTO("Rebeca Santana", "987",
                "Rua b", "beccasan@gmail.com",
                "7802-8412", new Date());

        users.add(userDTO);
        users.add(userDTO1);
    }

    @GetMapping("/users")
    public List<UserDTO> getUsers() {
        return users;
    }

    @GetMapping("/users/{cpf}")
    public UserDTO getUserByCpf(@PathVariable String cpf) {
        for (UserDTO userFilter : users) {

            if (userFilter.cpf().equals(cpf)) {
                return userFilter;
            }
        }

        return null;
    }

    @PostMapping("/users/newUser")
    UserDTO addNewUser(@RequestBody UserDTO user) {

        UserDTO newUser = new UserDTO(
                user.nome(), user.cpf(),
                user.endereco(), user.email(),
                user.telefone(), new Date());

        users.add(newUser);
        return newUser;
    }

    @DeleteMapping("/users/{cpf}")
    public boolean deleteUser(@PathVariable String cpf) {

        for (UserDTO userDelete : users) {

            if (userDelete.cpf().equals(cpf)) {

                users.remove(userDelete);
                return true;
            }
        }
        return false;
    }
}
