package com.moyu.itemtouchhelperdemo;

/**
 * Created by 墨羽 on 2018/3/20.
 */

public interface OnDragVHListener {

    /**
     * Item被选中时触发
     */
    void onItemSelected();


    /**
     * Item在拖拽结束/滑动结束后触发
     */
    void onItemFinish();

}
