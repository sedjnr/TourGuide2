package sed.tourguide;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import  android.support.v4.app.Fragment;


public class MainActivity extends FragmentActivity {
    //Creates an adapter to display the page in fragments that can be accessed by the whole class
    FragmentPagerAdapter adapterViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Creates a view pager that initialises the fragment page adapter
        ViewPager pager = (ViewPager) findViewById(R.id.viewPager);
        adapterViewPager = new MyPagerAdapter(getSupportFragmentManager());
        pager.setAdapter(adapterViewPager);
    }

    public static class MyPagerAdapter extends FragmentPagerAdapter {
        // Defines the number of pages for fragments
        private static int NUM_ITEMS = 5;
        public MyPagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        // Returns total number of pages
        @Override
        public int getCount() {
            return NUM_ITEMS;
        }

        // Returns the fragment to display for that page
        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0: // Fragment # 0 - This will show WelcomeActivity
                    return WelcomeActivity.newInstance(0,"Page # 0");
                case 1: // Fragment # 1 - This will show FirstFragment
                    return FirstFragment.newInstance(1, "Page # 1");
                case 2: // Fragment # 2 - This will show SecondFragment
                    return SecondFragment.newInstance(2, "Page # 2");
                case 3: // Fragment # 1 - This will show ThirdFragment
                    return ThirdFragment.newInstance(3, "Page # 3");
                case 4:// Fragment # 1 - This will show FourthFragment
                    return FourthFragment.newInstance(4, "Page # 4");
                default:
                    return null;
            }
        }
        // Returns the page title for the top indicator
        @Override
        public CharSequence getPageTitle(int position) {
            return "Page " + position;
        }
    }
}



