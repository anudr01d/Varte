//package app.anudroid.com.varte.RAL;
//
//import android.app.Service;
//import android.content.Intent;
//import android.os.Handler;
//import android.os.IBinder;
//import android.support.annotation.Nullable;
//
//import java.util.Arrays;
//import java.util.List;
//
//import app.anudroid.com.varte.Application.Varte;
//import app.anudroid.com.varte.Models.Feed;
//import app.anudroid.com.varte.Models.Feeds;
//
///**
// * Created by Anudeep on 27/12/15.
// */
//public class ApiService extends Service {
//    List<String> urls = Arrays.asList(
//            "http://news.ycombinator.com/rss",
//            "http://2dopeboyz.com/feed",
//            "http://feeds2.feedburner.com/NdtvNews-TopStories",
//            "http://rss.slashdot.org/Slashdot/slashdotMain");
//    ApiImpl impl;
//    Handler handler;
//    @Nullable
//    @Override
//    public IBinder onBind(Intent intent) {
//        return null;
//    }
//
//    @Override
//    public int onStartCommand(Intent intent, int flags, int startId) {
//        handler = new Handler();
//        downloadData();
//        return START_NOT_STICKY;
//    }
//
//    private void runOnUiThread(Runnable runnable) {
//        handler.post(runnable);
//    }
//
//    private void downloadData() {
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    impl = new ApiImpl();
//                    for (String url : urls) {
//                        Feeds feeds = impl.fetchFeeds(url);
//                        if(feeds!=null) {
//                           final Feed fd = feeds.getQuery().getResults().getFeed();
//                            if(fd!=null) {
//                                runOnUiThread(new Runnable() {
//                                    @Override
//                                    public void run() {
//                                        Varte.getEventBus().post(fd);
//                                    }
//                                });
//                            }
//                        }
//                    }
//                }
//        }).start();
//    }
//
//}
