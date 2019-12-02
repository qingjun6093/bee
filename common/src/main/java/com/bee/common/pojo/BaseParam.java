package com.bee.common.pojo;

import com.alibaba.fastjson.JSON;

import java.util.Date;
import java.util.List;

/**
 * @author jjq
 * @version 1.0
 * @date 2019/6/30
 * @desc 查询参数基类
 */
public class BaseParam {

    private Long id;

    /**
     * not in (id1,id2,...)
     */
    private List<Long> notInIds;

    private Integer intId;

    /**
     * not in (id1,id2,...)
     */
    private List<Integer> notInIntIds;

    private Byte status;

    /**
     * `status` in (status1,status2,...)
     */
    private List<Byte> statusList;

    /**
     * order by sort
     */
    private String sort;

    /**
     * order by sort1,sort2
     */
    private List<String> sortList;

    /**
     * limit start , pageSize
     */
    private Long start;

    private Integer pageSize;

    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Long> getNotInIds() {
        return notInIds;
    }

    public void setNotInIds(List<Long> notInIds) {
        this.notInIds = notInIds;
    }

    public Integer getIntId() {
        return intId;
    }

    public void setIntId(Integer intId) {
        this.intId = intId;
    }

    public List<Integer> getNotInIntIds() {
        return notInIntIds;
    }

    public void setNotInIntIds(List<Integer> notInIntIds) {
        this.notInIntIds = notInIntIds;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public List<Byte> getStatusList() {
        return statusList;
    }

    public void setStatusList(List<Byte> statusList) {
        this.statusList = statusList;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public List<String> getSortList() {
        return sortList;
    }

    public void setSortList(List<String> sortList) {
        this.sortList = sortList;
    }

    public Long getStart() {
        return start;
    }

    public void setStart(Long start) {
        this.start = start;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
       return JSON.toJSONString(this);
    }
}
