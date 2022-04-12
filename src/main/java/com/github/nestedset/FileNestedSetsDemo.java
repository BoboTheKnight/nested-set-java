package com.github.nestedset;

import java.util.StringJoiner;

/**
 * 入库使用的嵌套集对象
 */
public class FileNestedSetsDemo {

    /**
     * 文件ID，唯一标识
     */
    private String id;

    /**
     * 文件完整路径
     */
    private String path;

    /**
     * 文件类型； FILE/DIRECTORY
     */
    private String type;

    /**
     * 文件大小
     */
    private Double size;

    /**
     * 树ID
     */
    private Long treeId;

    /**
     * 左值
     */
    private Long leftIndex;

    /**
     * 右值
     */
    private Long rightIndex;

    /**
     * 深度
     */
    private Long depth;

    @Override
    public String toString() {
        return new StringJoiner(", ", FileNestedSetsDemo.class.getSimpleName() + "[", "]")
            .add("id='" + id + "'")
            .add("path='" + path + "'")
            .add("type='" + type + "'")
            .add("size=" + size)
            .add("treeId=" + treeId)
            .add("leftIndex=" + leftIndex)
            .add("rightIndex=" + rightIndex)
            .add("depth=" + depth)
            .toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }

    public Long getTreeId() {
        return treeId;
    }

    public void setTreeId(Long treeId) {
        this.treeId = treeId;
    }

    public Long getLeftIndex() {
        return leftIndex;
    }

    public void setLeftIndex(Long leftIndex) {
        this.leftIndex = leftIndex;
    }

    public Long getRightIndex() {
        return rightIndex;
    }

    public void setRightIndex(Long rightIndex) {
        this.rightIndex = rightIndex;
    }

    public Long getDepth() {
        return depth;
    }

    public void setDepth(Long depth) {
        this.depth = depth;
    }
}