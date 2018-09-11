package com.zhelihenku.here.rest.common.util;

import java.util.HashMap;
import java.util.Map;


/**
 * @author wangpeng
 */
public class CommonConstant {

    //未删除
    public static final String COURSE_APPOINTMENT_URL = "http://www.xschool.com/web/course/appointment/";

    /**
     * 删除状态
     */
    //未删除
    public static final Integer DELETE_STATUS_UNDELETE = 0;
    //已删除
    public static final Integer DELETE_STATUS_DELETED = 1;

    /**
     * 删除状态组
     */
    public static final Map<Integer,String> DELETE_STATUS = new HashMap<>();

    static{

        DELETE_STATUS.put(DELETE_STATUS_UNDELETE,"未删除");

        DELETE_STATUS.put(DELETE_STATUS_DELETED,"已删除");

    }

    /**
     * 系统用户账号状态
     */
    // 停用
    public static final Integer SYSTEM_USER_STATUS_DISENABLE = 0;
    // 启用
    public static final Integer SYSTEM_USER_STATUS_ENABLE = 1;
    // 冻结
    public static final Integer SYSTEM_USER_STATUS_FROZEN = 2;

    /**
     * 系统用户账号状态状态组
     */
    public static final Map<Integer,String> SYSTEM_USER_STATUS = new HashMap<>();

    static{

        SYSTEM_USER_STATUS.put(SYSTEM_USER_STATUS_DISENABLE, "停用");

        SYSTEM_USER_STATUS.put(SYSTEM_USER_STATUS_ENABLE, "启用");

        SYSTEM_USER_STATUS.put(SYSTEM_USER_STATUS_FROZEN, "冻结");

    }

    /**
     * 课程预约页面状态
     */
    //下架
    public static final Integer COURSE_APPOINTMENT_VIEW_STATUS_XIAJIA = 0;
    //上架
    public static final Integer COURSE_APPOINTMENT_VIEW_STATUS_SHANGJIA = 1;

    /**
     * 课程预约页面状态组
     */
    public static final Map<Integer,String> COURSE_APPOINTMENT_VIEW_STATUS_GROUP = new HashMap<>();

    static {

        COURSE_APPOINTMENT_VIEW_STATUS_GROUP.put(COURSE_APPOINTMENT_VIEW_STATUS_XIAJIA,"下架");

        COURSE_APPOINTMENT_VIEW_STATUS_GROUP.put(COURSE_APPOINTMENT_VIEW_STATUS_SHANGJIA,"上架");

    }
    /**
     * 课程预约状态
     */
    //未处理
    public static final Integer COURSE_APPOINTMENT_STATUS_UNTREATED = 0;
    //已处理
    public static final Integer COURSE_APPOINTMENT_STATUS_TREATED = 1;

    /**
     * 课程预约状态组
     */
    public static final Map<Integer,String> COURSE_APPOINTMENT_STATUS_GROUP = new HashMap<>();

    static {

        COURSE_APPOINTMENT_STATUS_GROUP.put(COURSE_APPOINTMENT_STATUS_UNTREATED,"未处理");

        COURSE_APPOINTMENT_STATUS_GROUP.put(COURSE_APPOINTMENT_STATUS_TREATED,"已处理");

    }

    /**
     * 视频状态
     */
    //下架
    public static final Integer VIDOE_STATUS_XIAJIA = 0;
    //上架
    public static final Integer VIDOE_STATUS_SHANGJIA = 1;

    /**
     * 视频状态状态组
     */
    public static final Map<Integer,String> VIDOE_STATUS_GROUP = new HashMap<>();

    static {

        VIDOE_STATUS_GROUP.put(VIDOE_STATUS_XIAJIA,"下架");

        VIDOE_STATUS_GROUP.put(VIDOE_STATUS_SHANGJIA,"上架");

    }

    /**
     * 视频播放状态
     */
    //不能播放
    public static final Integer VIDOE_PLAY_STATUS_NOCAN = 0;
    //能播放
    public static final Integer VIDOE_PLAY_STATUS_CAN = 1;


}
