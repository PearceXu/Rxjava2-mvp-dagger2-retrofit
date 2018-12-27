package com.hytch.pos.entities;

import java.util.List;

import my.xubaipei.devlib.entities.BaseEntity;

/**
 * author ： xubaipei
 * create date： 2018-12-25
 */
public class Entity extends BaseEntity {

    private List<List<String>> result;

    public List<List<String>> getResult() {
        return result;
    }

    public void setResult(List<List<String>> result) {
        this.result = result;
    }
}
