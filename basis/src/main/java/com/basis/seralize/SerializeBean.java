package com.basis.seralize;

import lombok.Data;

import java.io.Serializable;

/**
 * @author MengXH
 * @date 2024/1/9
 */
@Data
public class SerializeBean implements Serializable {

    private final long serialVersionUID = 1L;

    private Integer id;

    private String name;

}
