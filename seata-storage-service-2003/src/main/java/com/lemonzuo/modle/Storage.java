package com.lemonzuo.modle;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author LemonZuo
 * @create 2021-02-27 15:43
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Storage {
    private Integer id;
    private String productId;
    private Integer total;
    private Integer used;
    private Integer residue;
}
