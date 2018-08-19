package com.example.piastres.pizzaapp.adapter;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.piastres.pizzaapp.R;
import com.example.piastres.pizzaapp.activity.MenuActivity;
import com.example.piastres.pizzaapp.activity.FragmentPage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;


//public class SwipeLayoutAdapter extends FragmentStatePagerAdapter {
//    Context context;
//    LayoutInflater layoutInflater;
//
//
//    public SwipeLayoutAdapter(FragmentManager fragmentManager) {
//        super(fragmentManager);
//    }
//
//
//
//
//    @Override
//    public Fragment getItem(int position) {
//        Logger log = LoggerFactory.getLogger(SwipeLayoutAdapter.class);
//        log.info("INFO: ======================== ADAPTER   ");
//        Fragment fragment = new FragmentPage();
//        Bundle bundle = new Bundle();
//        bundle.putInt("pageNumber", position);
//        Bundle bundle1 = new Bundle();
//        String url = "load img url";
//        bundle1.putString("url", url);
//        fragment.setArguments(bundle);
//        //fragment.setArguments(bundle1);
//        return fragment;
//    }
//
//    @Override
//    public int getCount() {
//        int count = MenuActivity.allCategory.size();
//        return count;
//    }
//
//    public int[] imgArray ={
//            R.drawable.ic_pizza2,
//            R.drawable.ic_set,
//            R.drawable.ic_pasta,
//            R.drawable.ic_burger,
//            R.drawable.ic_snacks,
//            R.drawable.ic_desser,
//            R.drawable.ic_drink
//};
//}

public class SwipeLayoutAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;
    TextView[] progressArray;

    public SwipeLayoutAdapter(Context context){
        this.context = context;
    }

    public int[] imgArray ={
            R.drawable.ic_pizza,
            R.drawable.ic_set,
            R.drawable.ic_pasta,
            R.drawable.ic_burger,
            R.drawable.ic_snacks,
            R.drawable.ic_dessert,
            R.drawable.ic_drink
};
    public String[] descArray = {
            "Настоящая итальянская  пицца с неповторимым ароматом, сочной зеленью и разнообразной начинкой",
            "Идеальным дополнением к бокалу холодного пива станет наш фирменный сет",
            "Предлагаем попробовать фирменную пасту. Изысканная простота в сочетании с пикантными соусами придает  блюдам особое очарование",
            "Необычное сочетание вкусов, которое запомнится вам навсегда",
            "Закуски прекрасно дополняют любое меню и добавляют вкусное разнообразие",
            "Восхитительно нежные десерты от нашего шеф-повара",
            "Каждое блюдо заслуживает своего напитка, поэтому вы без труда подберете свое идеальное дополнение"
    };

    @Override
    public int getCount() {
        int count = MenuActivity.allCategory.size();
        return count;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (View) object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position){
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.page_fragment_layout, container, false);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.progressLayout);
        progressArray = new TextView[imgArray.length];
        for (int i=0; i< progressArray.length; i++){
            progressArray[i] = new TextView(context);
            progressArray[i].setText(Html.fromHtml("&#8226;"));
            progressArray[i].setTextSize(35);
            if (i==position){progressArray[i].setTextColor(context.getResources().getColor(R.color.colorBackround));}
            else {progressArray[i].setTextColor(context.getResources().getColor(R.color.colorMainTitle));}

            linearLayout.addView(progressArray[i]);
        }
        ImageView imageView = (ImageView) view.findViewById(R.id.imgView);
        ImageView imageBack = (ImageView) view.findViewById(R.id.imageView);
        ImageView imgRight = (ImageView) view.findViewById(R.id.iconRight);
        ImageView imgLeft = (ImageView) view.findViewById(R.id.iconLeft);
        imageBack.setImageResource(R.drawable.ic_back);
        switch (position){
            case 0:
                imgLeft.setImageResource(R.drawable.ic_left);

                break;
            case 6:
                imgRight.setImageResource(R.drawable.ic_right);
                break;
            default:
                    imgLeft.setImageResource(R.drawable.ic_left);
                    imgRight.setImageResource(R.drawable.ic_right);
                    break;

        }
        TextView catDesc = (TextView) view.findViewById(R.id.categoryDesc);
        TextView textView = (TextView) view.findViewById(R.id.pageNumber);
        catDesc.setText(descArray[position]);
        textView.setText((MenuActivity.allCategory.get(position)).toString());
        imageView.setImageResource(imgArray[position]);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}