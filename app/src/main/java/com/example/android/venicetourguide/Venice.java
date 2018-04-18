package com.example.android.venicetourguide;

    public class Venice {

        private String mName;
        private String mDescription;
        private String mTime;
        private String mAddress;
        private String mPrice;
        private int mImageResourceId = NO_IMAGE_PROVIDED;
        private static final int NO_IMAGE_PROVIDED = -1;
        private int mAudioResourceId;

        public Venice (String name, String description, int imageResourceId) {
            mName = name;
            mDescription= description;
            mImageResourceId= imageResourceId;
        }

        public Venice (String name,String address, String time, String price){
            mName = name;
            mAddress = address;
            mTime = time;
            mPrice= price;
        }

        public Venice (String name, String description){
            mName = name;
            mDescription = description;

        }

        public Venice (String name, String description, int imageResourceId, int audioResourceId) {
            mName = name;
            mDescription = description;
            mImageResourceId = imageResourceId;
            mAudioResourceId = audioResourceId;
        }

        public String getName () {
            return mName;
        }

        public String getDescription () {
            return mDescription;
        }

        public String getTime () {
            return mTime;
        }

        public String getAddress () {
            return mAddress;
        }

        public String getPrice () {
            return mPrice;
        }

        public int getImageResourceId () {
            return mImageResourceId;
        }

        public boolean hasImage () {
            return mImageResourceId != NO_IMAGE_PROVIDED;
        }

        public int getAudioResourceId () {
            return mAudioResourceId;
        }
}

