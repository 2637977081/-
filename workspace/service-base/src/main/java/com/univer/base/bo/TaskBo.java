package com.univer.base.bo;

/**
 * @author jianyi
 * 任务类
 */
public class TaskBo {
    /**
     * 任务唯一标识  d6af4068fcd349439f9674c5e626d8cf
     */
    private String code;

    /**
     * 要求爬取样本数量  1000
     */
    private Long targetCount;

    /**
     * 要求爬取比例    9
     */
    private Integer crawlRatio;

    /**
     * 任务类型(图片类型，视频类型，音频类型) image video audio
     */
    private String type;

    /**
     * 爬取关键字  风景
     */
    private String keyWord;

    /**
     * 爬取引擎  goole
     */
    private String searchEngine;

    /**
     * endpoint http://10.10.0.13
     */
    private String endpoint;

    /**
     * bucket  tag-dev
     */
    private String bucket;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Long getTargetCount() {
        return targetCount;
    }

    public void setTargetCount(Long targetCount) {
        this.targetCount = targetCount;
    }

    public Integer getCrawlRatio() {
        return crawlRatio;
    }

    public void setCrawlRatio(Integer crawlRatio) {
        this.crawlRatio = crawlRatio;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    public String getSearchEngine() {
        return searchEngine;
    }

    public void setSearchEngine(String searchEngine) {
        this.searchEngine = searchEngine;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getBucket() {
        return bucket;
    }

    public void setBucket(String bucket) {
        this.bucket = bucket;
    }
}
