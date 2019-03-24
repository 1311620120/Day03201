package com.example.day0320.model;

import java.util.List;

/**
 * @Auther: 白俊岭
 * @Date: 2019/3/23 14:58:15
 * @Description:
 */
public class TwoBean {

    /**
     * result : [{"id":"1001005002","name":"拉杆箱"},{"id":"1001005003","name":"双肩包"},{"id":"1001005001","name":"电脑包"}]
     * message : 查询成功
     * status : 0000
     */

    private String message;
    private String status;
    private List<ResultBean> result;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * id : 1001005002
         * name : 拉杆箱
         */

        private String id;
        private String name;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
