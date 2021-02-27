package com.lemonzuo.modle;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author LemonZuo
 * @create 2021-02-25 22:21
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    private Integer	id;
    private String	userId;
    private Integer	total;
    private Integer	used;
    private Integer	residue;
}
