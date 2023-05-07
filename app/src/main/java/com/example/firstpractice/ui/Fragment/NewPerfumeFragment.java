package com.example.firstpractice.ui.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.firstpractice.R;


public class NewPerfumeFragment extends Fragment {

    /*
        Fragment for adding a new perfume in Database.
        Initializing by clicking on a FAB in StoreFragment.
        Return a bundle with:
            - name of new perfume;
            - price of new perfume;
     */

    // *Key Replies*
    public static final String REPLY_PERFUME = "REPLY_PERFUME";
    public static final String REPLY_NAME = "REPLY_NAME_PERFUME";
    public static final String REPLY_PRICE = "REPLY_PRICE_PERFUME";

    private EditText mEditPerfumeNameView;  // Input a new perfume's name
    private EditText mEditPerfumePriceView; // Input a new perfume's price

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_new_perfume, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Initialize EditTexts
        mEditPerfumeNameView = view.findViewById(R.id.edit_perfume_name);
        mEditPerfumePriceView = view.findViewById(R.id.edit_perfume_price);

        // Button Save new perfume
        final Button button = view.findViewById(R.id.button_save_perfume);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle result = new Bundle();

                // Get String & int from EditTexts
                String resultNamePerfume = mEditPerfumeNameView.getText().toString();
                int price = Integer.parseInt(mEditPerfumePriceView.getText().toString());

                // Put in bundle name & price of new perfume
                result.putString(REPLY_NAME, resultNamePerfume);
                result.putInt(REPLY_PRICE, price);

                // Put bundle in FragmentResult
                getParentFragmentManager().setFragmentResult(REPLY_PERFUME, result);

                // Navigate to StoreFragment
                Navigation.findNavController(view).navigate(R.id.action_newPerfumeFragment_to_storeFragment);
            }
        });

    }
}