package sed.tourguide;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by Sed on 08/07/2017.
 */

public class SecondFragment extends ListFragment {
    // Store instance variables
    private String title;
    private int page;

    // newInstance constructor for creating fragment with arguments
    public static SecondFragment newInstance(int page, int title) {
        SecondFragment fragmentSecond = new SecondFragment();
        Bundle args = new Bundle();
        args.putInt("someInt", page);
        args.putInt("someTitle", title);
        fragmentSecond.setArguments(args);
        return fragmentSecond;
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
        View view = inflater.inflate(R.layout.fragment_second, container, false);
        // Creates an ArrayList of Museums in London
        ArrayList<Place> places = new ArrayList<Place>();
        // Defines the content of the ArrayList
        places.add(new Place(R.string.nationaltitle, R.string.national, R.drawable.national));
        places.add(new Place(R.string.rafTitle, R.string.raf, R.drawable.raf));
        places.add(new Place(R.string.natgaltitle, R.string.natgal, R.drawable.natgal));
        places.add(new Place(R.string.londonmuseumtitle, R.string.londonmuseum, R.drawable.londonmuseum));
        places.add(new Place(R.string.tateTitle, R.string.tate, R.drawable.tate));
        places.add(new Place(R.string.scienceTitle, R.string.science, R.drawable.science));
        places.add(new Place(R.string.designtitle, R.string.design, R.drawable.design));

        for (int index = 0; index < places.size(); index++) {
            PlaceAdapter adapter = new PlaceAdapter(getActivity(), places, R.color.colorMuseums);
            setListAdapter(adapter);
        }
        return view;
    }
}