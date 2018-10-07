package com.moyu.ijkplayerdemo;

import java.io.Serializable;
import java.util.List;

/**
 * Created by 墨羽 on 2018/3/30.
 */

public class VideoListData implements Serializable {

    private List<VideoItemData> list;

    public List<VideoItemData> getList() {
        return list;
    }

    public void setList(List<VideoItemData> list) {
        this.list = list;
    }

}
