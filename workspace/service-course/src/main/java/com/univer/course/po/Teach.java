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
 * @time 2018-12-19 18:28
 */
public class Teach extends BaseEntity {

    /**
     * ID
     */
    @NotNull(message = "{teach.id.not.null}", groups = {  })
    @Id
    @Column(name = "teach_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long teachId;

    /**
     * 编码
     */
    @Null
    private String code;

    /**
     * 课程名
     */
    @NotNull(message = "{teach.name.not.null}", groups = { })
    @Size(min = 1, max = 25, message = "{teach.name.size}", groups = { })
    @Pattern(regexp = "^[a-zA-Z][a-zA-Z0-9_]*$", message = "{teach.name.pattern}", groups = { })
    private String name;

    /**
     * 课程id
     */
    private String lessonId;
    /**
     * 描述
     */
    @Size(min = 1, max = 1024, message = "{teach.avatar.max}", groups = { })
    private String description;

    /**
     * 类型
     */
    private String type;

    /**
     * 学生id
     */
    private Long studentId;
    /**
     * 学生名
     */
    private String studentName;

    /**
     * 表现分
     */
    private Integer behavior;
    /**
     * 实验分
     */
    private Integer test;

    /**
     * 考试分
     */
    private Integer exam;

    /**
     * 成绩
     */
    private Integer score;

    /**
     * 学分
     */
    private Integer credit;
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

    public Long getTeachId() {
        return teachId;
    }

    public void setTeachId(Long teachId) {
        this.teachId = teachId;
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

    public String getLessonId() {
        return lessonId;
    }

    public void setLessonId(String lessonId) {
        this.lessonId = lessonId;
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

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Integer getBehavior() {
        return behavior;
    }

    public void setBehavior(Integer behavior) {
        this.behavior = behavior;
    }

    public Integer getTest() {
        return test;
    }

    public void setTest(Integer test) {
        this.test = test;
    }

    public Integer getExam() {
        return exam;
    }

    public void setExam(Integer exam) {
        this.exam = exam;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
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
        return "Teach{" +
                "teacherId=" + teachId +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", lessonId='" + lessonId + '\'' +
                ", description='" + description + '\'' +
                ", type='" + type + '\'' +
                ", studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", behavior=" + behavior +
                ", test=" + test +
                ", exam=" + exam +
                ", score=" + score +
                ", credit=" + credit +
                ", status='" + status + '\'' +
                ", createId=" + createId +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
