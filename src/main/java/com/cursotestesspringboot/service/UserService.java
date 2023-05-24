package com.cursotestesspringboot.service;

import com.cursotestesspringboot.controller.exception.ObjectNotFoundException;
import com.cursotestesspringboot.domain.Users;
import com.cursotestesspringboot.domain.dto.UserDTO;
import com.cursotestesspringboot.service.exception.DataIntegrityViolationException;
import com.cursotestesspringboot.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper mapper;

    public Users findById(Long id){
        return userRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!"));
    }

    public List<Users> findAll(){
        return userRepository.findAll();
    }

    public Users createOrUpdate(UserDTO userDTO){
        findByEmail(userDTO);
        return userRepository.save(mapper.map(userDTO, Users.class));
    }

    private void findByEmail(UserDTO userDTO){
        Optional<Users> user = userRepository.findByEmail(userDTO.getEmail());
        if(user.isPresent() && !!user.get().getId().equals(userDTO.getId())) //verificar se já existe o email cadastrado e se ele pertence ao outro comparando o ID
            throw new DataIntegrityViolationException("E-mail já cadastrado no sistema");
    }

    public void delete(Long id){
        findById(id);
        userRepository.deleteById(id);
    }

}
