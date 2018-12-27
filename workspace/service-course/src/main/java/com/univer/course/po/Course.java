package com.univer.course.po;

import com.univer.base.po.BaseEntity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * @author lvgang
 * @descript
 * @time 2018-12-19 17:58
 */
public class Course extends BaseEntity {

    /**
     * ID
     */
    @NotNull(message = "{course.id.not.null}", groups = {  })
    @Id
    @Column(name = "course_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseId;

    /**
     * 编码
     */
    @Null
    private String code;

    /**
     * 课程名
     */
    @NotNull(message = "{course.name.not.null}", groups = { })
    @Size(min = 1, max = 25, message = "{course.name.size}", groups = { })
    @Pattern(regexp = "^[a-zA-Z][a-zA-Z0-9_]*$", message = "{course.name.pattern}", groups = { })
    private String name;

    /**
     * 描述
     */
    @Size(min = 1, max = 1024, message = "{course.avatar.max}", groups = { })
    private String description;

    /**
     * 类型
     */
    private String type;

    /**
     * 大学id
     */
    private Long universityId;
    /**
     * 大学名
     */
    private String universityName;
    /**
     * 学院id
     */
    private Long facultyId;
    /**
     * 学院名
     */
    private String facultyName;

    /**
     * 系id
     */
    private Long subjectId;
    /**
     * 系名
     */
    private String subjectName;

    /**
     * 状态 是否禁用
     */
    private String status;
    private Long createId;
    /**
     * 创建时间
     */
    @Column(name = "create_time")
    @com.fasterxml.jackson.annotation.JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    @com.fasterxml.jackson.annotation.JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getUniversityId() {
        return universityId;
    }

    public void setUniverityId(Long univerityId) {
        this.universityId = univerityId;
    }

    public String getUniverityName() {
        return universityName;
    }

    public void setUniverityName(String univerityName) {
        this.universityName = univerityName;
    }

    public Long getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(Long facultyId) {
        this.facultyId = facultyId;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getCreateId() {
        return createId;
    }

    public void setCreateId(Long createId) {
        this.createId = createId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", type='" + type + '\'' +
                ", universityId=" + universityId +
                ", universityName='" + universityName + '\'' +
                ", facultyId=" + facultyId +
                ", facultyName='" + facultyName + '\'' +
                ", subjectId=" + subjectId +
                ", subjectName='" + subjectName + '\'' +
                ", status='" + status + '\'' +
                ", createId=" + createId +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}