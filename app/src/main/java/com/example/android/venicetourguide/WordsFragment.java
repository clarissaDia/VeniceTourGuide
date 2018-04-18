package com.example.android.venicetourguide;


import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class WordsFragment extends Fragment {

    private MediaPlayer mMediaPlayer;
    private AudioManager mAudioManager;

    private AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT ||
                    focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                mMediaPlayer.pause();
                mMediaPlayer.seekTo(0);
            } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                mMediaPlayer.start();
            } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                releaseMediaPlayer();
            }
        }
    };

    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    };

    public WordsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.venice_list, container, false);
        mAudioManager = (AudioManager) getActivity().getSystemService(Context.AUDIO_SERVICE);

        final ArrayList <Venice> venice = new ArrayList<>();
        venice.add(new Venice(getString(R.string.gondola), getString(R.string.gondola_descr), R.drawable.ic_play_circle_filled_black,
                R.raw.gondola_audio));
        venice.add(new Venice(getString(R.string.calle), getString(R.string.calle_descr), R.drawable.ic_play_circle_filled_black,
                R.raw.calle_audio));
        venice.add(new Venice(getString(R.string.canale), getString(R.string.canale_descr), R.drawable.ic_play_circle_filled_black,
                R.raw.canale_audio));
        venice.add(new Venice(getString(R.string.rio), getString(R.string.rio_descr), R.drawable.ic_play_circle_filled_black,
                R.raw.rio_audio));
        venice.add(new Venice(getString(R.string.fondamenta), getString(R.string.fondamenta_descr), R.drawable.ic_play_circle_filled_black,
                R.raw.fondamenta_audio));
        venice.add(new Venice(getString(R.string.campo), getString(R.string.campo_descr), R.drawable.ic_play_circle_filled_black,
                R.raw.campo_audio));
        venice.add(new Venice(getString(R.string.sestriere), getString(R.string.sestriere_descr), R.drawable.ic_play_circle_filled_black,
                R.raw.sestriere_audio));

        VeniceAdapter adapter = new VeniceAdapter(getActivity(), venice);

        ListView listView = (ListView) rootView.findViewById(R.id.visit_list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                releaseMediaPlayer();
                Venice word = venice.get(position);

                int result = mAudioManager.requestAudioFocus(mOnAudioFocusChangeListener,
                        AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    mMediaPlayer = MediaPlayer.create(getActivity(), word.getAudioResourceId());
                    mMediaPlayer.start();
                    mMediaPlayer.setOnCompletionListener(mCompletionListener);
                }
            }
        });
                return rootView;
    }

    @Override
    public void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

    private void releaseMediaPlayer() {
        if (mMediaPlayer != null) {
            mMediaPlayer.release();
            mMediaPlayer = null;
            mAudioManager.abandonAudioFocus(mOnAudioFocusChangeListener);
        }
    }
}