package com.univer.base.enums;

/**
 * @author lvgang
 * @descript
 * @time 2018-12-28 20:37
 */
public enum ImageEnum {

    BMP("bmp"),JPG("jpg"),JPEG("jpeg"),PNG("png"),GIF("gif");
    private String image;

    ImageEnum(String image){this.image=image;}

    @Override
    public String toString() {
        return super.toString();
    }

    public static String getImage(String str){
        for (ImageEnum image: ImageEnum.values()) {
            if (image.getImage().equals(str)){
                return image.image;
            }
        }
        return null;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
