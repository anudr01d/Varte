package app.anudroid.com.varte.RAL;

import android.app.Service;

import java.io.IOException;
import java.util.List;

import app.anudroid.com.varte.Application.Varte;
import app.anudroid.com.varte.Models.Feed;
import app.anudroid.com.varte.Models.Feeds;
import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;
import retrofit.http.Query;

/**
 * Created by Anudeep on 27/12/15.
 */
public class ApiImpl {

//    public void fetchHNFeed(String url) {
//        try {
//            ApiInterface api = ApiClient.getApiInterface();
//            Call<Feeds> feedList = api.feedList(String.format("select * from feednormalizer where url='%1$s' and output='atom_1.0'", url), "json");
//            feedList.enqueue(new Callback<Feeds>() {
//                @Override
//                public void onResponse(Response<Feeds> response, Retrofit retrofit) {
//                    int statusCode = response.code();
//                    app.anudroid.com.varte.Models.Feeds feeds = response.body();
//                    if(feeds!=null) {
//                        Feed ac = feeds.getQuery().getResults().getFeed();
//                        if (ac != null) {
//                            Varte.getEventBus().post(ac);
//                        }
//                    }
//                }
//                @Override
//                public void onFailure(Throwable t) {
//                }
//            });
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void fetchNDTVFeed(String url) {
//        try {
//            ApiInterface api = ApiClient.getApiInterface();
//            Call<Feeds> feedList = api.feedList(String.format("select * from feednormalizer where url='%1$s' and output='atom_1.0'", url), "json");
//            feedList.enqueue(new Callback<Feeds>() {
//                @Override
//                public void onResponse(Response<Feeds> response, Retrofit retrofit) {
//                    int statusCode = response.code();
//                    app.anudroid.com.varte.Models.Feeds feeds = response.body();
//                    if(feeds!=null) {
//                        Feed ac = feeds.getQuery().getResults().getFeed();
//                        if (ac != null) {
//                            Varte.getEventBus().post(ac);
//                        }
//                    }
//                }
//                @Override
//                public void onFailure(Throwable t) {
//                }
//            });
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void fetch2DBZFeed(String url) {
//        try {
//            ApiInterface api = ApiClient.getApiInterface();
//            Call<Feeds> feedList = api.feedList(String.format("select * from feednormalizer where url='%1$s' and output='atom_1.0'", url), "json");
//            feedList. enqueue(new Callback<Feeds>() {
//                @Override
//                public void onResponse(Response<Feeds> response, Retrofit retrofit) {
//                    int statusCode = response.code();
//                    app.anudroid.com.varte.Models.Feeds feeds = response.body();
//                    if(feeds!=null) {
//                        Feed ac = feeds.getQuery().getResults().getFeed();
//                        if (ac != null) {
//                            Varte.getEventBus().post(ac);
//                        }
//                    }
//                }
//                @Override
//                public void onFailure(Throwable t) {
//                }
//            });
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void fetchSLASHDOTFeed(String url) {
//        try {
//            ApiInterface api = ApiClient.getApiInterface();
//            Call<Feeds> feedList = api.feedList(String.format("select * from feednormalizer where url='%1$s' and output='atom_1.0'", url), "json");
//            feedList. enqueue(new Callback<Feeds>() {
//                @Override
//                public void onResponse(Response<Feeds> response, Retrofit retrofit) {
//                    int statusCode = response.code();
//                    app.anudroid.com.varte.Models.Feeds feeds = response.body();
//                    if(feeds!=null) {
//                        Feed ac = feeds.getQuery().getResults().getFeed();
//                        if (ac != null) {
//                            Varte.getEventBus().post(ac);
//                        }
//                    }
//                }
//                @Override
//                public void onFailure(Throwable t) {
//                }
//            });
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void fetchFORBESFeed(String url) {
//        try {
//            ApiInterface api = ApiClient.getApiInterface();
//            Call<Feeds> feedList = api.feedList(String.format("select * from feednormalizer where url='%1$s' and output='atom_1.0'", url), "json");
//            feedList. enqueue(new Callback<Feeds>() {
//                @Override
//                public void onResponse(Response<Feeds> response, Retrofit retrofit) {
//                    int statusCode = response.code();
//                    app.anudroid.com.varte.Models.Feeds feeds = response.body();
//                    if(feeds!=null) {
//                        Feed ac = feeds.getQuery().getResults().getFeed();
//                        if (ac != null) {
//                            Varte.getEventBus().post(ac);
//                        }
//                    }
//                }
//                @Override
//                public void onFailure(Throwable t) {
//                }
//            });
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void fetchTOIFeed(String url) {
//        try {
//            ApiInterface api = ApiClient.getApiInterface();
//            Call<Feeds> feedList = api.feedList(String.format("select * from feednormalizer where url='%1$s' and output='atom_1.0'", url), "json");
//            feedList. enqueue(new Callback<Feeds>() {
//                @Override
//                public void onResponse(Response<Feeds> response, Retrofit retrofit) {
//                    int statusCode = response.code();
//                    app.anudroid.com.varte.Models.Feeds feeds = response.body();
//                    if(feeds!=null) {
//                        Feed ac = feeds.getQuery().getResults().getFeed();
//                        if (ac != null) {
//                            Varte.getEventBus().post(ac);
//                        }
//                    }
//                }
//                @Override
//                public void onFailure(Throwable t) {
//                }
//            });
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void fetchOVOFeed(String url) {
//        try {
//            ApiInterface api = ApiClient.getApiInterface();
//            Call<Feeds> feedList = api.feedList(String.format("select * from feednormalizer where url='%1$s' and output='atom_1.0'", url), "json");
//            feedList. enqueue(new Callback<Feeds>() {
//                @Override
//                public void onResponse(Response<Feeds> response, Retrofit retrofit) {
//                    int statusCode = response.code();
//                    app.anudroid.com.varte.Models.Feeds feeds = response.body();
//                    if(feeds!=null) {
//                        Feed ac = feeds.getQuery().getResults().getFeed();
//                        if (ac != null) {
//                            Varte.getEventBus().post(ac);
//                        }
//                    }
//                }
//                @Override
//                public void onFailure(Throwable t) {
//                }
//            });
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}
