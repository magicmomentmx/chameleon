package com.zxy.skin.sdk.applicator;


import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.HashMap;

/**
 *
 * @Description: 换肤器管理中心
 * @author: zhaoxuyang
 * @Date: 2019/1/31
 */
public class SkinApplicatorManager {

    private static final String TAG = "SkinApplicatorManager";

    private static SkinViewApplicator defaultSkinApplicator = new SkinViewApplicator();

    private static HashMap<Class, SkinViewApplicator> applicatorsMap = new HashMap<>();

    static {

        SkinViewApplicator textViewSkinViewAdapter = new SkinTextViewApplicator();
        applicatorsMap.put(TextView.class, textViewSkinViewAdapter);
        applicatorsMap.put(Button.class, textViewSkinViewAdapter);

    }

    /**
     *  获取某个控件的换肤器
     * @param viewClass
     * @return
     */
    public static SkinViewApplicator getApplicator(Class<? extends View> viewClass) {
        SkinViewApplicator skinViewAdapter = applicatorsMap.get(viewClass);
        return skinViewAdapter == null ? defaultSkinApplicator : skinViewAdapter;
    }

    /**
     * 注册自定义的applicator
     * @param viewClass
     * @param applicator
     */
    public static void register(Class<? extends View> viewClass, SkinViewApplicator applicator){
        applicatorsMap.put(viewClass, applicator);
    }
}