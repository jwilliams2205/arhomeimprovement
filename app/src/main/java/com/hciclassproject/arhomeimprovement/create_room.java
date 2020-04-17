package com.hciclassproject.arhomeimprovement;

import android.annotation.SuppressLint;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.lang.reflect.Field;
import java.lang.reflect.Method;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link create_room#newInstance} factory method to
 * create an instance of this fragment.
 */
public class create_room extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private int xDelta;
    private int yDelta;
    private ViewGroup mainLayout;
    private ImageView couchImg;


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public create_room() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment create_room.
     */
    // TODO: Rename and change types and number of parameters
    public static create_room newInstance(String param1, String param2) {
        create_room fragment = new create_room();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @SuppressLint("ClickableViewAccessibility")
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

        return inflater.inflate(R.layout.fragment_create_room, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final Toast infoMessage = Toast.makeText(getActivity().getApplicationContext(), "Let's place furniture in the room, select the 'Place Furniture' button", Toast.LENGTH_LONG);
        infoMessage.setGravity(Gravity.TOP, 0, 0);
        infoMessage.show();

        couchImg = getActivity().findViewById(R.id.couch_create_pic);
        couchImg.setOnTouchListener(onTouchListener());
        view.findViewById(R.id.back_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                infoMessage.cancel();
                NavHostFragment.findNavController(create_room.this)
                        .navigate(R.id.action_create_room_to_home_page);
            }
        });

        view.findViewById(R.id.select_saved_furniture_button).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                final PopupMenu popup = new PopupMenu(getActivity(), getView().findViewById(R.id.remove_furniture_button));
                setForceShowIcon(popup);
                popup.getMenuInflater().inflate(R.menu.scan_furniture_menu, popup.getMenu());
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        couchImg.setVisibility(View.VISIBLE);
                        return false;
                    }
                });
                popup.show();
            }
        });

        view.findViewById(R.id.remove_furniture_button).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                final PopupMenu popup = new PopupMenu(getActivity(), getView().findViewById(R.id.remove_furniture_button));
                setForceShowIcon(popup);
                popup.getMenuInflater().inflate(R.menu.scan_furniture_menu, popup.getMenu());
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        couchImg.setVisibility(View.INVISIBLE);
                        return false;
                    }
                });
                popup.show();
            }
        });
    }

    public static void setForceShowIcon(PopupMenu popupMenu) {
        try {
            Field[] fields = popupMenu.getClass().getDeclaredFields();
            for (Field field : fields) {
                if ("mPopup".equals(field.getName())) {
                    field.setAccessible(true);
                    Object menuPopupHelper = field.get(popupMenu);
                    Class<?> classPopupHelper = Class.forName(menuPopupHelper
                            .getClass().getName());
                    Method setForceIcons = classPopupHelper.getMethod(
                            "setForceShowIcon", boolean.class);
                    setForceIcons.invoke(menuPopupHelper, true);
                    break;
                }
            }
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    private View.OnTouchListener onTouchListener() {
        return new View.OnTouchListener() {

            @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View view, MotionEvent event) {

                final int x = (int) event.getRawX();
                final int y = (int) event.getRawY();

                switch (event.getAction() & MotionEvent.ACTION_MASK) {

                    case MotionEvent.ACTION_DOWN:
                        RelativeLayout.LayoutParams lParams = (RelativeLayout.LayoutParams)
                                view.getLayoutParams();

                        xDelta = x - lParams.leftMargin;
                        yDelta = y - lParams.topMargin;
                        break;

                    case MotionEvent.ACTION_UP:
                        break;
                    case MotionEvent.ACTION_MOVE:
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view
                                .getLayoutParams();
                        layoutParams.leftMargin = x - xDelta;
                        layoutParams.topMargin = y - yDelta;
                        layoutParams.rightMargin = 0;
                        layoutParams.bottomMargin = 0;
                        view.setLayoutParams(layoutParams);
                        break;
                }
                return true;
            }
        };
    }
}