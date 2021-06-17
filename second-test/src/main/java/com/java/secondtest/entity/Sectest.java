package com.java.secondtest.entity;

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
@TableName("tb_sectest")
public class Sectest implements Serializable {

    private static final long serialVersionUID = 1L;
    @TableField(exist = false)
    private Integer page;
    @TableField(exist = false)
    private Integer limit;
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Double f;

    private Double eoc;

    private Double u;

    private Double d;

    private Double a;

    private Double mel;

    private Double tvr;

    private Double remark;

    private LocalDateTime date;

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

    public Double getU() {
        return u;
    }

    public void setU(Double u) {
        this.u = u;
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

    public Double getTvr() {
        return tvr;
    }

    public void setTvr(Double tvr) {
        this.tvr = tvr;
    }

    public Double getRemark() {
        return remark;
    }

    public void setRemark(Double remark) {
        this.remark = remark;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    @Override
    public String toString() {
        return "Sectest{" +
                "id=" + id +
                ", f=" + f +
                ", eoc=" + eoc +
                ", u=" + u +
                ", d=" + d +
                ", a=" + a +
                ", mel=" + mel +
                ", tvr=" + tvr +
                ", remark=" + remark +
                ", date=" + date +
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
