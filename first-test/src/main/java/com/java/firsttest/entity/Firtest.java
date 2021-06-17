package com.java.firsttest.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 *
 * </p>
 *
 * @author luozhong
 * @since 2021-06-14
 */
@TableName("tb_firtest")
public class Firtest implements Serializable {

    private static final long serialVersionUID = 1L;
    @TableField(exist = false)
    private Integer page;
    @TableField(exist = false)
    private Integer limit;
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Double f;

    private Double g;

    private Double b;

    private String remark;

    private LocalDateTime date;

    private Integer num;

    private Integer userid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getF() {
        return f;
    }

    public void setF(Double f) {
        this.f = f;
    }

    public Double getG() {
        return g;
    }

    public void setG(Double g) {
        this.g = g;
    }

    public Double getB() {
        return b;
    }

    public void setB(Double b) {
        this.b = b;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    @Override
    public String toString() {
        return "Firtest{" +
                "id=" + id +
                ", f=" + f +
                ", g=" + g +
                ", b=" + b +
                ", remark=" + remark +
                ", date=" + date +
                ", num=" + num +
                ", userid=" + userid +
                "}";
    }

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
