package com.feng.springboot.entity;

import com.google.common.base.MoreObjects;
import com.google.common.base.MoreObjects.ToStringHelper;

import javax.persistence.*;
import java.util.Date;

/**
 * 未包括创建人和修改人, 当启用security, 进行用户权限控制时, 需添加这两个字段
 */
@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class BaseEntity {

    @Column(name = "is_deleted", columnDefinition = "Bit default '0'")
    protected boolean isDeleted = false;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "data_change_created_time", nullable = false)
    private Date dataChangeCreatedTime;

    @Column(name = "data_change_last_time")
    private Date dataChangeLastModifiedTime;

    public Date getDataChangeCreatedTime() {
        return dataChangeCreatedTime;
    }

    public void setDataChangeCreatedTime(Date dataChangeCreatedTime) {
        this.dataChangeCreatedTime = dataChangeCreatedTime;
    }

    public Date getDataChangeLastModifiedTime() {
        return dataChangeLastModifiedTime;
    }

    public void setDataChangeLastModifiedTime(Date dataChangeLastModifiedTime) {
        this.dataChangeLastModifiedTime = dataChangeLastModifiedTime;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    @PrePersist
    protected void prePersist() {
        if (this.dataChangeCreatedTime == null) dataChangeCreatedTime = new Date();
        if (this.dataChangeLastModifiedTime == null) dataChangeLastModifiedTime = new Date();
    }

    @PreUpdate
    protected void preUpdate() {
        this.dataChangeLastModifiedTime = new Date();
    }

    @PreRemove
    protected void preRemove() {
        this.dataChangeLastModifiedTime = new Date();
    }

    protected ToStringHelper toStringHelper() {
        return MoreObjects.toStringHelper(this).omitNullValues().add("id", id)
                .add("dataChangeCreatedTime", dataChangeCreatedTime)
                .add("dataChangeLastModifiedTime", dataChangeLastModifiedTime);
    }

    public String toString() {
        return toStringHelper().toString();
    }
}
