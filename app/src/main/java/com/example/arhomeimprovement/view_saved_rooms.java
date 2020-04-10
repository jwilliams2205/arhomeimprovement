package com.example.arhomeimprovement;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link view_saved_rooms#newInstance} factory method to
 * create an instance of this fragment.
 */
public class view_saved_rooms extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public view_saved_rooms() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment view_saved_rooms.
     */
    // TODO: Rename and change types and number of parameters
    public static view_saved_rooms newInstance(String param1, String param2) {
        view_saved_rooms fragment = new view_saved_rooms();
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
        return inflater.inflate(R.layout.fragment_view_saved_rooms, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.back_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(view_saved_rooms.this)
                        .navigate(R.id.action_view_saved_rooms_to_home_page);
            }
        });

        view.findViewById(R.id.view_furniture_in_saved_room).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                final PopupMenu popup = new PopupMenu(getActivity(), getView().findViewById(R.id.view_furniture_in_saved_room));
                popup.getMenuInflater().inflate(R.menu.saved_rooms_menu, popup.getMenu());
                popup.show();
            }
        });

        view.findViewById(R.id.delete_saved_room_button).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                final PopupMenu popup = new PopupMenu(getActivity(), getView().findViewById(R.id.delete_saved_room_button));
                popup.getMenuInflater().inflate(R.menu.saved_rooms_menu, popup.getMenu());
                popup.show();
            }
        });
    }
}
