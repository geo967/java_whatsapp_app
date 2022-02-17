package com.example.mywhatsapp.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mywhatsapp.Model.ModelItem;
import com.example.mywhatsapp.Network.RetrofitCall;
import com.example.mywhatsapp.R;
import com.example.mywhatsapp.adapter.RecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Chats#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Chats extends Fragment {
    RecyclerView recyclerView;
    RecyclerViewAdapter recyclerViewAdapter;

    public static List<ModelItem> list=new ArrayList<>();

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Chats() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BlankFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Chats newInstance(String param1, String param2) {
        Chats fragment = new Chats();
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
        View view= inflater.inflate(R.layout.fragment_chats, container, false);

        recyclerView=view.findViewById(R.id.recyclerview_id_fragment_chats);
        RetrofitCall.getDataFromApi();

        list.add(new ModelItem(12,12,"wrer",false));
        recyclerView.setHasFixedSize(true);
        Log.d("this is after recyclerView.setHasFixedSize(true);","recyclerView.setHasFixedSize(true);");
        LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext());
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        Log.d("this is after layoutManager.setOrientation(RecyclerView.VERTICAL);","layoutManager.setOrientation(RecyclerView.VERTICAL);");
        recyclerView.setLayoutManager(layoutManager);
        Log.d("this is after setlayout manager","recyclerView.setLayoutManager(layoutManager);");
        recyclerViewAdapter = new RecyclerViewAdapter(view.getContext(), list);
        recyclerView.setAdapter(recyclerViewAdapter);
        Log.d("this is after  recyclerView.setAdapter(recyclerViewAdapter);"," recyclerView.setAdapter(recyclerViewAdapter);");

        return view;
    }
}