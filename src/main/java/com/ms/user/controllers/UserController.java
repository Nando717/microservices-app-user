package com.ms.user.controllers;


import com.ms.user.dto.UserRecordDto;
import com.ms.user.models.UserModel;
import com.ms.user.repository.UserRepository;
import com.ms.user.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/")

public class UserController {

   final UserService userService;

   public UserController(UserService userService){

       this.userService = userService;
   }


    @PostMapping("/users")
    public ResponseEntity<UserModel>saveUser(@RequestBody @Valid UserRecordDto userRecordDto){

        var userModel = new UserModel();
        BeanUtils.copyProperties(userRecordDto, userModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(userModel));
    }


    @GetMapping("/users")
    public ResponseEntity<List<UserModel>>getall(UserRecordDto userRecordDto, UserModel userModel){

       return ResponseEntity.status(HttpStatus.OK).body(userService.geti(userModel));
    }



    @GetMapping("/user/{id}")
    public ResponseEntity<Object>GetPorId(@PathVariable(value = "id")UUID id){
        Optional<UserModel> useR = userService.getPorId(id);

        if(useR.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("usuario não encontrado");
        }

        return ResponseEntity.status(HttpStatus.OK).body(userService.getPorId(id));
    }



}
