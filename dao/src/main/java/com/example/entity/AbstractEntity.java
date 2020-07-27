package com.example.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

//@MappedSuperclass
public class AbstractEntity {

    private Integer id;
    /**
     *  не хватило времени
     *  тут надо сделать гетер/сеттер на общий айдишник,
     *  соответственно рефакторинг айдишников всех ентити, рефакторинг связей между ними
     *  рефакторинг в базе данных и в ликвибейз чейнджлогах
     */

//    @Id
//    @GeneratedValue(generator = "increment")
//    @GenericGenerator(name = "increment", strategy = "increment")
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
}
