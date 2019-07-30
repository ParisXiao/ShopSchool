package com.liuzhi.eschool.entity;

public class ImgCodeEntity {


    /**
     * code : 0
     * msg : 验证码获取成功
     * data : {"imgCode":"/9j/4AAQSkZJRgABAgAAAQABAAD/2wBDAAgGBgcGBQgHBwcJCQgKDBQNDAsLDBkSEw8UHRofHh0aHBwgJC4nICIsIxwcKDcpLDAxNDQ0Hyc5PTgyPC4zNDL/2wBDAQkJCQwLDBgNDRgyIRwhMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjL/wAARCAAZAEYDASIAAhEBAxEB/8QAHwAAAQUBAQEBAQEAAAAAAAAAAAECAwQFBgcICQoL/8QAtRAAAgEDAwIEAwUFBAQAAAF9AQIDAAQRBRIhMUEGE1FhByJxFDKBkaEII0KxwRVS0fAkM2JyggkKFhcYGRolJicoKSo0NTY3ODk6Q0RFRkdISUpTVFVWV1hZWmNkZWZnaGlqc3R1dnd4eXqDhIWGh4iJipKTlJWWl5iZmqKjpKWmp6ipqrKztLW2t7i5usLDxMXGx8jJytLT1NXW19jZ2uHi4+Tl5ufo6erx8vP09fb3+Pn6/8QAHwEAAwEBAQEBAQEBAQAAAAAAAAECAwQFBgcICQoL/8QAtREAAgECBAQDBAcFBAQAAQJ3AAECAxEEBSExBhJBUQdhcRMiMoEIFEKRobHBCSMzUvAVYnLRChYkNOEl8RcYGRomJygpKjU2Nzg5OkNERUZHSElKU1RVVldYWVpjZGVmZ2hpanN0dXZ3eHl6goOEhYaHiImKkpOUlZaXmJmaoqOkpaanqKmqsrO0tba3uLm6wsPExcbHyMnK0tPU1dbX2Nna4uPk5ebn6Onq8vP09fb3+Pn6/9oADAMBAAIRAxEAPwDvNUEUXhee6hWMSw25bcqjO7Zxn6Eg/hVbwpN9r8N213d2wmlk37pdq4IDMOnAHAx+FO1e4jfw5eJKoDizkXgEZ+QlTnr17dOc1D4ImnTwrZKqK6fvCByCB5hyc45/DJ5pW903t7g7W72OzkijtLM3F5dEiC32EDgdSRwV78H8cZqtHYa00T3Sanas6EO1ubFNnTO3d97bkYz1xzxUWpxsnjDR55pIvJZZYtjts+dQc57ZbcvOeTxW8kU6T42Shsbmw4JPqR+BOPeskudu/Q50vaSlzPbTexzmk/2vrtzdbryC1mt2XMQgQqMk5A+hGO/1qLVb3WdKWWBltN9sqzea0S5miL7QCOQDlh0weDyeDSaXDLPrGqeTfCzQTE5MAk3fMcDB6VYaxZL+80m9MF3eajbl4btic5wQAc5AGRnj0HU4A0ktLGtrF3WrqS10l0s0ge5neKK3ljVW3M2MYyMHKg8//WpdI1FbjQkvNQSASQiQTlUCspU85XoWxg4x34rKs5f7Zg8OQ4wtvFI8wznaI/ljYgc4z/M9cVHqkj6XpuvWSptH2lZEmkAy/mjDAAjkfI3Tpj1FRzfaGaWjyz3fhqG7un82aWZiCsITC8jGQMHkE/j7UVfFn9l0qCESh0iVEyuSrELjOOx4zj3oqktB2Itfu7ODwxOZb2NJZLVokjcDL5GMKMZPJHPOP1pnhG2aHQLKN5WyImkHlZxhiGAIHP8AFz9ODxXOeIv+Qtof/Xb/ANmWunj+7+X8qtbF/ZSLOo6bHf2UtnKY7hJPmx0dWA+8BnIYfrzn0rPi0vWI22Sa9cRwqoj2m3Xf5ZPTzOzYz8x7/pKP9c30pv8AGf8AfFZygm7sxlTjJ3f+RDF4VudLhaTT9UYI3BBgBIUA9ST9R2q7pemQ2l5JcX832i4ddivIuwxjpgL2yCOff6mq8n3vz/nTx0b/AH/61S7FJdBdH8PWula7e3H2kn7SCIUVAiqrENj0PQAduDxzVfVfDrXeswag11g2pXMZQkMFbdy27gnP+TxVpfuD6VH/APF0uVJWHaxdul2xGRWfc8nIcEZ69sc+h9D9aKpzfcH1opt2Bux//9k=","stringCode":"JCBW","xAuthToken":"a41edb0a-5d84-4530-bb9b-14682d1d5408"}
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
         * imgCode : /9j/4AAQSkZJRgABAgAAAQABAAD/2wBDAAgGBgcGBQgHBwcJCQgKDBQNDAsLDBkSEw8UHRofHh0aHBwgJC4nICIsIxwcKDcpLDAxNDQ0Hyc5PTgyPC4zNDL/2wBDAQkJCQwLDBgNDRgyIRwhMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjL/wAARCAAZAEYDASIAAhEBAxEB/8QAHwAAAQUBAQEBAQEAAAAAAAAAAAECAwQFBgcICQoL/8QAtRAAAgEDAwIEAwUFBAQAAAF9AQIDAAQRBRIhMUEGE1FhByJxFDKBkaEII0KxwRVS0fAkM2JyggkKFhcYGRolJicoKSo0NTY3ODk6Q0RFRkdISUpTVFVWV1hZWmNkZWZnaGlqc3R1dnd4eXqDhIWGh4iJipKTlJWWl5iZmqKjpKWmp6ipqrKztLW2t7i5usLDxMXGx8jJytLT1NXW19jZ2uHi4+Tl5ufo6erx8vP09fb3+Pn6/8QAHwEAAwEBAQEBAQEBAQAAAAAAAAECAwQFBgcICQoL/8QAtREAAgECBAQDBAcFBAQAAQJ3AAECAxEEBSExBhJBUQdhcRMiMoEIFEKRobHBCSMzUvAVYnLRChYkNOEl8RcYGRomJygpKjU2Nzg5OkNERUZHSElKU1RVVldYWVpjZGVmZ2hpanN0dXZ3eHl6goOEhYaHiImKkpOUlZaXmJmaoqOkpaanqKmqsrO0tba3uLm6wsPExcbHyMnK0tPU1dbX2Nna4uPk5ebn6Onq8vP09fb3+Pn6/9oADAMBAAIRAxEAPwDvNUEUXhee6hWMSw25bcqjO7Zxn6Eg/hVbwpN9r8N213d2wmlk37pdq4IDMOnAHAx+FO1e4jfw5eJKoDizkXgEZ+QlTnr17dOc1D4ImnTwrZKqK6fvCByCB5hyc45/DJ5pW903t7g7W72OzkijtLM3F5dEiC32EDgdSRwV78H8cZqtHYa00T3Sanas6EO1ubFNnTO3d97bkYz1xzxUWpxsnjDR55pIvJZZYtjts+dQc57ZbcvOeTxW8kU6T42Shsbmw4JPqR+BOPeskudu/Q50vaSlzPbTexzmk/2vrtzdbryC1mt2XMQgQqMk5A+hGO/1qLVb3WdKWWBltN9sqzea0S5miL7QCOQDlh0weDyeDSaXDLPrGqeTfCzQTE5MAk3fMcDB6VYaxZL+80m9MF3eajbl4btic5wQAc5AGRnj0HU4A0ktLGtrF3WrqS10l0s0ge5neKK3ljVW3M2MYyMHKg8//WpdI1FbjQkvNQSASQiQTlUCspU85XoWxg4x34rKs5f7Zg8OQ4wtvFI8wznaI/ljYgc4z/M9cVHqkj6XpuvWSptH2lZEmkAy/mjDAAjkfI3Tpj1FRzfaGaWjyz3fhqG7un82aWZiCsITC8jGQMHkE/j7UVfFn9l0qCESh0iVEyuSrELjOOx4zj3oqktB2Itfu7ODwxOZb2NJZLVokjcDL5GMKMZPJHPOP1pnhG2aHQLKN5WyImkHlZxhiGAIHP8AFz9ODxXOeIv+Qtof/Xb/ANmWunj+7+X8qtbF/ZSLOo6bHf2UtnKY7hJPmx0dWA+8BnIYfrzn0rPi0vWI22Sa9cRwqoj2m3Xf5ZPTzOzYz8x7/pKP9c30pv8AGf8AfFZygm7sxlTjJ3f+RDF4VudLhaTT9UYI3BBgBIUA9ST9R2q7pemQ2l5JcX832i4ddivIuwxjpgL2yCOff6mq8n3vz/nTx0b/AH/61S7FJdBdH8PWula7e3H2kn7SCIUVAiqrENj0PQAduDxzVfVfDrXeswag11g2pXMZQkMFbdy27gnP+TxVpfuD6VH/APF0uVJWHaxdul2xGRWfc8nIcEZ69sc+h9D9aKpzfcH1opt2Bux//9k=
         * stringCode : JCBW
         * xAuthToken : a41edb0a-5d84-4530-bb9b-14682d1d5408
         */

        private String imgCode;
        private String stringCode;
        private String xAuthToken;

        public String getImgCode() {
            return imgCode;
        }

        public void setImgCode(String imgCode) {
            this.imgCode = imgCode;
        }

        public String getStringCode() {
            return stringCode;
        }

        public void setStringCode(String stringCode) {
            this.stringCode = stringCode;
        }

        public String getXAuthToken() {
            return xAuthToken;
        }

        public void setXAuthToken(String xAuthToken) {
            this.xAuthToken = xAuthToken;
        }
    }
}
