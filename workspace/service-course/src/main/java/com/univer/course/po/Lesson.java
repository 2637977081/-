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
 * @time 2018-12-19 18:17
 */
public class Lesson extends BaseEntity {
    /**
     * ID
     */
    @NotNull(message = "{lesson.id.not.null}", groups = {  })
    @Id
    @Column(name = "lesson_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long lessonId;

    /**
     * 编码
     */
    @Null
    private String code;
    
    /**
     * 课程名
     */
    @NotNull(message = "{lesson.name.not.null}", groups = { })
    @Size(min = 1, max = 25, message = "{lesson.name.size}", groups = { })
    @Pattern(regexp = "^[a-zA-Z][a-zA-Z0-9_]*$", message = "{lesson.name.pattern}", groups = { })
    private String name;

    /**
     * 课程名id
     */
    @NotNull(message = "{course.id.not.null}", groups = { })
    private Long courseId;
    
    /**
     * 描述
     */
    @Size(min = 1, max = 1024, message = "{lesson.avatar.max}", groups = { })
    private String description;

    /**
     * 最大人数
     */
    @NotNull(message = "{lesson.maxnum.not.null}", groups = { })
    private Integer maxnum;

    /**
     *已选人数
     */
    @NotNull(message = "{lesson.num.not.null}", groups = { })
    private Integer num;

    /**
     * 类型
     */
    private String type;

    /**
     * 教师id
     */
    private Long teacherId;
    /**
     * 教师名
     */
    private String teacherName;
    /**
     * 表现分比例
     */
    private Integer behavior;
    /**
     * 实验分比例
     */
    private Integer test;

    /**
     * 考试分比例
     */
    private Integer exam;

    /**
     * 状态 是否禁用
     */
    private String status;

    /**
     * 学分
     */
    private Integer credit;

    /**
     * 授课时长
     */
    private Integer teachTime;
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

    public Long getLessonId() {
        return lessonId;
    }

    public void setLessonId(Long lessonId) {
        this.lessonId = lessonId;
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

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getMaxnum() {
        return maxnum;
    }

    public void setMaxnum(Integer maxnum) {
        this.maxnum = maxnum;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
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

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }

    public Integer getTeachTime() {
        return teachTime;
    }

    public void setTeachTime(Integer teachTime) {
        this.teachTime = teachTime;
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "lessonId=" + lessonId +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", courseId=" + courseId +
                ", description='" + description + '\'' +
                ", maxnum=" + maxnum +
                ", num=" + num +
                ", type='" + type + '\'' +
                ", teacherId=" + teacherId +
                ", teacherName='" + teacherName + '\'' +
                ", behavior=" + behavior +
                ", test=" + test +
                ", exam=" + exam +
                ", status='" + status + '\'' +
                ", credit=" + credit +
                ", teachTime=" + teachTime +
                ", createId=" + createId +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
