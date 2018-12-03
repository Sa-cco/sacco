package com.example.demo.compont;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Objects;
@Data
public class ModleUser {

    private Long id;

    private String userName;

    private String password;

    public ModleUser(Long id, String userName, String password) {
        this.id = id;
        this.userName = userName;
        this.password = password;
    }


}
