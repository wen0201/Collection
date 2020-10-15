package com.foxlink.CollectionCopy.utils;



import java.util.*;

import com.foxlink.CollectionCopy.commom.User;

public class ListTest {

    public static void main(String[] args) {
        //List集合放实体Bean
        List<User> stringList = new ArrayList<>();
        stringList.add(new User("zz", 20));
        stringList.add(new User("aa", 21));
        List<User> newList = BeanUtils.copyList(stringList, User.class);
        System.out.println(newList);

        //list集合放基本数据类型
        List<String> strList = new ArrayList<>();
        strList.add("zz");
        strList.add("aa");
        List<String> newStrList = BeanUtils.copyBaseList(strList, String.class);
        System.out.println(newStrList);
    }
}
