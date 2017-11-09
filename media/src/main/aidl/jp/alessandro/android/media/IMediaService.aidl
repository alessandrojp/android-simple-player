// IMediaServiceInterface.aidl
package jp.alessandro.android.media;

import jp.alessandro.android.media.IMediaServiceListener;
// Declare any non-default types here with import statements

interface IMediaService {

    void addPlaybackListener(IMediaServiceListener listener);
    void updateNotification(in Bundle metadata);
    void prepare(in Bundle trackInfo);
    void play();
    void pause();
    void stop();
    boolean isLoading();
    boolean isPlaying();
    boolean isPaused();
    boolean isStopped();
}