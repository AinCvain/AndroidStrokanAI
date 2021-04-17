package com.example.moneycontroll;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TargetFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TargetFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public TargetFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TargetFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TargetFragment newInstance(String param1, String param2) {
        TargetFragment fragment = new TargetFragment();
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
        return inflater.inflate(R.layout.fragment_target, container, false);
    }

    //******************************************//

    private TextView _tvMonth;
    private TextView _tvYear;

    private ImageButton _btnEditTheAmountToBeSaved;
    private ImageButton _btnEditTheAmountAtTheBeginningOfTheMonth;

    private TextView _tvAtTheBeginningOfTheMonth;
    private TextView _tvNeedToSave;
    private TextView _tvAllocatedForAMonth;
    private TextView _tvAllocatedForOneDay;
    private TextView _tvCurrentBalance;
    private EditText _etEditTheAmountAtTheBeginningOfTheMonth;
    private EditText _etEditTheAmountToBeSaved;
    @Override
    public void onStart() {
        super.onStart();

        _tvMonth = (TextView) getActivity().findViewById(R.id.tv_dynamic_Month);
        _tvYear = (TextView) getActivity().findViewById(R.id.tv_dynamic_Year);

        _etEditTheAmountAtTheBeginningOfTheMonth = (EditText) getActivity().findViewById(R.id.et_AtTheBeginningOfTheMonth);
        _etEditTheAmountAtTheBeginningOfTheMonth.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus == false)
                {
                    /*case R.id.btn_EditTheAmountToBeSaved:
                        Log.d("QQQQ","_btnEditTheAmountAtTheBeginningOfTheMonth");
                        _etEditTheAmountToBeSaved.setVisibility(View.INVISIBLE);
                        _tvNeedToSave.setText(_etEditTheAmountToBeSaved.getText());
                        _tvNeedToSave.setVisibility(View.VISIBLE);
                    break;*/

                    //case R.id.btn_EditTheAmountAtTheBeginningOfTheMonth:
                    Log.d("QQQQ","_btnEditTheAmountAtTheBeginningOfTheMonth");

                    _etEditTheAmountAtTheBeginningOfTheMonth.setVisibility(View.INVISIBLE);
                    _tvAtTheBeginningOfTheMonth.setText(_etEditTheAmountAtTheBeginningOfTheMonth.getText());
                    _tvAtTheBeginningOfTheMonth.setVisibility(View.VISIBLE);
                    //break;
                }
            }
        });

        _etEditTheAmountToBeSaved = (EditText) getActivity().findViewById(R.id.et_NeedToSave);
        _etEditTheAmountToBeSaved.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus == false)
                {

                        Log.d("QQQQ","_btnEditTheAmountAtTheBeginningOfTheMonth");
                        _etEditTheAmountToBeSaved.setVisibility(View.INVISIBLE);
                        _tvNeedToSave.setText(_etEditTheAmountToBeSaved.getText());
                        _tvNeedToSave.setVisibility(View.VISIBLE);


                    //case R.id.btn_EditTheAmountAtTheBeginningOfTheMonth:
                    /*Log.d("QQQQ","_btnEditTheAmountAtTheBeginningOfTheMonth");

                    _etEditTheAmountAtTheBeginningOfTheMonth.setVisibility(View.INVISIBLE);
                    _tvAtTheBeginningOfTheMonth.setText(_etEditTheAmountAtTheBeginningOfTheMonth.getText());
                    _tvAtTheBeginningOfTheMonth.setVisibility(View.VISIBLE);*/
                    //break;
                }
            }
        });

        _tvAtTheBeginningOfTheMonth = (TextView) getActivity().findViewById(R.id.tv_dynamic_AtTheBeginningOfTheMonth);
        _tvNeedToSave = (TextView) getActivity().findViewById(R.id.tv_dynamic_NeedToSave);
        _tvAllocatedForAMonth = (TextView) getActivity().findViewById(R.id.tv_dynamic_AllocatedForAMonth);
        _tvAllocatedForOneDay = (TextView) getActivity().findViewById(R.id.tv_dynamic_AllocatedForOneDay);
        _tvCurrentBalance = (TextView) getActivity().findViewById(R.id.tv_dynamic_CurrentBalance);

        _btnEditTheAmountToBeSaved = (ImageButton) getActivity().findViewById(R.id.btn_EditTheAmountToBeSaved);
        _btnEditTheAmountToBeSaved.setOnClickListener(v -> {
            Log.d("QQQQ","_btnEditTheAmountToBeSaved");
            _etEditTheAmountToBeSaved.setVisibility(View.VISIBLE);
            _etEditTheAmountToBeSaved.setText(_tvNeedToSave.getText());
            _tvNeedToSave.setVisibility(View.INVISIBLE);
        });

        _btnEditTheAmountAtTheBeginningOfTheMonth = (ImageButton) getActivity().findViewById(R.id.btn_EditTheAmountAtTheBeginningOfTheMonth);
        _btnEditTheAmountAtTheBeginningOfTheMonth.setOnClickListener(v -> {
            Log.d("QQQQ","_btnEditTheAmountAtTheBeginningOfTheMonth");

            _etEditTheAmountAtTheBeginningOfTheMonth.setVisibility(View.VISIBLE);
            _etEditTheAmountAtTheBeginningOfTheMonth.setText(_tvAtTheBeginningOfTheMonth.getText());
            _tvAtTheBeginningOfTheMonth.setVisibility(View.INVISIBLE);
        });

    }



    @Override
    public void onResume() {
        super.onResume();

        Log.d("QQQQQ", "onResume");

        // TODO: Заглушка, если логика готова - удалить!
        _tvMonth.setText("Январь");
        _tvYear.setText("2021");
        _tvAtTheBeginningOfTheMonth.setText("0 Р.");
        _tvNeedToSave.setText("0 Р.");
        _tvAllocatedForAMonth.setText("0 Р.");
        _tvAllocatedForOneDay.setText("0 Р.");
        _tvCurrentBalance.setText("0 Р.");
    }

}