package com.liuzhi.eschool.entity;

public class ImgCodeEntity {

    /**
     * code : 0
     * msg : 验证码获取成功
     * data : {"imgCode":"/9j/4AAQSkZJRgABAgAAAQABAAD/2wBDAAgGBgcGBQgHBwcJCQgKDBQNDAsLDBkSEw8UHRofHh0aHBwgJC4nICIsIxwcKDcpLDAxNDQ0Hyc5PTgyPC4zNDL/2wBDAQkJCQwLDBgNDRgyIRwhMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjL/wAARCAAZAEYDASIAAhEBAxEB/8QAHwAAAQUBAQEBAQEAAAAAAAAAAAECAwQFBgcICQoL/8QAtRAAAgEDAwIEAwUFBAQAAAF9AQIDAAQRBRIhMUEGE1FhByJxFDKBkaEII0KxwRVS0fAkM2JyggkKFhcYGRolJicoKSo0NTY3ODk6Q0RFRkdISUpTVFVWV1hZWmNkZWZnaGlqc3R1dnd4eXqDhIWGh4iJipKTlJWWl5iZmqKjpKWmp6ipqrKztLW2t7i5usLDxMXGx8jJytLT1NXW19jZ2uHi4+Tl5ufo6erx8vP09fb3+Pn6/8QAHwEAAwEBAQEBAQEBAQAAAAAAAAECAwQFBgcICQoL/8QAtREAAgECBAQDBAcFBAQAAQJ3AAECAxEEBSExBhJBUQdhcRMiMoEIFEKRobHBCSMzUvAVYnLRChYkNOEl8RcYGRomJygpKjU2Nzg5OkNERUZHSElKU1RVVldYWVpjZGVmZ2hpanN0dXZ3eHl6goOEhYaHiImKkpOUlZaXmJmaoqOkpaanqKmqsrO0tba3uLm6wsPExcbHyMnK0tPU1dbX2Nna4uPk5ebn6Onq8vP09fb3+Pn6/9oADAMBAAIRAxEAPwD1ERW4t7XdbRjdGAWKj58genOc+2ec/WSKys3Jlih2sn3opVJ/Trz+P0rE8bahcaZ8Obye3ysn2eJFcE5UsyqTxyCAcg+o/PBv/DOqxR+bp+m6Pp+owzK6X8V3I8sTZ5LHysuGUkHcWznnJqnHW7ehVjQ8TXt3ps+mPZ/Y/JvLuG0KzW27G/d84ZXTgY+6QDxyewtX663ZfYJ0Ol3tu9zFHIINPdHMbEKzD94w3DOcEYGM9iKyvG7F4dDKMIbv+2odkjDcvO/DHGM4Ppitp01yTUbJbm4s3txclrhLW1eMMhicBiTKQw3MnGM5KntVRa5E7okhtZrybV9T0+eSxaG0ERM0dntLb13DndhR+eewqt4h1ybQbVLuOGzkgaVY2ElruK5BOQQ45OPu9vX0W1a9TxL4gNnPaqiC1DiWMybgEwNpVh09fp06VR8Xrfac2lXeqXNo8K6pFI5S2ZcbckseTkYPQDn61zXd7oqlHnkos6Swt9bvLWOe5j0WxdwuIfsjTH7oJy29RnOeADgdzzU2h3El/bXkd7ptlFf2cvlOsOGjk+VWDKccBg3AOSO/pVrfMLFpLe3V5XOViklKowz2ZQxUqPQZ46dxl+Hdcn1K5vY/sMECWdw9uXW6MhdlIBAyg4IPDZHRQa1Uti9ZRbsWtTREjQqkUcbncjRrgsO2eO39R1xRTNQkjYGWOQkO+Qgb3PPt6/8AAvaios5a/wCRmNubKPV9Ck0y+BeC4QA8ZZRnquQQGHBH1XHPWiNAvrTTF06TUYbnSBCYTm0KzGIZVY2cPjJVghIUHGT8pG4Kn8P+fWpG6fiP50nUcXyoL20KniPRJ9aOnywXsNvDbXKzorW28+YCxUFg4AXDDI6jnk9A2+03xDqGm3VodWsYUu4/KlaOybdtK89ZSBuGecevIq12T6D+Ypp6N9T/ADFVCctLdPJAT2mk6paapfXs93E0l6iiSBID8wVSowS/bj+8ead4h04+Kora1WaNbVZlkeN4CWLDdwSHHylSenPHXmq6f61vxpR9yT6mpbs7CStsLb6bqulWK6VFqtvPBAUSIz2G5k+VcD5XXIJDdie3NW9L0aPQ9KmmhuGuXumaa4kkVV3yPtDYCj5V4JwDx6nFUR9z8P8AGg/fj+gqratGjnJ6GldM32EOXV4xJgMR82SoP/6x69zRWbJ0H1P86KI0YzV2RY//2Q==","xAuthToken":"c775fb01-d8b7-46d3-acb6-c2aa0a7a99e9"}
     */

    private int code;
    private String msg;
    private DataBean data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * imgCode : 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
         * xAuthToken : c775fb01-d8b7-46d3-acb6-c2aa0a7a99e9
         */

        private String imgCode;
        private String xAuthToken;

        public String getImgCode() {
            return imgCode;
        }

        public void setImgCode(String imgCode) {
            this.imgCode = imgCode;
        }

        public String getXAuthToken() {
            return xAuthToken;
        }

        public void setXAuthToken(String xAuthToken) {
            this.xAuthToken = xAuthToken;
        }
    }
}
