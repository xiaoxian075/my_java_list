package com.at.pojo.admin;

/**
 * Created by Administrator on 2017/6/12.
 * 树节点数据
 */
public class TreeLeafVO {
    private Integer id;
    private Integer parentId;//父Id
    private String text;//叶子文本
    private Integer methodId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getMethodId() {
        return methodId;
    }

    public void setMethodId(Integer methodId) {
        this.methodId = methodId;
    }
}
