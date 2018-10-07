package com.moyu.videoplaydemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xiao.nicevideoplayer.TxVideoPlayerController;

import java.util.List;

/**
 * Created by 墨羽 on 2018/3/19.
 */

public class VideoAdapter extends RecyclerView.Adapter<VideoViewHolder> {

    private List<Video> mVideoList;
    private Context mContext;

    public VideoAdapter(Context mContext,List<Video> mVideoList) {
        this.mVideoList = mVideoList;
        this.mContext = mContext;
    }

    @Override
    public VideoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.item_video, parent, false);
        VideoViewHolder holder = new VideoViewHolder(itemView);
        TxVideoPlayerController controller = new TxVideoPlayerController(mContext);
        holder.setController(controller);
        return holder;
    }

    @Override
    public void onBindViewHolder(VideoViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return mVideoList != null ? mVideoList.size() : 0;
    }




}
