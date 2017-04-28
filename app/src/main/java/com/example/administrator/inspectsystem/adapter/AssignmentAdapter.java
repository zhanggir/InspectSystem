package com.example.administrator.inspectsystem.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.inspectsystem.R;
import com.example.administrator.inspectsystem.net.entity.MainInspect;

import java.util.List;


/**
 * Created by Administrator on 2017/4/26.
 * 巡查系统主界面适配器
 */

public class AssignmentAdapter extends BaseAdapter {
    Context mContext;
    //数据
    List<MainInspect> mDatas;

    public AssignmentAdapter(Context mContext, List<MainInspect> mDatas) {
        this.mContext = mContext;
        this.mDatas = mDatas;
    }

    @Override
    public int getCount() {
        return mDatas.size()==0?0:mDatas.size();
    }

    @Override
    public Object getItem(int position) {
        return mDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
ViewHolder mViewHolder;
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
      mViewHolder=new ViewHolder();
        if(convertView==null){
            convertView= LayoutInflater.from(mContext).inflate(R.layout.item_inspect_main,null);
            mViewHolder.mImageView= (ImageView) convertView.findViewById(R.id.img_inspect_main);
       mViewHolder.txtArea= (TextView) convertView.findViewById(R.id.txt_inspect_main_area);
       mViewHolder.txtAssign= (TextView) convertView.findViewById(R.id.txt_inspect_assign);
       mViewHolder.txtInstrument= (TextView) convertView.findViewById(R.id.txt_inspect_instrument);
       mViewHolder.txtPrincipal= (TextView) convertView.findViewById(R.id.txt_inspect_principal);
       mViewHolder.txtDatatime= (TextView) convertView.findViewById(R.id.txt_inspect_datatime);
            convertView.setTag(mViewHolder);
        }else{
            mViewHolder= (ViewHolder) convertView.getTag();
        }
        mViewHolder.mImageView.setImageResource(R.mipmap.ic_launcher);
        mViewHolder.txtArea.setText(mDatas.get(position).area);
        mViewHolder.txtAssign.setText(mDatas.get(position).assign);
       // mViewHolder.txtInstrument.setText(mDatas.get(position).);
        mViewHolder.txtPrincipal.setText(mDatas.get(position).name);
        mViewHolder.txtDatatime.setText(mDatas.get(position).datatime);
        return convertView;
    }
    class ViewHolder{
        //巡查任务图片
        ImageView mImageView;
        //巡查任务地段
        TextView txtArea;
        //任务
        TextView txtAssign;
        //说明
        TextView txtInstrument;
        //负责人
        TextView txtPrincipal;
        //巡查日期
        TextView txtDatatime;

    }
}
