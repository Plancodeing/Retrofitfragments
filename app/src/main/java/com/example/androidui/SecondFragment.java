package com.example.androidui;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class SecondFragment extends Fragment {
    Context context;


ArrayList<Data> employeelist = new ArrayList<Data>();
    TextView t1, t2, t3, t4;
    RecyclerView rv;
    ProgressBar progress,pr2;
    Button send,sbmt;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootView = inflater.inflate(R.layout.fragment_second, container, false);
        t1 = rootView.findViewById(R.id.t1);
        t2 = rootView.findViewById(R.id.t2);
        rv = rootView.findViewById(R.id.rv);
        t3 = rootView.findViewById(R.id.t3);
        t4 = rootView.findViewById(R.id.t4);
        sbmt = rootView.findViewById(R.id.sbmt);

        send = rootView.findViewById(R.id.send);
        progress = rootView.findViewById(R.id.progress);
        progress.setVisibility(View.VISIBLE);
        name();
        man();


        return rootView;
        }

    private void man() {


        Api cl = client2.getclient().create(Api.class);
        Call<ArrayList<Data>> call = cl.getDataa();
        call.enqueue(new Callback<ArrayList<Data>>() {
            @Override
            public void onResponse(Call<ArrayList<Data>> call, Response<ArrayList<Data>> response) {
                rv.addOnItemTouchListener(new RecyclerItemClickListener(getContext(), rv, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {

//here you are getting the selected position object/data
                        Object object = employeelist.get(position).getTitle();
                        sbmt.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Bundle bunndle = new Bundle();
                                bunndle.putString("keey",object.toString());

                                FourFragment2 blankFrangment = new FourFragment2();
                                blankFrangment.setArguments(bunndle);
                                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,blankFrangment).commit();


                            }
                        });

// you can navigate to next screen then

                    }

                    @Override
                    public void onLongItemClick(View view, int position) {

                    }
                }))

                ;
                Log.d("coder", response.code()+"");
                if(response.body()!= null) {


                    employeelist =  response.body();




                    setAdapter(employeelist);
                }

            }

            @Override
            public void onFailure(Call<ArrayList<Data>> call, Throwable t) {

                Log.d("coder", t.toString()+"");
            }
        });

    }


    private void name() {


        Api cl = Client.getclient().create(Api.class);
        Call<Data> call = cl.getData();
        call.enqueue(new Callback<Data>() {
            @Override
            public void onResponse(Call<Data> call, Response<Data> response) {
                progress.setVisibility(View.GONE);
                Log.d("status",response.code()+"");
                Data emp = response.body();
                Log.d("ids", emp.getId()+"");
                t1.setText(emp.getId().toString());
                t2.setText(emp.getUserId().toString());
                t3.setText(emp.getTitle());
                t4.setText(emp.getBody());
                send.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Bundle bundle = new Bundle();
                        bundle.putString("key",t3.getText().toString());

                        BlankFragment blankFragment = new BlankFragment();
                        blankFragment.setArguments(bundle);
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,blankFragment).commit();

                    }
                });


            }

            @Override
            public void onFailure(Call<Data> call, Throwable t) {
                Log.d("status",t.toString());


            }
        });
    }

    private void setAdapter(ArrayList<Data> employeelist) {

        MyListAdapter adapter = new MyListAdapter(employeelist);

        rv.setLayoutManager(new LinearLayoutManager(rv.getContext(),LinearLayoutManager.VERTICAL, false));
        rv.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }



}