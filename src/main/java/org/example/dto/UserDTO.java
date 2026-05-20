package org.example.dto;

import org.example.model.User;

import java.util.Date;

public record UserDTO(String nome, String cpf,
                      String endereco, String email,
                      String telefone, Date dataCadastro) {

    public static UserDTO convert(User user) {
        UserDTO userDTO = new UserDTO(user.getNome(), user.getCpf(),
                user.getEndereco(), user.getEmail(), user.getTelefone(),
                user.getDataCadastro());

        return userDTO;
    }
}
