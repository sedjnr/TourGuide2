package sed.tourguide;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class ThirdFragment extends ListFragment {
    // Store instance variables
    private String title;
    private int page;

    // newInstance constructor for creating fragment with arguments
    public static ThirdFragment newInstance(int page, int title) {
        ThirdFragment fragmentThird = new ThirdFragment();
        Bundle args = new Bundle();
        args.putInt("someInt", page);
        args.putInt("someTitle", title);
        fragmentThird.setArguments(args);
        return fragmentThird;
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
        View view = inflater.inflate(R.layout.fragment_third, container, false);
        // Creates an ArrayList of Restaurants in London
        ArrayList<Place> places = new ArrayList<Place>();
        // Defines the content of the ArrayList
        places.add(new Place(R.string.frenchtitle, R.string.french, R.drawable.french));
        places.add(new Place(R.string.fishtitle, R.string.fish, R.drawable.fish));
        places.add(new Place(R.string.samstitle, R.string.sams, R.drawable.sams));
        places.add(new Place(R.string.mexicanTitle, R.string.mexican, R.drawable.mexican));
        places.add(new Place(R.string.dinertitle, R.string.diner, R.drawable.diner));
        places.add(new Place(R.string.soultitle, R.string.soul, R.drawable.soul));
        places.add(new Place(R.string.shardtitle, R.string.duck, R.drawable.duck));

        for (int index = 0; index < places.size(); index++) {
            PlaceAdapter adapter = new PlaceAdapter(getActivity(), places, R.color.colorRestaurants);
            setListAdapter(adapter);
        }

        return view;
    }
}

