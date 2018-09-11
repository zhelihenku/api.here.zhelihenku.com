package com.zhelihenku.here.rest.modular.system.dto;

/**
 * SystemUserPageListRequest
 *
 * @Auther: PhilWang
 * @Date: 2018/9/9 19:34
 */
public class SystemUserPageListRequest {

    private Integer index;

    private Integer pageSize;

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public String toString() {
        return "SystemUserPageListRequest{" +
                "index=" + index +
                ", pageSize=" + pageSize +
                '}';
    }
}
