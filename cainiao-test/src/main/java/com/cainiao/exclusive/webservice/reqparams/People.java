package com.cainiao.exclusive.webservice.reqparams;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * Created by wangkecheng on 2018/7/23.
 */
@XmlRootElement(name = "people")
public class People {
    private Long id;
    private String name;
    private Date birthday;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
