package com.zhelihenku.here.rest.modular.system.dto;

import java.util.List;

/**
 * DeleteSystemRoleRequest
 *
 * @Auther: PhilWang
 * @Date: 2018/9/9 19:34
 */
public class DeleteSystemRoleRequest {

    private List<Integer> ids;

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }

    @Override
    public String toString() {
        return "DeleteSystemRoleRequest{" +
                "ids=" + ids +
                '}';
    }
}
