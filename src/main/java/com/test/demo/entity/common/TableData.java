package com.test.demo.entity.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @author xujingjing
 * @date 2022/1/27
 * @apiNote
 */
@ApiModel(value = "TableData对象",description = "分页封装对象")
public class TableData {

    @ApiModelProperty(name="total",value = "总数据条数")
    private long total;

    @ApiModelProperty(name="rows",value = "数据对象集合")
    private List<?> rows;

    public TableData() {
    }

    public TableData(long total, List<?> rows) {
        this.total = total;
        this.rows = rows;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<?> getRows() {
        return rows;
    }

    public void setRows(List<?> rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        return "TableData{" +
                "total=" + total +
                ", rows=" + rows +
                '}';
    }
}
