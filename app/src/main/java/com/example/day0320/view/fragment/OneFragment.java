package com.example.day0320.view.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.day0320.R;
import com.example.day0320.model.DataBean;
import com.example.day0320.model.JsenBean;
import com.example.day0320.presenter.MainPresenter;
import com.example.day0320.presenter.ShouPresenter;
import com.example.day0320.view.activity.SouView;
import com.example.day0320.view.adapter.MlssAdapter;
import com.example.day0320.view.adapter.PzshAdapter;
import com.example.day0320.view.adapter.RxxpAdapter;
import com.example.day0320.view.adapter.SouAdapter;
import com.example.day0320.view.interfaces.IMainView;

import java.util.List;

/**
 * @Auther: 白俊岭
 * @Date: 2019/3/23 09:18:52
 * @Description:
 */
public class OneFragment extends Fragment implements IMainView {
    private RecyclerView rxxp;
    private RecyclerView mlss;
    private RecyclerView pzsh;
    private RecyclerView sou;


    private List<JsenBean.ResultBean.RxxpBean.CommodityListBean> commodityList;

    private RxxpAdapter rxxpAdapter;
    private List<JsenBean.ResultBean.MlssBean.CommodityListBeanXX> mlss1;
    private MlssAdapter mlssAdapter;
    private List<JsenBean.ResultBean.PzshBean.CommodityListBeanX> pzss1;
    private PzshAdapter pzshAdapter;
    private MainPresenter mainPresenter;
    private View view;
    private LinearLayoutManager linearLayout;
    private LinearLayoutManager linearLayoutManager;
    private LinearLayoutManager linear;
    private LinearLayoutManager lin;
    private ShouPresenter shouPresenter;
            int page=1;
            int count=10;
    private EditText sech_cont_id1;
    private TextView ser;
    private SouView flowtLayout_1_id;
    private String name;
    private LinearLayout one;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
      view = inflater.inflate(R.layout.onefragment, container, false);

          initView();
        initData();
        return this.view;
    }

    private void initView() {
        ser = view.findViewById(R.id.sech_id);
        rxxp = view.findViewById(R.id.rxxp);
        one = view.findViewById(R.id.one);

        linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(OrientationHelper.VERTICAL);
        rxxp.setLayoutManager(linearLayoutManager);

        mlss = view.findViewById(R.id.mlss);
        linearLayout = new LinearLayoutManager(getActivity());
        linearLayout.setOrientation(OrientationHelper.VERTICAL);
        mlss.setLayoutManager(linearLayout);

        pzsh = view.findViewById(R.id.pzsh);
        linear = new LinearLayoutManager(getActivity());
        linear.setOrientation(OrientationHelper.VERTICAL);
        pzsh.setLayoutManager(linear);

        sech_cont_id1 = view.findViewById(R.id.sech_cont_id);

        flowtLayout_1_id = view.findViewById(R.id.FlowtLayout_1_id);

        sou = view.findViewById(R.id.sou);
        lin = new LinearLayoutManager(getActivity());
        lin.setOrientation(OrientationHelper.VERTICAL);
        sou.setLayoutManager(lin);


    }

    private void initData() {
        mainPresenter = new MainPresenter(this);
        mainPresenter.getShowData();
        mainPresenter.setView(this);
        shouPresenter = new ShouPresenter(this);

        shouPresenter.setView(this);

        ser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sou.setVisibility(View.VISIBLE);
                one.setVisibility(View.GONE);
                name = sech_cont_id1.getText().toString();
                final TextView textView = new TextView(getActivity());
                 textView.setTag(name);
                textView.setText(name);
                flowtLayout_1_id.addView(textView);

                flowtLayout_1_id.requestLayout();

                shouPresenter.ShowData(name,page,count);

            }
        });
    }





    @Override
    public void onSuccess(Object o) {
        if(o instanceof JsenBean)
        {
            JsenBean jsenBean =(JsenBean ) o;

            commodityList = jsenBean.getResult().getRxxp().getCommodityList();
            rxxpAdapter = new RxxpAdapter(getActivity(),this.commodityList);
            rxxp.setAdapter(rxxpAdapter);

            mlss1 = jsenBean.getResult().getMlss().getCommodityList();
            mlssAdapter = new MlssAdapter(getActivity(),this.mlss1);
            mlss.setAdapter(mlssAdapter);

            pzss1 = jsenBean.getResult().getPzsh().getCommodityList();
            pzshAdapter = new PzshAdapter(getActivity(),this.pzss1);
            pzsh.setAdapter(pzshAdapter);
        }

        if(o instanceof DataBean)
        {
            DataBean dataBean =(DataBean)o;
            List<DataBean.ResultBean> list = dataBean.getResult();
            SouAdapter souAdapter = new SouAdapter(getActivity(),list);
            sou.setAdapter(souAdapter);
        }
    }


    @Override
    public void onFail(String err) {

    }
}
