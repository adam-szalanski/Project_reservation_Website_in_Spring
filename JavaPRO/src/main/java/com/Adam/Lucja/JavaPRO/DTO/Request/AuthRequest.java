package com.Adam.Lucja.JavaPRO.DTO.Request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthRequest {

    @NotNull
    private String username;

    @NotNull
    private String password;

    public AuthRequest(StudentRequest studentRequest){
        this.username = studentRequest.getNrAlbum();
        this.password=studentRequest.getPassword();
    }
}