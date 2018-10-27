package Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import fragment.FragmentOne;



/**
 * Created by wolfsoft5 on 7/4/18.
 */

public class CategoryPagerAdapterMyBooking extends FragmentStatePagerAdapter {

        int mNoOfTabs;

        public CategoryPagerAdapterMyBooking(FragmentManager fm, int NumberOfTabs)

        {
                super(fm);
                this.mNoOfTabs = NumberOfTabs;
        }

        @Override
        public Fragment getItem(int position) {
                switch (position) {

                        case 0:
                                FragmentOne tab1 = new FragmentOne();
                                return tab1;
                        case 1:
                                FragmentOne tab2 = new FragmentOne();
                                return tab2;

                        case 2:
                                FragmentOne tab3 = new FragmentOne();
                                return tab3;

                        case 3:
                                FragmentOne tab4 = new FragmentOne();
                                return tab4;

                        case 4:
                        FragmentOne tab5 = new FragmentOne();
                        return tab5;



                        default:
                                return null;

                }
        }

        @Override
        public int getCount() {
                return mNoOfTabs;

        }
}

