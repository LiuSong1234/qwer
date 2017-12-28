package com.example.mvpsjk.View.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by Macbookpro on 2017/12/28.
 */
@Entity
public class Student {
    @Id(autoincrement = true)
    private Long id;
    private String name;
    private String age;
    private String sex;
    private String banji;
    @Generated(hash = 25311084)
    public Student(Long id, String name, String age, String sex, String banji) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.banji = banji;
    }
    @Generated(hash = 1556870573)
    public Student() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAge() {
        return this.age;
    }
    public void setAge(String age) {
        this.age = age;
    }
    public String getSex() {
        return this.sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public String getBanji() {
        return this.banji;
    }
    public void setBanji(String banji) {
        this.banji = banji;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", sex='" + sex + '\'' +
                ", banji='" + banji + '\'' +
                '}';
    }
}
