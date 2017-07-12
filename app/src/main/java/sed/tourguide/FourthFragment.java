package sed.tourguide;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by Sed on 09/07/2017.
 */

public class FourthFragment extends ListFragment {
    // Store instance variables
    private String title;
    private int page;

    // newInstance constructor for creating fragment with arguments
    public static FourthFragment newInstance(int page, String title) {
        FourthFragment fragmentFourth = new FourthFragment();
        Bundle args = new Bundle();
        args.putInt("someInt", page);
        args.putString("someTitle", title);
        fragmentFourth.setArguments(args);
        return fragmentFourth;
    }
    // Store instance variables based on arguments passed
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
        View view = inflater.inflate(R.layout.fragment_fourth, container, false);
        // Creates an ArrayList of Attractions in London
        ArrayList<Place> places = new ArrayList<Place>();
        // Defines conted of the ArrayList
        places.add(new Place("Byron Park (National Park)",R.string.park,R.drawable.park));
        places.add(new Place("The Big Ben(Clock Tower)",R.string.bigben,R.drawable.bigben));
        places.add(new Place("The London Eye (Ferris Wheel)",R.string.londoneye,R.drawable.londoneye));
        places.add(new Place("Princess Diana Memorial (Fountain)",R.string.diana,R.drawable.diana));;
        places.add(new Place("Gunwharf Quays (Shopping Centre)",R.string.gunwharf,R.drawable.gunwharf));
        places.add(new Place("The Shard (Tallest Building)",R.string.shard,R.drawable.shard));
        places.add(new Place("Tower of London (Castle)",R.string.tower,R.drawable.tower));

        for (int index = 0; index < places.size(); index++) {
            PlaceAdapter adapter = new PlaceAdapter(getActivity(),places,R.color.colorSites);
            setListAdapter(adapter);
        }
        return view;
    }
}
