package com.hg.teamwork.controller.form;

/**
 * 分页
 */
public class PageLimit {
    /**
     * 页数
     */
    private Integer page;
    /**
     * 数量
     */
    private Integer limit;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }
}
