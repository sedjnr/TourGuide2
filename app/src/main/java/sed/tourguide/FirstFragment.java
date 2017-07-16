package sed.tourguide;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class FirstFragment extends ListFragment {
    // Store instance variables
    private String title;
    private int page;

    // newInstance constructor for creating fragment with arguments
    public static FirstFragment newInstance(int page, String title) {
        FirstFragment fragmentFirst = new FirstFragment();
        Bundle args = new Bundle();
        args.putInt("someInt", page);
        args.putString("someTitle", title);
        fragmentFirst.setArguments(args);
        return fragmentFirst;
    }

    // Store instance variables page and title based on arguments passed
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        page = getArguments().getInt("someInt", 0);
        title = getArguments().getString("someTitle");
    }

    // Inflate the view for the fragment based on layout XML
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        // Creates an array list of random attractions
        ArrayList<Place> places = new ArrayList<Place>();
        //  Defines the content within the array list
        places.add(new Place(R.string.circustitle, R.string.circus, R.drawable.circus));
        places.add(new Place(R.string.bustitle, R.string.bus, R.drawable.bus));
        places.add(new Place(R.string.arcadetitle, R.string.arcade, R.drawable.arcade));
        places.add(new Place(R.string.paddlingtitle, R.string.paddling, R.drawable.paddling));
        places.add(new Place(R.string.panictitle, R.string.panic, R.drawable.panic));
        places.add(new Place(R.string.trampolinetitle, R.string.trampoline, R.drawable.trampoline));
        places.add(new Place(R.string.paintballingtitle, R.string.paintballing, R.drawable.paintballing));

        for (int index = 0; index < places.size(); index++) {
            PlaceAdapter adapter = new PlaceAdapter(getActivity(), places, R.color.colorFun);
            setListAdapter(adapter);
        }
        return view;
    }
}