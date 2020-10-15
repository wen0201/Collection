package com.foxlink.CollectionCopy.utils;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;

import java.util.ArrayList;
import java.util.List;

public class BeanUtils {
    /**
     * 将源POJO对象数据复制给目标POJO对象的同名属性
     *
     * @date 2018年12月4日
     * @version 1.0
     *
     * @param source 源
     * @param target 目标
     * @param <S>
     * @param <T>
     * @return 目标
     */
    public static <S, T> T copy(S source, T target) {
        BeanUtil.copyProperties(source, target);
        return target;
    }

    /**
     * 将源POJO对象数据复制给目标POJO对象的同名属性
     *
     * @date 2019-1-29
     * @param source 源
     * @param target 目标
     * @param ignoreProperties 无需转换的属性
     * @param <S>
     * @param <T>
     * @return 目标
     */
    public static <S, T> T copy(S source, T target, String... ignoreProperties) {
        BeanUtil.copyProperties(source, target, ignoreProperties);
        return target;
    }


    /**
     * 将源POJO对象数据复制给目标POJO对象的同名属性
     *
     * @date 2019-1-29
     * @param source 源
     * @param target 目标
     * @param ignoreNullProperties 是否无视null值字段（如果为true则无视）
     * @param <S>
     * @param <T>
     * @return 目标
     */
    public static <S, T> T copy(S source, T target, boolean ignoreNullProperties) {
        BeanUtil.copyProperties(source, target, CopyOptions.create().setIgnoreNullValue(ignoreNullProperties));
        return target;
    }

    /**
     * 对象List复制
     *
     * @param ss
     * @param cls
     * @param <S>
     * @param <T>
     * @return
     */
    public static <S, T> List<T> copyList(List<S> ss, Class<T> cls) {

        List<T> tRes = new ArrayList<>();
        try {
            for (S s : ss) {
                T t = cls.newInstance();
                BeanUtil.copyProperties(s, t);
                tRes.add(t);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return tRes;
    }

    public static <S, T> List<T> copyBaseList(List<S> ss, Class<T> cls) {

        List<T> tRes = new ArrayList<>();
        try {
            for (S s : ss) {
                tRes.add((T)s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return tRes;
    }

    /**
     * 对象List复制
     *
     * @param ss
     * @param cls
     * @param ignoreProperties
     * @param <S>
     * @param <T>
     * @return
     */
    public static <S, T> List<T> copyList(List<S> ss, Class<T> cls, String... ignoreProperties) {

        List<T> tRes = new ArrayList<>();
        try {
            for (S s : ss) {
                T t = cls.newInstance();
                BeanUtil.copyProperties(s, t, ignoreProperties);
                tRes.add(t);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return tRes;
    }

    /**
     * 对象List复制
     *
     * @param ss
     * @param cls
     * @param ignoreNullProperties
     * @param <S>
     * @param <T>
     * @return
     */
    public static <S, T> List<T> copyList(List<S> ss, Class<T> cls, boolean ignoreNullProperties) {

        List<T> tRes = new ArrayList<>();
        try {
            for (S s : ss) {
                T t = cls.newInstance();
                BeanUtil.copyProperties(s, t, CopyOptions.create().setIgnoreNullValue(ignoreNullProperties));
                tRes.add(t);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return tRes;
    }
}
