package com.java.thirdtest.entity;

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
@TableName("tb_thirtest")
public class Thirtest implements Serializable {

    private static final long serialVersionUID = 1L;
    @TableField(exist = false)
    private Integer page;
    @TableField(exist = false)
    private Integer limit;
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Double f;

    private Double eoc;

    private Double d;

    private Double a;

    private Double mel;

    private Double sl;

    private LocalDateTime date;

    private String remark;

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

    public Double getEoc() {
        return eoc;
    }

    public void setEoc(Double eoc) {
        this.eoc = eoc;
    }

    public Double getD() {
        return d;
    }

    public void setD(Double d) {
        this.d = d;
    }

    public Double getA() {
        return a;
    }

    public void setA(Double a) {
        this.a = a;
    }

    public Double getMel() {
        return mel;
    }

    public void setMel(Double mel) {
        this.mel = mel;
    }

    public Double getSl() {
        return sl;
    }

    public void setSl(Double sl) {
        this.sl = sl;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    @Override
    public String toString() {
        return "Thirtest{" +
                "id=" + id +
                ", f=" + f +
                ", eoc=" + eoc +
                ", d=" + d +
                ", a=" + a +
                ", mel=" + mel +
                ", sl=" + sl +
                ", date=" + date +
                ", remark=" + remark +
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
