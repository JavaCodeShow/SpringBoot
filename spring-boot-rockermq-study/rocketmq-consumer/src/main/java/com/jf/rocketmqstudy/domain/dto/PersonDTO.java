package com.jf.rocketmqstudy.domain.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 江峰
 * @date 2022/8/26 17:41
 */
@Data
public class PersonDTO {

    private Integer id;
    private String name;

    public static PersonDTO getUserOne() {
        PersonDTO personDTO = new PersonDTO();
        personDTO.setId(1);
        personDTO.setName("张三");
        return personDTO;
    }

    public static PersonDTO getUserTwo() {
        PersonDTO personDTO = new PersonDTO();
        personDTO.setId(6);
        personDTO.setName("赵六");
        return personDTO;
    }

    public static List<PersonDTO> getUserList() {
        PersonDTO personDTO1 = new PersonDTO();
        personDTO1.setId(4);
        personDTO1.setName("李四");
        PersonDTO personDTO2 = new PersonDTO();
        personDTO2.setId(5);
        personDTO2.setName("王五");
        List<PersonDTO> personDTOList = new ArrayList<>();
        personDTOList.add(personDTO1);
        personDTOList.add(personDTO2);
        return personDTOList;
    }
}
