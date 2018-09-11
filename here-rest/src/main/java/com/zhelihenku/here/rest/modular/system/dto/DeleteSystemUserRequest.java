package com.zhelihenku.here.rest.modular.system.dto;

import java.util.List;

/**
 * DeleteSystemUserRequest
 *
 * @Auther: PhilWang
 * @Date: 2018/9/11 14:35
 */
public class DeleteSystemUserRequest {

    private List<Integer> ids;

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }

    @Override
    public String toString() {
        return "DeleteSystemUserRequest{" +
                "ids=" + ids +
                '}';
    }

}
