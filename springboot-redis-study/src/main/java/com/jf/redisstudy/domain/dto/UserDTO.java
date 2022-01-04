package com.jf.redisstudy.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 江峰
 * @date 2022/1/4 12:01
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO implements Serializable {

    private static final long serialVersionUID = 4204461422155385093L;

    private Integer id;

    private String name;

    private Integer age;


    public static UserDTO getOneUser() {

        UserDTO userDTO = new UserDTO();
        userDTO.setId(3);
        userDTO.setName("张三");
        userDTO.setAge(33);

        return userDTO;
    }

    public static List<UserDTO> getUserList() {

        UserDTO userDTO1 = new UserDTO();
        userDTO1.setId(4);
        userDTO1.setName("李四");
        userDTO1.setAge(44);

        UserDTO userDTO2 = new UserDTO();
        userDTO2.setId(5);
        userDTO2.setName("王五");
        userDTO2.setAge(55);
        List<UserDTO> userDTOList = new ArrayList<>();
        userDTOList.add(userDTO1);
        userDTOList.add(userDTO2);

        return userDTOList;
    }

}
