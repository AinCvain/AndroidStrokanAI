package com.example.moneycontroll;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;

import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DiaryFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DiaryFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public DiaryFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DiaryFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DiaryFragment newInstance(String param1, String param2) {
        DiaryFragment fragment = new DiaryFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_diary, container, false);
    }

    private TextView _tvNowDate;
    private TextView _tvSpentToday;
    private TextView _tvAvailableToday;

    private ImageButton _btnAddNewPurchase;
    private boolean _isAddMewPurchaseMode;

    private LinearLayout _shoppingList;

    @Override
    public void onStart() {
        super.onStart();

        _tvNowDate = (TextView) getActivity().findViewById(R.id.tv_dynamic_NowDate);
        _tvSpentToday = (TextView) getActivity().findViewById(R.id.tv_dynamic_SpentToday);
        _tvAvailableToday = (TextView) getActivity().findViewById(R.id.tv_dynamic_AvailableToday);

        _isAddMewPurchaseMode = false;
        _btnAddNewPurchase = (ImageButton) getActivity().findViewById(R.id.btn_AddNewPurchase);

        _btnAddNewPurchase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ImageView imgAddNewPurchase = getActivity().findViewById(R.id.img_AddNewPurchase);
                LinearLayout llAddNewPurchase = getActivity().findViewById(R.id.ll_AddNewPurchase);

                Animation animationForImgAddNewPurchase;
                Animation animationForLlAddNewPurchase;

                if(!_isAddMewPurchaseMode) {
                    animationForImgAddNewPurchase = AnimationUtils.loadAnimation(getContext(), R.anim.animation_of_the_add_purchase_button);
                    animationForLlAddNewPurchase = new Animation() {

                        @Override
                        protected void applyTransformation(float interpolatedTime, Transformation t) {
                            super.applyTransformation(interpolatedTime, t);
                            llAddNewPurchase.getLayoutParams().height = (int) (interpolatedTime * 152);
                            llAddNewPurchase.requestLayout();
                        }

                        @Override
                        public boolean willChangeBounds() {
                            return true;
                        }
                    };
                    _isAddMewPurchaseMode = true;
                }else{
                    animationForImgAddNewPurchase = AnimationUtils.loadAnimation(getContext(), R.anim.animation_reverse_of_the_add_purchase_button);
                    animationForLlAddNewPurchase = new Animation() {

                        @Override
                        protected void applyTransformation(float interpolatedTime, Transformation t) {
                            super.applyTransformation(interpolatedTime, t);
                            Log.d("QWE", Float.toString(interpolatedTime));
                            llAddNewPurchase.getLayoutParams().height = (int) ((1-interpolatedTime) * 152);
                            llAddNewPurchase.requestLayout();
                        }

                        @Override
                        public boolean willChangeBounds() {
                            return true;
                        }
                    };


                    InputMethodManager inputManager =
                            (InputMethodManager) getContext().
                                    getSystemService(Context.INPUT_METHOD_SERVICE);
                    inputManager.hideSoftInputFromWindow(
                            getActivity().getCurrentFocus().getWindowToken(),
                            InputMethodManager.HIDE_NOT_ALWAYS);
                    _isAddMewPurchaseMode = false;
                }

                animationForLlAddNewPurchase.setDuration(500);

                imgAddNewPurchase.startAnimation(animationForImgAddNewPurchase);
                llAddNewPurchase.startAnimation(animationForLlAddNewPurchase);

            }
        });

        _shoppingList = (LinearLayout) getActivity().findViewById(R.id.ll_ShoppingList);
    }

    @Override
    public void onResume() {
        super.onResume();

        Log.d("QQQQQ", "onResume");

        // TODO: Заглушка, если логика готова - удалить!
        _tvNowDate.setText("01.01.2021");
        _tvSpentToday.setText("0 Р.");
        _tvAvailableToday.setText("0 Р.");

        for(int i = 0 ; i < 10; i++){
            LinearLayout newRow = new LinearLayout(getContext());

            newRow.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    
                    return true;
                }
            });
            _shoppingList.addView(newRow);

            LinearLayout.LayoutParams aasd = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            aasd.weight = 6;

            TextView newPurchaseName = new TextView(getContext());
            newPurchaseName.setText("Hello1");
            newPurchaseName.setTextSize(22);
            newPurchaseName.setLayoutParams(aasd);
            newPurchaseName.setGravity(Gravity.LEFT);

            newRow.addView(newPurchaseName);

            TextView newPurchasePrice = new TextView(getContext());
            newPurchasePrice.setText("234 р.");
            newPurchasePrice.setTextSize(22);
            newPurchasePrice.setGravity(Gravity.RIGHT);
            newRow.addView(newPurchasePrice);

            ImageView line = new ImageView(getContext());
            line.setImageResource(R.drawable.top_line);
            _shoppingList.addView(line);

        }
        //_shoppingList.addView(newPurchase);
        //_shoppingList.addView(newPurchase);
        //_shoppingList.addView(newPurchase);
    }


}