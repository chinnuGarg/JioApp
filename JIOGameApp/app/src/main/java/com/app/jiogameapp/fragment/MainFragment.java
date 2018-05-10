package com.app.jiogameapp.fragment;


import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.app.jiogameapp.R;
import com.app.jiogameapp.adapter.AdapterView;
import com.app.jiogameapp.adapter.CardAdapter;
import com.app.jiogameapp.model.DataVal;
import com.app.jiogameapp.utils.Common;
import com.yarolegovich.discretescrollview.DSVOrientation;
import com.yarolegovich.discretescrollview.DiscreteScrollView;
import com.yarolegovich.discretescrollview.InfiniteScrollAdapter;
import com.yarolegovich.discretescrollview.transform.ScaleTransformer;

import java.util.ArrayList;

public class MainFragment extends Fragment {
    DiscreteScrollView discretescrollview;
    RecyclerView recycler_view1,recycler_view2,recycler_view3;
    View include_1,include_2,include_3;
    BottomSheetBehavior sheetBehavior;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.activity_main, container, false);
        id(view);
        setAdapter();
        onClick();
        return view;
    }
    public void id(View view){
        // DiscreteScrollView Code
        discretescrollview = (DiscreteScrollView)view.findViewById(R.id.discretescrollview);
        include_1 = (View) view.findViewById(R.id.include_1);
        recycler_view1 = (RecyclerView) include_1.findViewById(R.id.recycler_view);
        include_2 = (View) view.findViewById(R.id.include_2);
        recycler_view2 = (RecyclerView) include_2.findViewById(R.id.recycler_view);
        include_3 = (View) view.findViewById(R.id.include_3);
        recycler_view3 = (RecyclerView) include_3.findViewById(R.id.recycler_view);
        RelativeLayout include_view=view.findViewById(R.id.bottomView);
        sheetBehavior = BottomSheetBehavior.from(include_view);
        include_view.setVisibility(View.GONE);
        //=-----------------------------------------------------------------------------
        discretescrollview.setOrientation(DSVOrientation.HORIZONTAL);



    }
    public void onClick(){
        sheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                switch (newState) {
                    case BottomSheetBehavior.STATE_HIDDEN:
                        break;
                    case BottomSheetBehavior.STATE_EXPANDED: {
                       // bottom_layout.setText("Close Sheet");
                    }
                    break;
                    case BottomSheetBehavior.STATE_COLLAPSED: {
                       // btnBottomSheet.setText("Expand Sheet");
                    }
                    break;
                    case BottomSheetBehavior.STATE_DRAGGING:
                        break;
                    case BottomSheetBehavior.STATE_SETTLING:
                        break;
                }
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {

            }
        });
        discretescrollview.addOnItemChangedListener(new DiscreteScrollView.OnItemChangedListener<RecyclerView.ViewHolder>() {
            @Override
            public void onCurrentItemChanged(@Nullable RecyclerView.ViewHolder viewHolder, int adapterPosition) {
            }
        });
    }
    public void setAdapter(){
        //---------------------for top layer
        InfiniteScrollAdapter  infiniteAdapter = InfiniteScrollAdapter.wrap(new CardAdapter(Common.arr_images));
        discretescrollview.setAdapter(infiniteAdapter);
        discretescrollview.setMinimumHeight(10);
        discretescrollview.setItemTransformer(new ScaleTransformer.Builder().setMinScale(0.80f).build());

        //--------------------for adapter 1
        ArrayList<DataVal> modelData=Common.ListOneData();
        AdapterView mAdapter = new AdapterView(modelData,getActivity());
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        recycler_view1.setLayoutManager(mLayoutManager);
        recycler_view1.setItemAnimator(new DefaultItemAnimator());
        recycler_view1.setAdapter(mAdapter);

       //--------------------for adapter 2
        ArrayList<DataVal> modelData1=Common.ListTwoData();
        AdapterView mAdapter1 = new AdapterView(modelData1,getActivity());
        mLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        recycler_view2.setLayoutManager(mLayoutManager);
        recycler_view2.setItemAnimator(new DefaultItemAnimator());
        recycler_view2.setAdapter(mAdapter1);

       //--------------------for adapter 3
        ArrayList<DataVal> modelData2=Common.ListThreeData();
        AdapterView mAdapter2 = new AdapterView(modelData2,getActivity());
        mLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        recycler_view3.setLayoutManager(mLayoutManager);
        recycler_view3.setItemAnimator(new DefaultItemAnimator());
        recycler_view3.setAdapter(mAdapter2);
    }




}
