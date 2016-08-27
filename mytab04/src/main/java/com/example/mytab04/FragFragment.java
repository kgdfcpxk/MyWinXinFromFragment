package com.example.mytab04;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragFragment extends Fragment {

    private String mPos;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.frag, container, false);
        TextView textView = (TextView) inflate.findViewById(R.id.id_tv_frag_text);
        mPos = getArguments().getString("pos");
        textView.setText(TabAdapter.TITLES[Integer.parseInt(mPos)]);
        return inflate;
    }

}
