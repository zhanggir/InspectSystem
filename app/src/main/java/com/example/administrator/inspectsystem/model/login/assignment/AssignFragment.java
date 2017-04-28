package com.example.administrator.inspectsystem.model.login.assignment;

import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.administrator.inspectsystem.R;
import com.example.administrator.inspectsystem.adapter.AssignmentAdapter;
import com.example.administrator.inspectsystem.base.BaseFragment;
import com.example.administrator.inspectsystem.net.entity.MainInspect;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by Administrator on 2017/4/27.
 */

public class AssignFragment extends BaseFragment {
    @BindView(R.id.lst_inspect_main)
    ListView mLstInspectMain;
    List<MainInspect> mDatas;
    FragmentTransaction transaction;
    AssignDetailFragment assignDetailFragment;
    @Override
    protected void initView() {
        mLstInspectMain.setFocusable(false);
        mDatas=new ArrayList<>();
        for(int i=0;i<50;i++){
            MainInspect inspect=new MainInspect("高新"+i+"区巡查任务","执行中","王"+i,"2017-01-"+i);
            mDatas.add(inspect);
        }
        AssignmentAdapter adapter=new AssignmentAdapter(getActivity(),mDatas);
       mLstInspectMain.setAdapter(adapter);
        initEvent();
    }

    @Override
    protected int getContentLayout() {
        return R.layout.fragment_assign;
    }
    private void initEvent() {
        mLstInspectMain.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity(),"高新"+position+"区巡检点",Toast.LENGTH_SHORT).show();
                 transaction = getFragmentManager().beginTransaction();
                 assignDetailFragment = new AssignDetailFragment();
                transaction.replace(R.id.viewpager_main,assignDetailFragment);
                transaction.commit();
                transaction.show(assignDetailFragment);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

    }
}
