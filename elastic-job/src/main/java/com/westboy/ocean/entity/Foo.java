package com.westboy.ocean.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author: wangpengbo
 * @date: 2018/2/5
 */
@Getter
@Setter
@AllArgsConstructor
@ToString
public class Foo {

    private int id;

    private Status status;

    public enum Status {
        /**
         * 将要完成
         */
        TODO,
        /**
         * 已经完成
         */
        DONE;
    }
}
