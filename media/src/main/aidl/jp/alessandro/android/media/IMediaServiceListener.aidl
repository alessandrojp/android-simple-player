// IMediaServiceListener.aidl
package jp.alessandro.android.media;

// Declare any non-default types here with import statements

interface IMediaServiceListener {

    oneway void onPlaybackStateChanged(int state);
    oneway void onPlaybackEnded();
    oneway void onPlaybackError(in Bundle error);
}