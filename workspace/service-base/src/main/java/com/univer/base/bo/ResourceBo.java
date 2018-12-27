package com.univer.base.bo;

/**
 * @author jianyi
 * 资源类
 */
public class ResourceBo {
    /**
     * endpoint  http://10.10.0.13
     */
    private String endpoint;

    /**
     * bucket  tag-dev
     */
    private String bucket;

    /**
     * 对应图片的key  /1111111111/0cf3168be5b9403f8a3a059a6f796b14.jpg
     */
    private String url;

    /**
     * 对应的任务code  d6af4068fcd349439f9674c5e626d8cf
     */
    private String taskCode;

    /**
     * 存储类型  ceph oss
     */
    private String storageType;

    /**
     * 资源类型 image video audio
     */
    private String type;

    /**
     * 样本media类型   jpg  png
     */
    private String mediaType;

    /**
     * 该资源所属任务状态
     */
    private String taskStatus;


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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTaskCode() {
        return taskCode;
    }

    public void setTaskCode(String taskCode) {
        this.taskCode = taskCode;
    }

    public String getStorageType() {
        return storageType;
    }

    public void setStorageType(String storageType) {
        this.storageType = storageType;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMediaType() {
        return mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    public String getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }
}
