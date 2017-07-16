package sed.tourguide;

public class Place {
    // Defines variables which hold values for ArrayList
    private int mAttraction;
    private int mDescription;
    private int mImageResourceId;

    // Creates the place method which holds the variables for the ArrayAdapter
    public Place(int attraction, int description, int imageResourceId) {
        mAttraction = attraction;
        mDescription = description;
        mImageResourceId = imageResourceId;
    }

    // Methods used in PlaceAdapter to get values for the ArrayList after each iteration is updated
    public int getAttraction() {
        return mAttraction;
    }

    public int getDescription() {
        return mDescription;
    }

    public int getImageResourceId() {
        return mImageResourceId;
    }
}


