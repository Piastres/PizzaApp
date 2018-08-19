package com.example.piastres.pizzaapp.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.piastres.pizzaapp.R;
import com.example.piastres.pizzaapp.activity.MenuActivity;
import com.example.piastres.pizzaapp.adapter.SwipeLayoutAdapter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.List;

public class FragmentPage extends Fragment {
    ImageView imageView;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view;
        Bundle bundle = getArguments();
        int pageNumber = bundle.getInt("pageNumber");
        view = inflater.inflate(R.layout.page_fragment_layout, container, false);
        TextView textView = (TextView) view.findViewById(R.id.pageNumber);
        //textView.setText(Integer.toString(pageNumber));
//        String path = "C:\\Users\\Piastres\\AndroidStudioProjects\\PizzaApp\\app\\src\\main\\res\\drawable\\ic_burger.jpg";
        //imageView = (ImageView) view.findViewById(R.id.imgView);
//        Glide.with(this)
//                .load("C:\\Users\\Piastres\\AndroidStudioProjects\\PizzaApp\\app\\src\\main\\res\\drawable\\ic_burger.jpg") // Uri of the picture
//                //.load(new File(str.getPath())) // Uri of the picture
//                .into(imageView);

        textView.setText((MenuActivity.allCategory.get(pageNumber)).toString());
        //return super.onCreateView(inflater, container, savedInstanceState);
        return view;
    }
}
