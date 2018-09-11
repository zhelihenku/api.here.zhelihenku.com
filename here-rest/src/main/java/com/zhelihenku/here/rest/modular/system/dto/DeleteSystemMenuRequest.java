package com.zhelihenku.here.rest.modular.system.dto;

import java.util.List;

/**
 * DeleteSystemMenuRequest
 *
 * @Auther: PhilWang
 * @Date: 2018/9/9 20:43
 */
public class DeleteSystemMenuRequest {

    private List<Integer> ids;

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }

    @Override
    public String toString() {
        return "DeleteSystemMenuRequest{" +
                "ids=" + ids +
                '}';
    }

}
