package com.hciclassproject.arhomeimprovement;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link home_page#newInstance} factory method to
 * create an instance of this fragment.
 */
public class home_page extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    Globals g = Globals.getInstance();

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public home_page() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment home_page.
     */
    // TODO: Rename and change types and number of parameters
    public static home_page newInstance(String param1, String param2) {
        home_page fragment = new home_page();
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
        return inflater.inflate(R.layout.fragment_home_page, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final Toast infoMessage;
        if(!g.getVisitedScan()) {
            infoMessage = Toast.makeText(getActivity().getApplicationContext(), "Start by selecting the 'Scan Furniture for AR' button", Toast.LENGTH_LONG);
            infoMessage.setGravity(Gravity.TOP, 0, 0);
            infoMessage.show();
            g.setVisitedScan();
        }
        else if(!g.getVisitedCreateRoom()){
            infoMessage = Toast.makeText(getActivity().getApplicationContext(), "Next, we can place furniture in your new room via the 'Create a Room Layout' button", Toast.LENGTH_LONG);
            infoMessage.setGravity(Gravity.TOP, 0, 0);
            infoMessage.show();
            g.setVisitedCreateRoom();
        }
        else if(!g.getVisitedViewScannedRooms()){
            infoMessage = Toast.makeText(getActivity().getApplicationContext(), "Finally, we can view a list of furniture we saved in the rooms via the 'View Saved Rooms' button", Toast.LENGTH_LONG);
            infoMessage.setGravity(Gravity.TOP, 0, 0);
            infoMessage.show();
            g.setVisitedViewScannedRooms();
        }
        else{
            infoMessage = Toast.makeText(getActivity().getApplicationContext(),"", Toast.LENGTH_SHORT);
        }

        view.findViewById(R.id.back_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                infoMessage.cancel();
                NavHostFragment.findNavController(home_page.this)
                        .navigate(R.id.action_home_page_to_sign_in);
            }
        });

        view.findViewById(R.id.scan_furniture_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                infoMessage.cancel();
                NavHostFragment.findNavController(home_page.this)
                        .navigate(R.id.action_home_page_to_scan_furniture);
            }
        });

        view.findViewById(R.id.room_layout_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                infoMessage.cancel();
                NavHostFragment.findNavController(home_page.this)
                        .navigate(R.id.action_home_page_to_create_room);
            }
        });
        view.findViewById(R.id.saved_rooms_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                infoMessage.cancel();
                NavHostFragment.findNavController(home_page.this)
                        .navigate(R.id.action_home_page_to_view_saved_rooms);
            }
        });
        view.findViewById(R.id.account_page_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                infoMessage.cancel();
                NavHostFragment.findNavController(home_page.this)
                        .navigate(R.id.action_home_page_to_account_page);
            }
        });
        view.findViewById(R.id.help_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                infoMessage.cancel();
                NavHostFragment.findNavController(home_page.this)
                        .navigate(R.id.action_home_page_to_help_page);
            }
        });
    }
}
