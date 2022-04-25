package com.apporio.demotaxiappdriver.wallet;


import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.apporio.demotaxiappdriver.R;
import com.apporio.demotaxiappdriver.baseClass.BaseFragment;
import com.apporio.demotaxiappdriver.models.ModelWalletTransactionsResponse;
import com.sam.placer.PlaceHolderView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class WalletTransactionFragment extends BaseFragment {


  //  @Bind(R.id.place_holder_wallet)
    PlaceHolderView mPlaceHolder;

   // List<TemporaryWalletModel> modelList;
    ModelWalletTransactionsResponse model;

    public WalletTransactionFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_wallet_transaction, container, false);

        mPlaceHolder = view.findViewById(R.id.place_holder_wallet);

       // modelList = provideList();

        getArguments().getString("msg");
        model = (ModelWalletTransactionsResponse) getArguments().getSerializable("model");

        if (getArguments().getString("msg").equalsIgnoreCase("instance_one")){
            for (int i = 0;i<model.getTransactions().size();i++){
                mPlaceHolder.addView(new HolderWalletTransactions(model.getTransactions().get(i),getContext()));
            }
        }
        if (getArguments().getString("msg").equalsIgnoreCase("instance_two")) {
            for (int i= 0 ; i<model.getTransactions().size() ; i++){
                if (model.getTransactions().get(i).getTransaction_type().equalsIgnoreCase("Credit")){
                    mPlaceHolder.addView(new HolderWalletTransactions(model.getTransactions().get(i),getContext()));
                }
            }
        }
        if (getArguments().getString("msg").equalsIgnoreCase("instance_three")){
            for (int i= 0 ; i<model.getTransactions().size() ; i++){
                if (model.getTransactions().get(i).getTransaction_type().equalsIgnoreCase("Debit")){
                    mPlaceHolder.addView(new HolderWalletTransactions(model.getTransactions().get(i),getContext()));
                }
            }
        }



        ButterKnife.bind(this, view);
        return view;
    }



    public static WalletTransactionFragment newInstance(String text, ModelWalletTransactionsResponse model) {
        WalletTransactionFragment f = new WalletTransactionFragment();
        Bundle b = new Bundle();
        b.putString("msg", text);
        b.putSerializable("model",model);
        f.setArguments(b);
        return f;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    public List<TemporaryWalletModel> provideList(){

        List<TemporaryWalletModel> list = new ArrayList<>();

        TemporaryWalletModel model = new TemporaryWalletModel();
        model.setTitle("Amount added in wallet by admin.");
        model.setAmount("Rs. 1000");
        model.setTransaction_type(1);
        model.setRide_id("");
        list.add(model);

        model = new TemporaryWalletModel();
        model.setTransaction_type(2);
        model.setTitle("Ride commission Amount deducted");
        model.setAmount("Rs. 40");
        model.setRide_id("Ride Id: 112211");
        list.add(model);

        model = new TemporaryWalletModel();
        model.setTransaction_type(2);
        model.setTitle("Ride commission Amount deducted");
        model.setAmount("Rs. 80");
        model.setRide_id("Ride Id: 213311");
        list.add(model);

        model = new TemporaryWalletModel();
        model.setTransaction_type(1);
        model.setTitle("Amount added in wallet by admin");
        model.setAmount("Rs. 1500");
        model.setRide_id("");
        list.add(model);

        model = new TemporaryWalletModel();
        model.setTransaction_type(2);
        model.setTitle("Monthly Charge deducted");
        model.setAmount("Rs. 100");
        model.setRide_id("");
        list.add(model);

        model = new TemporaryWalletModel();
        model.setTransaction_type(1);
        model.setTitle("Amount added in wallet by admin");
        model.setAmount("Rs. 1500");
        model.setRide_id("");
        list.add(model);

        model = new TemporaryWalletModel();
        model.setTransaction_type(2);
        model.setTitle("Ride commission Amount deducted");
        model.setAmount("Rs. 80");
        model.setRide_id("Ride Id: 213311");
        list.add(model);

        model = new TemporaryWalletModel();
        model.setTransaction_type(1);
        model.setTitle("Amount added in wallet by admin");
        model.setAmount("Rs. 1500");
        model.setRide_id("");
        list.add(model);

        model = new TemporaryWalletModel();
        model.setTransaction_type(2);
        model.setTitle("Ride commission Amount deducted");
        model.setAmount("Rs. 80");
        model.setRide_id("Ride Id: 213311");
        list.add(model);

        model = new TemporaryWalletModel();
        model.setTransaction_type(1);
        model.setTitle("Amount added in wallet by admin");
        model.setAmount("Rs. 1500");
        model.setRide_id("");
        list.add(model);

        model = new TemporaryWalletModel();
        model.setTransaction_type(2);
        model.setTitle("Ride commission Amount deducted");
        model.setAmount("Rs. 80");
        model.setRide_id("Ride Id: 213311");
        list.add(model);

        model = new TemporaryWalletModel();
        model.setTransaction_type(1);
        model.setTitle("Amount added in wallet by admin");
        model.setAmount("Rs. 1500");
        model.setRide_id("");
        list.add(model);

        model = new TemporaryWalletModel();
        model.setTransaction_type(2);
        model.setTitle("Ride commission Amount deducted");
        model.setAmount("Rs. 80");
        model.setRide_id("Ride Id: 213311");
        list.add(model);

        return list;
    }
}
