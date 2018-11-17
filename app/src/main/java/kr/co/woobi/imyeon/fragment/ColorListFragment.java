package kr.co.woobi.imyeon.fragment;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.Arrays;
import java.util.List;

public class ColorListFragment extends ListFragment {

    private onColorSelectedListener mListener;

    interface  onColorSelectedListener{
        void  onColorSelcted(int color);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try{
            mListener=(onColorSelectedListener)context;
        }catch (ClassCastException e){
            throw new ClassCastException(((Activity)context).getLocalClassName()+ "는 onColorSelectedListender를 구현해야 합니다.");
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        List<String> colorList= Arrays.asList("RED","GREEN", "BLEU");
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,colorList);
        setListAdapter(adapter);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        ArrayAdapter<String> adapter = (ArrayAdapter<String>) l.getAdapter();
        String colorString = adapter.getItem(position);
        int color = Color.RED;

        switch (colorString){
            case "RED":
                color=Color.RED;
                break;
            case "GREEN":
                color=Color.GREEN;
                break;
            case "BLUE":
                color=Color.BLUE;
                break;
        }
        if(mListener!=null){
            mListener.onColorSelcted(color);
        }
    }
}
